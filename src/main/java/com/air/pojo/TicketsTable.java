package com.air.pojo;

import java.util.Map;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-17 18:09
* @version 1.0
*/

public class TicketsTable {
    //准备买的航班线
    private AirLine airline;
    //准备买的座位类型
    private String cabin_type;
    //该账号指定的乘客
    private Customer customer;
    //该账号指定的乘客对应的钱
    private double money;
    //买票的乘客对应多少钱的哈希表
    private Map<Customer,Double> customerAndMoney;
    //总金额
    private double totalMoney;
    //目前的乘客人数
    private int num;

    public TicketsTable() {
    }

    public TicketsTable(AirLine airline, String cabin_type, Customer customer, double money, Map<Customer, Double> customerAndMoney, double totalMoney, int num) {
        this.airline = airline;
        this.cabin_type = cabin_type;
        this.customer = customer;
        this.money = money;
        this.customerAndMoney = customerAndMoney;
        this.totalMoney = totalMoney;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    public AirLine getAirline() {
        return airline;
    }

    public void setAirline(AirLine airline) {
        this.airline = airline;
    }

    public String getCabin_type() {
        return cabin_type;
    }

    public void setCabin_type(String cabin_type) {
        this.cabin_type = cabin_type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Customer, Double> getCustomerAndMoney() {
        return customerAndMoney;
    }

    public void setCustomerAndMoney(Map<Customer, Double> customerAndMoney) {
        this.customerAndMoney = customerAndMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "TicketsTable{" +
                "airline=" + airline +
                ", cabin_type='" + cabin_type + '\'' +
                ", customer=" + customer +
                ", money=" + money +
                ", customerAndMoney=" + customerAndMoney +
                ", totalMoney=" + totalMoney +
                ", num=" + num +
                '}';
    }
}
