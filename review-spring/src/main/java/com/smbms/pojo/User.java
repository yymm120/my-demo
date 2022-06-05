package com.smbms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * pojo映射数据表
 * smbms_user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id; //id
    private String userCode; //用户编码
    private String userName; //用户名称
    private String userPassword; //用户密码
    private Integer gender;  //性别
    private Date birthday;  //出生日期
    private String phone;   //电话
    private String address; //地址
    private Integer userRole;    //用户角色
    private Integer createdBy;   //创建者
    private Date creationDate; //创建时间
    private Integer modifyBy;     //更新者
    private Date modifyDate;   //更新时间
    private String userRoleName; //角色名称

    /** association 定义一对一关系 */
    private Role role;

    /** collection 定义一对多关系 */
    private List<Address> addressList;

    public User(Role role, String s, String phone) {
        this.role = role;
        this.userName = s;
        this.userCode = phone;
    }
}