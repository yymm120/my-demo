package com.smbms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Long id;
    private String roleCode;
    private String roleName;
    private Long createdBy;
    // @JSONField(format = "yyyy-MM-dd HH:mm:ss")

    private Date creationDate;
    private Long modifyBy;
    // @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date modifyDate;
}