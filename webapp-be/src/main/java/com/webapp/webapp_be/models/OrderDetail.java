package com.webapp.webapp_be.models;

import jakarta.persistence.*;

@Entity
@Table(name="order_details")
public class OrderDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="order_id")
    private Order orderId;

    @Column(name="user_id")
    private User userId;

    private Float price;

    @Column(name="number_of_product")
    private Integer numberOfProduct;

    @Column(name="total_money")
    private Double totalMoney;
}
