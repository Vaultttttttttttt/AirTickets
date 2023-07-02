package com.air.pojo;

import java.sql.Timestamp;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-17 17:59
* @version 1.0
*/

public class OrderItem {
    //订单号
    private String orderNum;
    //姓名
    private String name;
    //航班号
    private String line;
    //日期
    private Timestamp date;
    //座位类型
    private String cabinType;
    //单价
    private double money;

    public OrderItem() {
    }

    public OrderItem(String orderNum, String name, String line, Timestamp date, String cabinType, double money) {
        this.orderNum = orderNum;
        this.name = name;
        this.line = line;
        this.date = date;
        this.cabinType = cabinType;
        this.money = money;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCabinType() {
        return cabinType;
    }

    public void setCabinType(String cabinType) {
        this.cabinType = cabinType;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderNum='" + orderNum + '\'' +
                ", name='" + name + '\'' +
                ", line='" + line + '\'' +
                ", date=" + date +
                ", cabinType='" + cabinType + '\'' +
                ", money=" + money +
                '}';
    }
}
