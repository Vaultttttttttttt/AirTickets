package com.air.pojo;/**
* @description: TODO
* @author wxj27
* @date 2023-06-11 21:03
* @version 1.0
*/

import java.sql.Timestamp;

/**
* @description: 用来存储查找航线记录的条件
* @param: null
* @return:
* @author wxj27
* @date: 2023-06-11 21:03
*/
public class ChooseItem {
    //航班号
    private String line;
    //起飞日期
    private Timestamp date;
    //起飞时间
    private Timestamp startTime;
    //到达时间
    private Timestamp endTime;
    //机型
    private String model;
    //最低商务舱价格
    private Integer minPriceBusiness;
    //最高商务舱价格
    private Integer maxPriceBusiness;
    //最低经济舱价格
    private Integer minPriceEconomy;
    //最高经济舱价格
    private Integer maxPriceEconomy;
    //起点
    private String startPlace;
    //终点
    private String endPlace;

    public ChooseItem() {
    }

    public ChooseItem(String line, Timestamp date, Timestamp startTime, Timestamp endTime, String model, Integer minPriceBusiness, Integer maxPriceBusiness, Integer minPriceEconomy, Integer maxPriceEconomy, String startPlace, String endPlace) {
        this.line = line;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.model = model;
        this.minPriceBusiness = minPriceBusiness;
        this.maxPriceBusiness = maxPriceBusiness;
        this.minPriceEconomy = minPriceEconomy;
        this.maxPriceEconomy = maxPriceEconomy;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
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

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMinPriceBusiness() {
        return minPriceBusiness;
    }

    public void setMinPriceBusiness(Integer minPriceBusiness) {
        this.minPriceBusiness = minPriceBusiness;
    }

    public Integer getMaxPriceBusiness() {
        return maxPriceBusiness;
    }

    public void setMaxPriceBusiness(Integer maxPriceBusiness) {
        this.maxPriceBusiness = maxPriceBusiness;
    }

    public Integer getMinPriceEconomy() {
        return minPriceEconomy;
    }

    public void setMinPriceEconomy(Integer minPriceEconomy) {
        this.minPriceEconomy = minPriceEconomy;
    }

    public Integer getMaxPriceEconomy() {
        return maxPriceEconomy;
    }

    public void setMaxPriceEconomy(Integer maxPriceEconomy) {
        this.maxPriceEconomy = maxPriceEconomy;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    @Override
    public String toString() {
        return "ChooseItem{" +
                "line='" + line + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", model='" + model + '\'' +
                ", minPriceBusiness=" + minPriceBusiness +
                ", maxPriceBusiness=" + maxPriceBusiness +
                ", minPriceEconomy=" + minPriceEconomy +
                ", maxPriceEconomy=" + maxPriceEconomy +
                ", startPlace='" + startPlace + '\'' +
                ", endPlace='" + endPlace + '\'' +
                '}';
    }
}
