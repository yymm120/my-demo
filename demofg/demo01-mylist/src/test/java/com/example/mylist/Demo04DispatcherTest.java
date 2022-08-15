// package com.example.mylist;
//
// import com.example.mylist.Annotation.MyListMapping;
// import com.example.mylist.dispatcher.SimpleMyListDispatcher;
// import org.apache.commons.lang3.ClassUtils;
// import org.apache.commons.lang3.time.StopWatch;
// import org.junit.jupiter.api.Test;
// import org.reflections.Reflections;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import java.util.Set;
//
// @SpringBootTest
// public class Demo04DispatcherTest {
//
//     @Test
//     void test01(){
//         String key = "/mylist/update";
//         String value = "com/example/mylist/controller/MyListAction.updateQty";
//
//         try {
//             SimpleMyListDispatcher.getHandler(key + value, true);
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//     }
//
//     @Test
//     void test02(){
//
//
//
//         // StopWatch watch = StopWatch.createStarted();
//
//         // Set<Class<?>> implClasses = new Reflections(packageNames).getTypesAnnotatedWith(MyListMapping.class);
//     }
// }
