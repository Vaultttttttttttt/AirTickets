package com.air.pojo;/**
* @description: TODO
* @author wxj27
* @date 2023-06-13 9:51
* @version 1.0
*/

public class PriceUpdate {
    //每日票价因素
    private Integer priceUpDay;
    //销售量票价因素
    private Integer priceUpNum;

    public PriceUpdate() {
    }

    public PriceUpdate(Integer priceUpDay, Integer priceUpNum) {
        this.priceUpDay = priceUpDay;
        this.priceUpNum = priceUpNum;
    }

    public Integer getPriceUpDay() {
        return priceUpDay;
    }

    public void setPriceUpDay(Integer priceUpDay) {
        this.priceUpDay = priceUpDay;
    }

    public Integer getPriceUpNum() {
        return priceUpNum;
    }

    public void setPriceUpNum(Integer priceUpNum) {
        this.priceUpNum = priceUpNum;
    }

    @Override
    public String toString() {
        return "PriceUpdate{" +
                "priceUpDay=" + priceUpDay +
                ", priceUpNum=" + priceUpNum +
                '}';
    }
}
