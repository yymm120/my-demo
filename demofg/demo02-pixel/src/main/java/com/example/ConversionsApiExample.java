package com.example;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


import com.facebook.ads.sdk.APIContext;
        import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.serverside.*;

import java.util.ArrayList;
        import java.util.Arrays;

        import java.util.List;

public class ConversionsApiExample {

    public static final String ACCESS_TOKEN = "EAAKLZA0wFwuwBAP3AuWRv8oAzBXLdyYftFdA2ZBfsuY3Wom04ETySoMLZBaoEJJnAUPZCwSLX9ZAck67Unj5xIcNZBilYpPoTQoOsTVR4lbgNZCyl7d51t0sHakdbEuVyBZC1iije4azo55lnbBjZBbl5mhf1BcCjJeNe1ADCgb5QZAOvUCcEzbQKZBXy55hHr2ZCKgZD";
    public static final String PIXEL_ID = "944408690055580";

    public static void main(String[] args) throws MalformedURLException {
        APIContext context = new APIContext(ACCESS_TOKEN).enableDebug(true);
        context.setLogger(System.out);
        List<Event> events = new ArrayList<>();

        UserData userData_0 = new UserData()
                .emails(Arrays.asList("7b17fb0bd173f625b58636fb796407c22b3d16fc78302d79f0fd30c2fc2fc068"))
                .phones(Arrays.asList());

        CustomData customData_0 = new CustomData()
                .value(142.52f)
                .currency("USD");

        Event event_0 = new Event()
                .eventName("Purchase")
                .eventTime(1675611364L)
                .userData(userData_0)
                .customData(customData_0)
                .actionSource(ActionSource.email);
        events.add(event_0);


        EventRequest eventRequest = new EventRequest(PIXEL_ID, context)
                .data(events);
        eventRequest.setTestEventCode("TEST18648");

        try {
            System.setProperty("http.proxyHost", "127.0.0.1");
            System.setProperty("http.proxyPort", "7890");
            System.setProperty("https.proxyHost", "127.0.0.1");
            System.setProperty("https.proxyPort", "7890");
            EventResponse response = eventRequest.execute();
            System.clearProperty("http.proxyHost");
            System.out.printf("Standard API response : %s ", response);
        } catch (APIException e) {
            e.printStackTrace();
        }
    }
}