package com.jpa.demo.dto;

import lombok.Data;

@Data
public class OrderResponseDTO {
    private Long id;
    private String product;
    private String userName;
}
