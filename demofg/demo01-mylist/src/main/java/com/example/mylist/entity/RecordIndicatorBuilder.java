// package com.example.mylist.entity;
//
// import com.google.common.base.Suppliers;
// import org.apache.commons.lang3.StringUtils;
//
// import java.util.List;
// import java.util.Map;
// import java.util.function.Supplier;
//
// public class RecordIndicatorBuilder<R extends BizProductRecord> {
//
//     public Map<String, Object> buildOptions;
//     public Map<String, Object> indicators;
//     public R record;
//     public List<R> recordList;
//     public boolean isBuildAll;
//     private static final String EMPTY = StringUtils.EMPTY;
//
//     public static final String PLP_ONE_FREIGHT_FREE_SHIPPING_INDICATOR = "PLP.OneFreight.Free.Shipping.Indicator";
//
//
//
//     private static final Supplier<RecordIndicatorBuilder> INSTANCE = Suppliers.memoize(RecordIndicatorBuilder::new);
//
//
//
//     /**
//      * @param record build one record.<br/>
//      *               If you hope to build all list records, you can
//      */
//     public static <R extends BizProductRecord> RecordIndicatorBuilder<R> getRecordIndicatorBuilder(R record) {
//         RecordIndicatorBuilder<R> builder = INSTANCE.get();
//         builder.isBuildAll = false;
//         builder.setRecord(record);
//         return builder;
//     }
//
//
//
//     /**
//      * @param recordList if pass a list, any build method will work on all elements.
//      * @return a builder
//      */
//     public static <R extends BizProductRecord> RecordIndicatorBuilder<R> getRecordListIndicatorBuilder(List<R> recordList) {
//         RecordIndicatorBuilder<R> builder = INSTANCE.get();
//         builder.isBuildAll = true;
//         builder.setRecordList(recordList);
//         return builder;
//     }
//
//
//
//     private RecordIndicatorBuilder() {}
//
//     public RecordIndicatorBuilder(R record) {
//         this.record = record;
//     }
//
//     public RecordIndicatorBuilder(List<R> recordList) {
//         this.recordList = recordList;
//     }
//
//     public R getRecord() {
//         return record;
//     }
//
//     public void setRecord(R record) {
//         this.record = record;
//     }
//
//     public List<R> getRecordList() {
//         return recordList;
//     }
//
//     public void setRecordList(List<R> recordList) {
//         this.recordList = recordList;
//     }
// }
