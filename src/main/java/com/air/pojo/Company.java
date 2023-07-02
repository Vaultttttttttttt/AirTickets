package com.air.pojo;/**
* @description: TODO
* @author wxj27
* @date 2023-06-18 19:06
* @version 1.0
*/

public class Company {
    private String cname;
    private String sign;

    public Company() {
    }

    public Company(String cname, String sign) {
        this.cname = cname;
        this.sign = sign;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Company{" +
                "cname='" + cname + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
