package com.webapp.webapp_be.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="orders")
@Builder
@Getter
@Setter
public class Order extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_id")
    private User userId;

    @Column(name="full_name")
    private String fullName;

    @Column(name="phone_number")
    private String phoneNumber;

    private String address;

    private String note;

    @Column(name="note_ship")
    private String noteShip;

    @Column(name="order_date")
    private LocalDate orderDate;

    @Column(name="shipping_method")
    private String shippingMethod;

    @Column(name="shipping_date")
    private LocalDate shippingDate;

    @Column(name="total_money")
    private Double totalMoney;

    @Column(name="order_code")
    private String orderCode;
}
