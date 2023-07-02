package com.air.pojo;/**
* @description: TODO
* @author wxj27
* @date 2023-05-27 14:28
* @version 1.0
*/

public class Customer {
    private String name;
    private String gender;
    private Integer age;
    private String level;
    private String job;
    private String card = "普通";

    public Customer() {
    }

    public Customer(String name, String gender, Integer age, String level, String job) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.level = level;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", level='" + level + '\'' +
                ", job='" + job + '\'' +
                ", card='" + card + '\'' +
                '}';
    }
}
