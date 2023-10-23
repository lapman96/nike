package com.nike.dto;

public class ProductDto {
    private String label;
    private String name;
    private String subtitle;
    private int numberOfColours;
    private float price;
    private float reducedPrice;
    private float percentageOfDiscount;

    public ProductDto() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getNumberOfColours() {
        return numberOfColours;
    }

    public void setNumberOfColours(int numberOfColours) {
        this.numberOfColours = numberOfColours;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(float reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public float getPercentageOfDiscount() {
        return percentageOfDiscount;
    }

    public void setPercentageOfDiscount(float percentageOfDiscount) {
        this.percentageOfDiscount = percentageOfDiscount;
    }
}
