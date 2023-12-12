package com.nike.components.filter.filter_enums;

public enum ShopByPriceFilterOptions {
    FROM_ZERO_TO_FIFTY("€0 - €50", 0f, 50f), FROM_FIFTY_TO_ONE_HUNDRED("€50 - €100", 50f, 100),
    FROM_ONE_HUNDRED_TO_ONE_HUNDRED_FIFTY("€100 - €150", 100f, 150f), MORE_THAN_ONE_HUNDRED_FIFTY("€150+", 150f, Float.MAX_VALUE);

    private final String value;
    private final float minPrice;
    private final float maxPrice;

    ShopByPriceFilterOptions(String value, float minPrice, float maxPrice) {
        this.value = value;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getValue() {
        return value;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public float getMaxPrice() {
        return maxPrice;
    }
}
