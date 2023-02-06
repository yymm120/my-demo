package com.example;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.serverside.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MetaPixelTestDroplet {

    public String result = null;
    public String accessToken = null;
    public String pixelId = null;
    public String json = null;




    private EventRequest getEventRequest(APIContext context, int num) {
        UserData userData = new UserData()
                .email(String.format("joe%s@eg.com", num))
               .clientIpAddress("127.0.0.1")
               .clientUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");

        HashMap<String, String> customProperties = new HashMap<>();
        customProperties.put("custom1", "value2");

        CustomData customData = new CustomData()
                .currency("usd")
                .customProperties(customProperties)
                .value(123.45F);

        Event pageViewEvent = new Event();
        pageViewEvent.eventName("Purchase")
                .eventTime(System.currentTimeMillis() / 1000L)
                .userData(userData)
                .customData(customData)
                .actionSource(ActionSource.website);
                // .eventSourceUrl("http://jaspers-market.com/product/123")

        EventRequest eventRequest = new EventRequest(pixelId, context);
        eventRequest.addDataItem(pageViewEvent);
        eventRequest.setTestEventCode("TEST18648");

        return eventRequest;
    }

    public void run() throws Exception {
        accessToken = "EAAKLZA0wFwuwBACOXFWdTzqPFxsVLw9OqdrQyZBUjfNhKHk7OAIFZAFCuhtvEnZCTzuuYvO5xDSLHlZBIYFkgk0PQSvCpcpOsAH2zAsQp20vBIHehV1v3oQMLtCpv1cKZB4jEjlYKRTILlAzK9Rys7QbRx5YkPx9glbcpnN3YFcZCSvFgweeZChsyHN7hNhxuHIZD";
        pixelId = "944408690055580";
        if (accessToken == null || pixelId == null) {
            throw new Exception(String.format("Missing required test config. Got pixel_id: '%s', access_token: '%s'", pixelId, accessToken));
        }
        APIContext context = new APIContext(accessToken);
        APIContext.disableCrashReport();
        context.setLogger(System.out);

        EventRequest asyncRequest = getEventRequest(context, 1);

        System.out.println("request" + new ObjectMapper().configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true).writerWithDefaultPrettyPrinter().writeValueAsString(asyncRequest));
        final ListenableFuture<EventResponse> requestFuture = asyncRequest.executeAsync();
        EventResponse asyncResponse = requestFuture.get();

        List<ListenableFuture<EventResponse>> eventFutures = new ArrayList<>();
        eventFutures.add(getEventRequest(context, 2).executeAsync());
        eventFutures.add(getEventRequest(context, 3).executeAsync());
        eventFutures.add(getEventRequest(context, 4).executeAsync());
        List<EventResponse> asyncResponses = Futures
                .allAsList(eventFutures)
                .get();
       System.out.println(String.format("Multiple Async Requests - OK: %s", asyncResponses));
        result = new ObjectMapper().writeValueAsString(asyncResponses);
        wait(1000);
        System.out.println("1000");
        wait(1000);
        System.out.println("1000");
        wait(1000);
        System.out.println("1000");
        wait(1000);
        System.out.println("1000");
        wait(1000);
        System.out.println("1000");
        wait(1000);
        System.out.println("1000");
    }

}


