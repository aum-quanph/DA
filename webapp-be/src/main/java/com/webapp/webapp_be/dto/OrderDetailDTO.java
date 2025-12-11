package com.webapp.webapp_be.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderDetailDTO {
    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("product_id")
    private Long productId;

    private Float price;

    @JsonProperty("number_of_product")
    private Integer numberOfProduct;

    @JsonProperty("total_money")
    private Double totalMoney;
}
