package com.air.pojo;

import java.sql.Timestamp;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-11 9:37
* @version 1.0
*/

public class AirLine {
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
    //商务舱剩余座位
    private Integer numBusiness;
    //经济舱剩余座位
    private Integer numEconomy;
    //商务舱价格
    private Integer priceBusiness;
    //经济舱价格
    private Integer priceEconomy;
    //起点
    private String startPlace;
    //终点
    private String endPlace;
    //商务舱总的位数
    private Integer totalBusiness;
    //经济舱总的位数
    private Integer totalEconomy;

    public AirLine() {
    }

    public AirLine(String line, Timestamp date, Timestamp startTime, Timestamp endTime, String model, Integer numBusiness, Integer numEconomy, Integer priceBusiness, Integer priceEconomy, String startPlace, String endPlace, Integer totalBusiness, Integer totalEconomy) {
        this.line = line;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.model = model;
        this.numBusiness = numBusiness;
        this.numEconomy = numEconomy;
        this.priceBusiness = priceBusiness;
        this.priceEconomy = priceEconomy;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.totalBusiness = totalBusiness;
        this.totalEconomy = totalEconomy;
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

    public Integer getNumBusiness() {
        return numBusiness;
    }

    public void setNumBusiness(Integer numBusiness) {
        this.numBusiness = numBusiness;
    }

    public Integer getNumEconomy() {
        return numEconomy;
    }

    public void setNumEconomy(Integer numEconomy) {
        this.numEconomy = numEconomy;
    }

    public Integer getPriceBusiness() {
        return priceBusiness;
    }

    public void setPriceBusiness(Integer priceBusiness) {
        this.priceBusiness = priceBusiness;
    }

    public Integer getPriceEconomy() {
        return priceEconomy;
    }

    public void setPriceEconomy(Integer priceEconomy) {
        this.priceEconomy = priceEconomy;
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

    public Integer getTotalBusiness() {
        return totalBusiness;
    }

    public void setTotalBusiness(Integer totalBusiness) {
        this.totalBusiness = totalBusiness;
    }

    public Integer getTotalEconomy() {
        return totalEconomy;
    }

    public void setTotalEconomy(Integer totalEconomy) {
        this.totalEconomy = totalEconomy;
    }

    @Override
    public String toString() {
        return "AirLine{" +
                "line='" + line + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", model='" + model + '\'' +
                ", numBusiness=" + numBusiness +
                ", numEconomy=" + numEconomy +
                ", priceBusiness=" + priceBusiness +
                ", priceEconomy=" + priceEconomy +
                ", startPlace='" + startPlace + '\'' +
                ", endPlace='" + endPlace + '\'' +
                ", totalBusiness=" + totalBusiness +
                ", totalEconomy=" + totalEconomy +
                '}';
    }
}
