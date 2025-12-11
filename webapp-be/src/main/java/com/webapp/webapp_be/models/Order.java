package com.webapp.webapp_be.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User userId;

    @Column(name="full_name")
    private String fullName;

    @Column(name="phone_number")
    private String phoneNumber;

    private String address;

    private String note;

    @Column(name="note_ship")
    private String noteShip;

//    @Column(name="order_date")
//    private LocalDate orderDate;

    @Column(name="shipping_method")
    private String shippingMethod;

//    @Column(name="shipping_date")
//    private LocalDate shippingDate;

    @Column(name="total_money")
    private Double totalMoney;

//    @Column(name="order_code")
//    private String orderCode;

    @OneToMany(mappedBy = "orderId", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<OrderDetail> orderDetailList = new ArrayList<>();
}
