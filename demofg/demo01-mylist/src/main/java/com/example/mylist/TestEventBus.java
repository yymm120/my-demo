package com.example.mylist;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;


public class TestEventBus {

    public class TestEvent {
        private final int message;
        public TestEvent(int message) {
            this.message = message;
            System.out.println("event message:"+message);
        }
        public int getMessage() {
            return message;
        }
    }

    public class EventListener {
        public int lastMessage = 0;

        @Subscribe
        public void listen(TestEvent event) {
            lastMessage = event.getMessage();
            System.out.println("Message:"+lastMessage);
        }

        public int getLastMessage() {
            return lastMessage;
        }
    }

    @Test
    public void testReceiveEvent() throws Exception {

        EventBus eventBus = new EventBus("test");
        EventListener listener = new EventListener();

        new AsyncEventBus(MoreExecutors.directExecutor());

        eventBus.register(listener);

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));
        eventBus.post(new TestEvent(400));

        System.out.println("LastMessage:"+listener.getLastMessage());

        eventBus.unregister(listener);

        eventBus.post(new TestEvent(500));

        System.out.println("LastMessage:"+listener.getLastMessage());
    }

    @Test
    void test02(){
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap1 = new LinkedHashMap<>();
        System.out.println(objectObjectLinkedHashMap1 == objectObjectLinkedHashMap);
    }

}