package com.webapp.webapp_be.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.webapp.webapp_be.models.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String address;
    private String note;
    @JsonProperty("note_ship")
    private String noteShip;
    @JsonProperty("order_date")
    private LocalDate orderDate;
    @JsonProperty("shipping_date")
    private LocalDate shippingDate;
    @JsonProperty("shipping_method")
    private String shippingMethod;
    @JsonProperty("total_money")
    private Double totalMoney;
    @JsonProperty("user_id")
    private Long userId;
}
