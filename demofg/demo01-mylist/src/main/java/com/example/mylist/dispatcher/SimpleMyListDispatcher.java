// package com.example.mylist.dispatcher;
//
//
// import com.example.mylist.Annotation.MyListMapping;
// import com.example.mylist.controller.MyListAction;
// import com.google.common.collect.ImmutableMap;
// import org.apache.commons.lang3.ClassUtils;
// import org.apache.logging.log4j.util.Strings;
// import org.reflections.Reflections;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
//
// import java.lang.reflect.InvocationHandler;
//
// import java.lang.reflect.Proxy;
// import java.util.Map;
// import java.util.Set;
//
//
// public class SimpleMyListDispatcher {
//     Map<String, String> actions = ImmutableMap.of("/update", "abc");
//     static Logger logger = LoggerFactory.getLogger(SimpleMyListDispatcher.class.getName());
//
//     public MyListAction doDispatch(){
//         String myList = actions.get("myList");
//         return null;
//     }
//
//
//     public static void processAnnotations(Object obj){
//         // String handlerName = "/update";
//         // try {
//         //     Class<?> clazz = obj.getClass();
//         //
//         //     Object o = clazz.newInstance();
//         //     Method[] declaredMethods = clazz.getDeclaredMethods();
//         //
//         //     for (Method method : clazz.getDeclaredMethods()) {
//         //         MyListMapping mapping = method.getAnnotation(MyListMapping.class);
//         //         if(handlerName.equals(mapping.value())){
//         //             method.invoke(o);
//         //         }
//         //     }
//         // } catch (InstantiationException | IllegalAccessException e) {
//         //     throw new RuntimeException(e);
//         // } catch (InvocationTargetException e) {
//         //     e.printStackTrace();
//         // }
//
//     }
//
//     /**
//      * 根据注解, 把action类注册进来
//      */
//     // private void registryActions(){
//     //     Object object =
//     //             Proxy.newProxyInstance(
//     //                     interfaceType.getClassLoader(), new Class<?>[] {interfaceType}, handler);
//     //
//     // }
//
//
//
//     /**
//      *
//      */
//     public static Object getHandler(String handlerName) throws ClassNotFoundException {
//         // Object handler = getHandler(handlerName, true);
//         return getHandler(handlerName, false);
//     }
//
//
//     public static Class<?> getAction(Class<?> clazz, String actionName){
//
//         return null;
//     }
//
//
//     /**
//      * annotation is true will use mapKey
//      * annotation is false will use mapValue
//      */
//     public static Object getHandler(String handlerName, boolean useAnnotation) throws ClassNotFoundException {
//         logger.info(" ==== into getHandler ====");
//         String packageNames = "com.example.mylist.handler";
//         String proxyName = "com.example.mylist.controller.MyListAction";
//         // 根据 value获取接口, 再获取改接口的实现， 再获取实现中被注解的类。 假如有多个，就报错
//         //
//
//         if ("".equals(handlerName) || !handlerName.contains("/")){
//             // throw new IllegalStateException("handlerName is empty");
//         }
//
//         Class<?> actionClass = null;
//
//         // handlerName might be "/class/method" or "class/method"
//         if (useAnnotation){
//             String[] ss = handlerName.split("/");
//             String className = Strings.EMPTY.equals(ss[0])? ss[1] : ss[0];
//             // 拿到代理
//             Class<?> proxy = Class.forName(proxyName);
//
//             // 拿到注解标注的类
//             ClassUtils.
//             Set<Class<?>> implClasses = new Reflections().getTypesAnnotatedWith(MyListMapping.class);
//             // Reflections refs = new Reflections(packageNames);
//
//             for (Class<?> clazz : implClasses) {
//                 // 拿到真实类
//                 if ( className.equals(clazz.getName()) ){
//                     actionClass = clazz; break;
//                 }
//             }
//         }else{
//             handlerName = "com/example/mylist/controller/MyListItemAction.updateQty";
//         }
//
//         InvocationHandler handler = null;
//         if (actionClass == null){
//             throw new IllegalStateException("actionClass is null");
//         }else if (MyListAction.class.isAssignableFrom(actionClass)) {
//             throw new IllegalStateException("actionClass is not implement MyListAction.class");
//         }else if (false){
//
//         } else {
//             handler = (proxy, method, args) -> {
//                 // handle request params
//                 logger.info(" ==== begin ==== \nproxy = " + proxy);
//                 Object invoke = null;
//                 try {
//                     invoke = method.invoke(proxy, args);
//                     logger.info("");
//                 }catch (Exception e){
//                     logger.info("");
//                 }
//                 //
//                 logger.info(" ==== end ====");
//                 return null;
//             };
//         }
//
//
//         Object o = null;
//         if( handler == null ){
//             throw new IllegalStateException("handler is null");
//         }else {
//             logger.info("create proxy class");
//             o = Proxy.newProxyInstance(actionClass.getClassLoader(),
//                     new Class[]{MyListAction.class},
//                     handler);
//
//         }
//
//
//         return o;
//     }
// }
//
