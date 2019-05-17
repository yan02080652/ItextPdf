package com.test.demo;

import java.io.Serializable;
import java.util.Date;

/**
 * 差旅行程通用订单表单
 *
 * @author lzr
 * @date 2019-03-28
 */
public class TravelPlanOrderCommon implements Serializable {

    /**
     * 订单
     */
    private String orderId;

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 出发城市
     */
    private String fromCity;

    /**
     * 到达城市
     */
    private String toCity;

    /**
     * 航班号
     */
    private String flightNo;

    /**
     * 火车车次
     */
    private String trainCode;

    /**
     * 舱位
     */
    private String cabin;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 出行时间
     */
    private Date travelDate;

    /**
     * 酒店入住时间
     */
    private Date arrivalDate;

    /**
     * 酒店离店时间
     */
    private Date departureDate;

    /**
     * 预订时间
     */
    private Date bookingTime;

    /**
     * 订单金额
     */
    private String amount;

    /**
     *单号
     */
    private String travelPlanNo;

    /**
     * 费用归属名称
     */
    private String costCenterName;

    /**
     * 差旅计划ID
     */
    private Long travelPlanId;

    /**
     * 差旅类型
     */
    private String travelType;

    /**
     * 差旅原由
     */
    private String travelReason;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTravelPlanNo() {
        return travelPlanNo;
    }

    public void setTravelPlanNo(String travelPlanNo) {
        this.travelPlanNo = travelPlanNo;
    }

    public String getCostCenterName() {
        return costCenterName;
    }

    public void setCostCenterName(String costCenterName) {
        this.costCenterName = costCenterName;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getTravelReason() {
        return travelReason;
    }

    public void setTravelReason(String travelReason) {
        this.travelReason = travelReason;
    }

    public Long getTravelPlanId() {
        return travelPlanId;
    }

    public void setTravelPlanId(Long travelPlanId) {
        this.travelPlanId = travelPlanId;
    }

    @Override
    public String toString() {
        return "TravelPlanOrderCommon{" +
                "orderId='" + orderId + '\'' +
                ", orderType='" + orderType + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", trainCode='" + trainCode + '\'' +
                ", cabin='" + cabin + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", travelDate=" + travelDate +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                ", bookingTime=" + bookingTime +
                ", amount='" + amount + '\'' +
                ", travelPlanNo='" + travelPlanNo + '\'' +
                ", costCenterName='" + costCenterName + '\'' +
                ", travelPlanId=" + travelPlanId +
                ", travelType='" + travelType + '\'' +
                ", travelReason='" + travelReason + '\'' +
                '}';
    }

    public TravelPlanOrderCommon(String orderId, String orderType, String fromCity, String toCity, String flightNo, String trainCode, String cabin, String hotelName, Date travelDate, Date arrivalDate, Date departureDate, Date bookingTime, String amount, String travelPlanNo, String costCenterName, Long travelPlanId, String travelType, String travelReason) {
        this.orderId = orderId;
        this.orderType = orderType;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.flightNo = flightNo;
        this.trainCode = trainCode;
        this.cabin = cabin;
        this.hotelName = hotelName;
        this.travelDate = travelDate;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.bookingTime = bookingTime;
        this.amount = amount;
        this.travelPlanNo = travelPlanNo;
        this.costCenterName = costCenterName;
        this.travelPlanId = travelPlanId;
        this.travelType = travelType;
        this.travelReason = travelReason;
    }

    public TravelPlanOrderCommon() {
    }
}
