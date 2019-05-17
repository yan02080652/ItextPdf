package com.test.demo;

import java.util.Date;

public class Model {

    private String type;
    private String city;
    private String code;
    private Date date;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Model() {
    }

    public Model(String type, String city, String code, Date date) {
        this.type = type;
        this.city = city;
        this.code = code;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Model{" +
                "type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", code='" + code + '\'' +
                ", date=" + date +
                '}';
    }
}
