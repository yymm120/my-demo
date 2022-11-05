package com.example.java8demo.serialize.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

@SpringBootTest
public class Demo01ClassAnnotationTest {

    /**
     * https://blog.csdn.net/boling_cavalry/article/details/108589494
     * @throws JsonProcessingException
     */
    @Test
    void test01() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // 美化输出
        ObjectMapper enable = mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // 开启root对象特性
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        com.pojo.Test test = new com.pojo.Test();
        test.setField01("123");
        System.out.println(mapper.writeValueAsString(test));
    }


    @Test
    void test02() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\n" +
                "    \"giftListId\": \"gl73140005\",\n" +
                "    \"sessionNumber\": \"{{sessionNumber}}\",\n" +
                "    \"operationType\": \"moveList\",\n" +
                "    \"oldGroupId\": \"87200001\",\n" +
                "    \"groupId\": \"67000009\"\n" +
                "}";
        mapper.readValue(json, new TypeReference<Map<String, Object>>() {});
    }

    static class MapXssDeserializer extends MapDeserializer{
        public MapXssDeserializer(JavaType mapType, ValueInstantiator valueInstantiator, KeyDeserializer keyDeser, JsonDeserializer<Object> valueDeser, TypeDeserializer valueTypeDeser) {
            super(mapType, valueInstantiator, keyDeser, valueDeser, valueTypeDeser);
        }

        @Override
        public Map<Object, Object> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            System.out.println(p);
            return super.deserialize(p, ctxt);
        }
    }

    @Test
    void test03() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule xssModule = new SimpleModule("XssStringJsonSerializer");
        // xssModule.addDeserializer(String.class, new MapXssDeserializer());
    }




    public static String cleanXSS(String value) {
        //屏蔽掉xss攻击和sql注入等危险字符
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
        value = value.replaceAll("'", "&#39;");
        value = value.replaceAll("\"", "&#34;");
        value = value.replaceAll("\\\\", "");
        value = value.replaceAll("\\\\/", "");
        value = value.replaceAll("eval\\((.*)\\)", "");
        value = value.replaceAll("e-xpression\\\\((.*?)\\\\)\"", "");
        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("[\\\"\\\'][\\s]*vbscript:(.*)[\\\"\\\']", "\"\"");
        value = value.replaceAll("[\\\"\\\'][\\s]*onload:(.*)[\\\"\\\']", "\"\"");
        return value;
    }




    private final static Pattern[] PATTERNS = new Pattern[]{
            // Script fragments
            Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE),
            // src='...'
            Pattern.compile("src[\r\n]*=[\r\n]*\'(.*?)\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("src[\r\n]*=[\r\n]*\"(.*?)\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // lonely script tags
            Pattern.compile("</script>", Pattern.CASE_INSENSITIVE),
            Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // eval(...)
//			Pattern.compile("eval\((.*?)\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // expression(...)
//			Pattern.compile("expression\((.*?)\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // javascript:...
            Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE),
            // vbscript:...
            Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE),
            //
//			Pattern.compile("[\s'"]+", Pattern.CASE_INSENSITIVE),
            // onload(...)=...
            Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            // alert
            Pattern.compile("alert(.*?)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile("<", Pattern.MULTILINE | Pattern.DOTALL),
            Pattern.compile(">", Pattern.MULTILINE | Pattern.DOTALL),
            //Checks any html tags i.e. <script, <embed, <object etc.
            Pattern.compile("(<(script|iframe|embed|frame|frameset|object|img|applet|body|html|style|layer|link|ilayer|meta|bgsound))")
    };




    @Test
    void test999(){
        String[] strings = new String[]{"1"};
        Object[] objects = {"1"};
        boolean a = strings instanceof String[];
        boolean b = objects instanceof Object[];
        boolean c = strings instanceof Object[];
        System.out.printf("");
    }
}
