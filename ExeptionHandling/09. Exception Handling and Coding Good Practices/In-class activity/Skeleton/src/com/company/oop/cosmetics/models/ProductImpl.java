package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.commands.ValidationHelper;
import com.company.oop.cosmetics.models.contracts.Product;

public class ProductImpl implements Product {
    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        //TODO Validate name
        ValidationHelper.validateProductName(name);
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        ValidationHelper.validateProductBrand(brand);
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        ValidationHelper.validatePriceNotNegative(price);
        this.price = price;
    }

    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        return String.format("#%s %s%n" + " #Price: $%.2f%n" + " #Gender: %s%n", name, brand, price, gender);
    }

}
