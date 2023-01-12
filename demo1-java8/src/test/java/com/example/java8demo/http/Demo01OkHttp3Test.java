package com.example.java8demo.http;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
// import jdk.internal.joptsimple.internal.Strings;
// import com.google.common.reflect.TypeCapture;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.Nullable;

import javax.print.DocFlavor;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class Demo01OkHttp3Test {

    static Logger logger = LoggerFactory.getLogger(Demo01OkHttp3Test.class.getName());
    static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    static OkHttpClient client = new OkHttpClient();

    static Request buildRequest(String url, MediaType type, String requestBody){
        if (StringUtils.isNotBlank(requestBody)){
            return new Request.Builder().url(url).build();
        }
        return new Request.Builder().url(url)
                .post(RequestBody.create(requestBody, type))
                .build();
    }

    static Response tryGetResponse(Request request){
        Response result = null;
        try(Response response = client.newCall(request).execute()){
            if (!response.isSuccessful()) throw new IOException("Unexpected code" + response);
            result = response;
            // logger.info(responseText);
            // Headers responseHeaders = response.headers();
            // for (int i = 0; i < responseHeaders.size(); i++) {
            //     logger.info(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            // }
            // logger.info(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    static String getText(Response response){
        String text = null;
        try {
            text = response.body().source().readUtf8();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    @Test
    void test01_sync_async_postRequest(){
        System.out.println("h");
        StopWatch watch = StopWatch.createStarted();

        String requestBody = "{\n" +
                "    \"product\": [\n" +
                "        \"3276626\", \"311788\", \"311789\", \"3276590\", \"3276593\", \"3276596\", \"3276602\", \"3276600\", \"3276617\", \"3276622\", \"3276614\", \"3276624\", \"3276627\", \"3276630\", \"3083383\", \"3877119\", \"3877110\", \"1613205\", \"1686421\", \"226146\", \"3876269\", \"4069913\", \"531276\", \"4488135\", \"2493657\", \"4065437\", \"1357205\", \"1599199\", \"1376929\", \"1376927\", \"794937\", \"122541\", \"3402489\", \"1325727\", \"1332693\", \"1635169\", \"794585\", \"3266928\", \"3266927\", \"270280\", \"3879352\", \"3879349\", \"3879353\", \"1132544\", \"854953\", \"854952\", \"854908\", \"1339592\", \"1361823\", \"1120363\", \"2481627\", \"1025015\", \"4087094\", \"4443344\", \"1855794\", \"1855793\", \"1855795\", \"1855799\", \"1855804\", \"4478649\", \"4478650\", \"4478648\", \"4478647\", \"2148684\", \"1855807\", \"1855810\", \"1855827\", \"1855812\", \"2167726\", \"1855764\", \"1855771\", \"2148678\", \"1855780\", \"1855846\", \"1855774\", \"2354558\", \"1855763\", \"1855842\", \"2354474\", \"1855840\", \"1707875\", \"1855836\", \"1855838\", \"2148668\", \"2354295\", \"1855824\", \"2353912\", \"1855809\", \"1855826\", \"1855828\", \"1855829\", \"1855831\", \"1855832\", \"1855833\", \"2031406\", \"1855772\", \"3616719\", \"3616718\", \"3616723\", \"3616722\", \"3876464\", \"3876465\", \"3876521\", \"3876524\", \"3679101\", \"3317138\", \"3317140\", \"3317149\", \"3317105\", \"1595418\", \"1622391\", \"1622408\", \"1622387\", \"1666266\", \"1666267\", \"1666268\", \"1666269\", \"1434983\", \"1434987\", \"4663844\", \"4663875\", \"1730610\", \"2181768\", \"4711859\", \"4663843\", \"3909681\", \"3909678\", \"3909676\", \"1431101\", \"1431098\", \"1431032\", \"1431035\", \"4091864\", \"4091862\", \"3003402\", \"3003399\", \"3003405\", \"3003404\", \"3792308\", \"3757127\", \"3757136\", \"4249868\", \"4008733\", \"2911025\", \"4482494\", \"4034846\", \"3757600\", \"4516297\", \"4200898\", \"4719907\", \"4719905\", \"4719901\", \"4719906\", \"4719904\", \"4719897\", \"4719902\", \"4719903\", \"4773342\", \"4742461\", \"4719898\", \"4773343\", \"4478891\", \"4482495\", \"4482496\", \"4482497\", \"1074480\", \"4663845\", \"3406139\", \"3792302\", \"3420491\", \"1434961\", \"1071872\", \"1434976\", \"4338545\", \"4338540\", \"4076184\", \"4076181\", \"4076187\", \"3520045\", \"4076182\", \"3520046\", \"4076188\", \"4711844\", \"4711854\", \"4711870\", \"3406149\", \"1072987\", \"3643435\", \"4262645\", \"3643418\", \"1074398\", \"4338550\", \"3766252\", \"3266012\", \"4155725\", \"4155726\", \"4637228\", \"3333934\", \"1763138\", \"2405616\", \"2405615\", \"3616802\", \"1763139\", \"2971299\", \"2971305\", \"4036251\", \"17101\", \"2227643\", \"17458\", \"17810\", \"17985\", \"2190427\", \"942301\", \"2448025\", \"1892629\", \"3767089\", \"1598390\", \"1245188\", \"765784\", \"187644\", \"422535\", \"1609798\", \"1596682\", \"2480802\", \"422539\", \"422536\", \"1584207\", \"249554\", \"4572014\", \"4572015\", \"4639034\", \"4639035\", \"4572013\", \"1025427\", \"1025386\", \"2247445\", \"2446030\", \"2390127\", \"3775208\", \"2491653\", \"106958\", \"3339742\", \"3339815\", \"3339735\", \"3339702\", \"3339794\", \"3449779\", \"3449780\", \"3449781\", \"3449782\", \"3339798\", \"3339743\", \"449512\", \"2904164\", \"3515701\", \"335840\", \"335843\", \"335878\", \"335880\", \"1792651\", \"1792654\", \"2833549\", \"2833548\", \"1792660\", \"1792652\", \"985091\", \"985090\", \"76059\", \"76060\", \"2240860\", \"3351658\", \"3351858\", \"4121356\", \"1392005\", \"1392006\", \"3352630\", \"2463906\", \"2463907\", \"2463892\", \"2463898\", \"2463899\", \"2463888\", \"2463889\", \"2463890\", \"2463891\", \"2463901\", \"2463895\", \"2463896\", \"2463908\", \"2463894\", \"2463900\", \"2463904\", \"1135285\", \"249558\", \"1135307\", \"1392007\", \"547752\", \"1135282\", \"358067\", \"4065669\", \"3756542\", \"3756512\", \"3756521\", \"3757132\", \"3643150\", \"3757159\", \"3756297\", \"4632226\", \"3785915\", \"3756448\", \"3756442\", \"3756459\", \"3643152\", \"3757027\", \"3757055\", \"3756534\", \"3756522\", \"3757823\", \"3757816\", \"3643153\", \"3756659\", \"3757351\", \"3757485\", \"3757495\", \"3757329\", \"3757195\", \"3643154\", \"3757258\", \"3757280\", \"3756684\", \"4204493\", \"4227773\", \"4065670\", \"4065661\", \"4065657\", \"4065665\", \"4065672\", \"4075966\", \"493076\", \"493077\", \"4706517\", \"4706518\", \"4579666\", \"302307\", \"1095721\", \"1095718\", \"1095724\", \"3700915\", \"3700995\", \"2347392\", \"2177959\", \"2390792\", \"2390793\", \"2972114\", \"3571051\", \"2390794\", \"2972115\", \"2972116\", \"3571046\", \"3571049\", \"3571047\", \"3571050\", \"4434143\", \"1255725\", \"1096483\", \"1392036\", \"1392027\", \"1392038\", \"1392034\", \"3350885\", \"1392040\", \"1392035\", \"2885516\", \"1392044\", \"1391999\", \"1134362\", \"1438203\", \"3670131\", \"486941\", \"1947822\", \"1233240\", \"1686433\", \"1392025\", \"855030\", \"855031\", \"4383344\", \"3875192\", \"2964550\", \"3624887\", \"2337868\", \"2964549\", \"2964552\", \"3624888\", \"2964556\", \"2337866\", \"2964553\", \"2964557\", \"4336517\", \"105337\", \"105338\", \"2964555\", \"306259\", \"105340\", \"2337865\", \"426591\", \"426592\", \"3093585\", \"133238\", \"105729\", \"97358\", \"274148\", \"97515\", \"426584\", \"426586\", \"522779\", \"77879\", \"77827\", \"97505\", \"195881\", \"77829\", \"426604\", \"174542\", \"3512158\", \"174540\", \"3876324\", \"3876316\", \"3876315\", \"1076621\", \"2351745\", \"1914506\", \"2174512\", \"1847278\", \"3928681\", \"3925626\", \"1754299\", \"1283490\", \"1775296\", \"3080312\", \"50356\", \"106324\", \"106325\", \"220624\", \"230409\", \"851476\", \"511608\", \"223567\", \"1775399\", \"1068458\", \"514039\", \"310855\", \"511687\", \"220198\", \"962767\", \"962975\", \"3775972\", \"3077760\", \"3333090\", \"1775308\", \"140671\", \"106327\", \"140669\", \"140676\", \"34736\", \"1261507\", \"171882\", \"230420\", \"171884\", \"171881\", \"55657\", \"140677\", \"1072964\", \"1855791\", \"277780\", \"54831\", \"179703\", \"179704\", \"4416330\", \"522797\", \"1070560\", \"4416329\", \"183827\", \"4416327\", \"4416328\", \"3420474\", \"3395595\", \"3157332\", \"4632292\", \"4081229\", \"963112\", \"737726\", \"2474905\", \"2474906\", \"2474907\", \"2490780\", \"2474908\", \"2493604\", \"3333027\", \"1925500\", \"2474590\", \"1926363\"\n" +
                "    ],\n" +
                "    \"acctId\": [\n" +
                "        \"SEATTLE\",\n" +
                "        \"DIST\",\n" +
                "        \"ATLANTA\"\n" +
                "    ],\n" +
                "    \"whseId\": [\n" +
                "        \"3007\"\n" +
                "    ]\n" +
                "}";

        Request request = buildRequest("http://uatapi.sys.ds.wolseley.com/inventory/v1/list", JSON, requestBody);


        Response response = tryGetResponse(request);
        String text = getText(response);
        logger.info(text);

    }

    @Test
    void test02(){
        Request request = buildRequest("http://www.localdev.ferguson.com/misc/ajax/shareListDetailModal.jsp?giftListId=gl28960027&_=1658900366027", JSON, null);
        Response response = tryGetResponse(request);
        String text = getText(response);
    }

    @Test
    void test03(){
        Request request = buildRequest("https://api.github.com/gists/c2a7c39532239ff261be", JSON, null);
        // converter.
        Response response = tryGetResponse(request);
    }

    @Test
    void test04(){
        // Type capture = new TypeCapture<List<String>[]>() {
        // }.capture();
    }



}
