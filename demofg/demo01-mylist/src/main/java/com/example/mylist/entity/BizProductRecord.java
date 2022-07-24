package com.example.mylist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BizProductRecord extends ProductRecord{

    private boolean                      mDiscontinuedFlag;

    private boolean                      mLimitedStock;

    private boolean                      mShippingAvailable;

    private boolean                      mPickupAvailable;

    private long                         mCurrentStoreInventory;

    private boolean                      mOutOfStock;

    private String                       mFreeShippingIndicator;

    /** only use to b2c enablement plp item add to cart button */
    private Boolean displayAddToCartButton;

    private Boolean LTLFlag;
}
