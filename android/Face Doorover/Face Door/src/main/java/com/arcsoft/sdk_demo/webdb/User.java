package com.arcsoft.sdk_demo.webdb;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String gender;
    private int age;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 写一个构造方法，能直接将所有信息初始化
     */
    public User(String username, String gender, int age){
        this.username = username;
        this.gender = gender;
        this.age = age;
    }
    public User(){
        super();
    }
}
