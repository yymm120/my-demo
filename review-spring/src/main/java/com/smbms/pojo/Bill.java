package com.smbms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bill {
    private Long id;
    private String billCode;
    private String productName;
    private String productDesc;
    private String productUnit;
    private Double productCount;
    private Double totalPrice;
    private Integer isPayment;
    private Long createdBy;
    private Date creationDate;
    private Long modifyBy;
    private Date modifyDate;
    private Long providerId;

}