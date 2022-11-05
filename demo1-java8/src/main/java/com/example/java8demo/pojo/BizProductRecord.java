package com.example.java8demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BizProductRecord {


    private boolean mSkuId;

    private boolean mDiscontinuedFlag;

    private boolean mLimitedStock;

    private boolean mShippingAvailable;

    private boolean mPickupAvailable;

    private long mCurrentStoreInventory;

    private boolean mOutOfStock;

    private String mFreeShippingIndicator;

    /**
     * only use to b2c enablement plp item add to cart button
     */
    private Boolean displayAddToCartButton;

    private Boolean LTLFlag;
}

