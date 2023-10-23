package com.nike.dto;

public class ProductDtoBuilder {

    private final ProductDto productDto = new ProductDto();

    public ProductDtoBuilder setLabel(String label) {
        this.productDto.setLabel(label);
        return this;
    }

    public ProductDtoBuilder setName(String name) {
        this.productDto.setName(name);
        return this;
    }

    public ProductDtoBuilder setSubtitle(String subtitle) {
        this.productDto.setSubtitle(subtitle);
        return this;
    }

    public ProductDtoBuilder setNumberOfColours(int numberOfColours) {
        this.productDto.setNumberOfColours(numberOfColours);
        return this;
    }

    public ProductDtoBuilder setPrice(float price) {
        this.productDto.setPrice(price);
        return this;
    }

    public ProductDtoBuilder setReducedPrice(float reducedPrice) {
        this.productDto.setReducedPrice(reducedPrice);
        return this;
    }

    public ProductDtoBuilder setPercentageOfDiscount(float percentageOfDiscount) {
        this.productDto.setPercentageOfDiscount(percentageOfDiscount);
        return this;
    }

    public ProductDto build(){
        return productDto;
    }
}
