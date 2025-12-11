package com.webapp.webapp_be.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="order_details")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class OrderDetail extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order orderId;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product productId;

    private Float price;

    @Column(name="number_of_product")
    private Integer numberOfProduct;

    @Column(name="total_money")
    private Double totalMoney;
}
