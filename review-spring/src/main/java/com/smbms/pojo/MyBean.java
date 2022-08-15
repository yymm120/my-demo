package com.smbms.pojo;

interface MyInterface {

    String getString();

    void setString(String string);
}


class MyBase implements MyInterface{

    private String string;

    @Override
    public String getString() {
        return string;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }
}

public class MyBean extends MyBase {

    private int number;

    private float fraction;

    private String[] array;

    private boolean bool;

    private byte[] bytes;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getFraction() {
        return fraction;
    }

    public void setFraction(float fraction) {
        this.fraction = fraction;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}


class PrettyPrintBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
