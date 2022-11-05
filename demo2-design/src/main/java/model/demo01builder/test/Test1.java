package model.demo01builder.test;


import java.util.function.Function;

public class Test1 {


    private String name;
    private Integer age;
    private String address;




    public void buildAge(Object... args){
        // int a = 0;
        self().buildName((a) -> {
            System.out.println("a");
            return a;
        });
    }

    private void buildName(Function o) {
        o.apply(address);
    }

    private void buildName() {

    }

    private void getAllArgs(Object o) {
    }

    public Test1 self(){
        return this;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
