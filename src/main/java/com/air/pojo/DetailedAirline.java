package com.air.pojo;

import java.sql.Timestamp;

/**
* @description: TODO
* @author wxj27
* @date 2023-06-19 14:40
* @version 1.0
*/

public class DetailedAirline {
    //航空公司
    private String cname;
    //航班号
    private String line;
    //日期
    private Timestamp date;
    //出发地
    private String startPlace;
    //目的地
    private String endPlace;
    //机型
    private String model;
    //经济舱售票率
    private Double economyRate;
    //商务舱售票率
    private Double businessRate;
    //出行总次数
    private int times;

    public DetailedAirline() {
    }

    public DetailedAirline(String cname, String line, Timestamp date, String startPlace, String endPlace, String model, Double economyRate, Double businessRate, int times) {
        this.cname = cname;
        this.line = line;
        this.date = date;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.model = model;
        this.economyRate = economyRate;
        this.businessRate = businessRate;
        this.times = times;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getEconomyRate() {
        return economyRate;
    }

    public void setEconomyRate(Double economyRate) {
        this.economyRate = economyRate;
    }

    public Double getBusinessRate() {
        return businessRate;
    }

    public void setBusinessRate(Double businessRate) {
        this.businessRate = businessRate;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "DetailedAirline{" +
                "cname='" + cname + '\'' +
                ", line='" + line + '\'' +
                ", date=" + date +
                ", startPlace='" + startPlace + '\'' +
                ", endPlace='" + endPlace + '\'' +
                ", model='" + model + '\'' +
                ", economyRate=" + economyRate +
                ", businessRate=" + businessRate +
                ", times=" + times +
                '}';
    }
}
