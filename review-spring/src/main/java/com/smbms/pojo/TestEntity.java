package com.smbms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity{
    private String specialCharacter1; // 特殊字符值1
    private String specialCharacter2; // 特殊字符值2
    private User innerBean; // JavaBean类型
    private List<String> list; // List类型
    private String[] array; // 数组类型
    private Set<String> set; // Set类型
    private Map<String, String> map; // Map类型
    private Properties props; // Properties类型
    private String emptyValue; // 注入空字符串值
    private String nullValue = "init value"; // 注入null值


    public void showValue() {
        System.out.println("特殊字符1：" + this.specialCharacter1);
        System.out.println("特殊字符2：" + this.specialCharacter2);
        System.out.println("内部Bean：" + this.innerBean.getUserName());
        System.out.println("List属性：" + this.list);
        System.out.println("数组属性[0]：" + this.array[0]);
        System.out.println("Set属性：" + this.set);
        System.out.println("Map属性：" + this.map);
        System.out.println("Properties属性：" + this.props);
        System.out.println("注入空字符串：[" + this.emptyValue + "]");
        System.out.println("注入null值：" + this.nullValue);
    }
}