package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.exeptions.InvalidUserNotUniqueException;
import com.company.oop.cosmetics.models.GenderType;


import java.util.List;

public class CreateProductCommand implements Command {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 4;
    private static final String PRODUCT_CREATED = "Product with name %s was created!";
    private static final String PRODUCT_S_ALREADY_EXIST_ERROR_MESSAGE = "Product %s already exist.";
    private final ProductRepository productRepository;

    public CreateProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String execute(List<String> parameters) {

        ValidationHelper.validateArguments(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        ValidationHelper.validatePriceFormat(parameters.get(2));
        ValidationHelper.validateGenderType(parameters.get(3).toUpperCase());

        String name = parameters.get(0);
        String brand = parameters.get(1);
        double price = Double.parseDouble(parameters.get(2));
        GenderType gender = GenderType.valueOf(parameters.get(3).toUpperCase());
        return createProduct(name, brand, price, gender);
    }

    private String createProduct(String name, String brand, double price, GenderType gender) {

        if (productRepository.productExist(name)) {
            throw new InvalidUserNotUniqueException(String.format(PRODUCT_S_ALREADY_EXIST_ERROR_MESSAGE, name));
        }
        productRepository.createProduct(name, brand, price, gender);

        return String.format(PRODUCT_CREATED, name);
    }

}
