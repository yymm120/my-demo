package com.demospring;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smbms.pojo.MyBean;
import org.apache.commons.lang3.time.StopWatch;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.mock.http.MockHttpInputMessage;
import org.springframework.mock.http.MockHttpOutputMessage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@SpringBootTest
public class Demo01Jackson2HttpTest {

    @Test
    void test01() throws IOException, JSONException {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter() {
            @Override
            protected JavaType getJavaType(Type type, @Nullable Class<?> contextClass) {
                if (type instanceof Class && List.class.isAssignableFrom((Class<?>)type)) {
                    return new ObjectMapper().getTypeFactory().constructCollectionType(ArrayList.class, MyBean.class);
                }
                else {
                    return super.getJavaType(type, contextClass);
                }
            }
        };
        String body = "[{" +
                "\"bytes\":\"AQI=\"," +
                "\"array\":[\"Foo\",\"Bar\"]," +
                // "\"number\":42," +
                "\"string\":\"Foo\"," +
                "\"bool\":true," +
                "\"fraction\":42.0}]";
        MockHttpInputMessage inputMessage = new MockHttpInputMessage(body.getBytes(StandardCharsets.UTF_8));
        inputMessage.getHeaders().setContentType(new MediaType("application", "json"));

        StopWatch stopWatch = new StopWatch();
        StopWatch q = stopWatch.createStarted();
        List<MyBean> results = (List<MyBean>) converter.read(List.class, inputMessage);
        q.stop();
        System.out.println(q.getTime());
        assertThat(results.size()).isEqualTo(1);
        MyBean result = results.get(0);
        assertThat(result.getString()).isEqualTo("Foo");
        assertThat(result.getNumber()).isEqualTo(42);
        assertThat(result.getFraction()).isCloseTo(42F, within(0F));
        assertThat(result.getArray()).isEqualTo(new String[] {"Foo", "Bar"});
        assertThat(result.isBool()).isTrue();
        assertThat(result.getBytes()).isEqualTo(new byte[] {0x1, 0x2});

        MockHttpOutputMessage outputMessage = new MockHttpOutputMessage();
        converter.write(results, MediaType.APPLICATION_JSON, outputMessage);
        JSONAssert.assertEquals(body, outputMessage.getBodyAsString(StandardCharsets.UTF_8), true);
    }

    @Test
    void test2(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

    }

}
