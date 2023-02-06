package com.example;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.PlaceTopic;
import com.facebook.ads.sdk.serverside.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MetaPixelTestClient {
    // public static final String ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");
    // public static final String PIXEL_ID = System.getenv("PIXEL_ID");
    static String accessToken = "EAAKLZA0wFwuwBAP3AuWRv8oAzBXLdyYftFdA2ZBfsuY3Wom04ETySoMLZBaoEJJnAUPZCwSLX9ZAck67Unj5xIcNZBilYpPoTQoOsTVR4lbgNZCyl7d51t0sHakdbEuVyBZC1iije4azo55lnbBjZBbl5mhf1BcCjJeNe1ADCgb5QZAOvUCcEzbQKZBXy55hHr2ZCKgZD";
    static String pixelId = "944408690055580";

    public static void run() throws Exception {
        if (accessToken == null || pixelId == null) {
            throw new Exception(String.format("Missing required test config. Got pixel_id: '%s', access_token: '%s'", pixelId, accessToken));
        }

        APIContext.disableCrashReport();
        APIContext context = new APIContext(accessToken).enableDebug(true);
        context.setLogger(System.out);

        UserData userData = new UserData()
                .emails(Arrays.asList("7b17fb0bd173f625b58636fb796407c22b3d16fc78302d79f0fd30c2fc2fc068"))
                .phones(Arrays.asList());


        HashMap<String, String> customProperties = new HashMap<>();
        customProperties.put("item_number", "456");

        CustomData customData = new CustomData()
                .currency("usd")
                .customProperties(customProperties)
                .value(123.45F);

        Event pageViewEvent = new Event();
        pageViewEvent.eventName("Purchase")
                .eventTime(System.currentTimeMillis() / 1000L)
                .userData(userData)
                .customData(customData)
                // .eventSourceUrl("http://jaspers-market.com/product/123")
                .actionSource(ActionSource.email);
                // .actionSource(ActionSource.website);

        EventRequest eventRequest = new EventRequest(pixelId, context);
        eventRequest.setTestEventCode("TEST18648");
        eventRequest.addDataItem(pageViewEvent);

        // Set the Custom HTTP Service Client
        HttpServiceInterface httpServiceClient = new E2EHttpServiceClient();
        eventRequest.setHttpServiceClient(httpServiceClient);

        EventResponse eventResponse = eventRequest.execute();
        System.out.println("Request was successful:");
        System.out.println(eventResponse);
    }

    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            System.exit(1);
        }
        System.exit(0);
    }

    private static class E2EHttpServiceClient implements HttpServiceInterface {
        @Override
        public EventResponse executeRequest(String url, HttpMethodEnum httpMethod, Map<String, String> headers, HttpServiceParams params) {
            EventResponse eventResponse = null;
            try {
                Gson gson = new GsonBuilder()
                        .disableHtmlEscaping()
                        .create();
                URL requestUrl = new URL(url);

                HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
                connection.setRequestMethod(httpMethod.toString());
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");

                DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                out.writeBytes(gson.toJson(params));
                out.flush();
                out.close();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );
                String responseLine = in.readLine();
                StringBuffer response = new StringBuffer();
                while (responseLine != null) {
                    response.append(responseLine);
                    responseLine = in.readLine();
                }
                in.close();
                String responseString = response.toString();

                eventResponse = gson.fromJson(responseString, EventResponse.class);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
            return eventResponse;
        }
    }
}
