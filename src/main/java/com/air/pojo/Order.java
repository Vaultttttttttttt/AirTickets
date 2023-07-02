package com.air.pojo;/**
* @description: TODO
* @author wxj27
* @date 2023-06-17 17:51
* @version 1.0
*/

public class Order {
    //订单号
    private String orderNum;
    //用户名
    private String username;
    //总金额
    private double totalMoney;
    //状态（已出行，未出行，不存在,已过时）
    private String status;

    public Order() {
        this.status = "未出行";
    }

    public Order(String orderNum, String username, double totalMoney, String status) {
        this.orderNum = orderNum;
        this.username = username;
        this.totalMoney = totalMoney;
        this.status = status;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNum='" + orderNum + '\'' +
                ", username='" + username + '\'' +
                ", totalMoney=" + totalMoney +
                ", status='" + status + '\'' +
                '}';
    }
}
