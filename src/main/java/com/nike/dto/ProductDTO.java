package com.nike.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
    private String label;
    private String name;
    private String subtitle;
    private String size;
    private int numberOfColours;
    private String colour;
    private int quantity;
    private float basicPrice;
    private float reducedPrice;
    private float percentageOfDiscount;
    private int productPositionIndex;
}
