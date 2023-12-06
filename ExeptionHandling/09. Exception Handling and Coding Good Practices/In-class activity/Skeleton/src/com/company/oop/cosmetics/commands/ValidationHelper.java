package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.exeptions.*;
import com.company.oop.cosmetics.models.GenderType;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class ValidationHelper {
    private static final String ARGUMENTS_INVALID_COUNT_MESSAGE = "CreateProduct command expects 4 parameters.";
    private static final String VALIDATE_PRICE_ERROR_MESSAGE = "Third parameter should be price (real number).";
    private static final String VALIDATE_GENDER_ERROR_MESSAGE = "Forth parameter should be one of Men, Women or Unisex.";
    private static final String COMMAND_S_IS_NOT_SUPPORTED = "Command %s is not supported.";
    private static final int BRAND_MIN_LENGTH = 2;
    private static final int BRAND_MAX_LENGTH = 10;
    private static final String BRAND_ERROR_MESSAGE = String.format("Product brand should be between %d and %d symbols.", BRAND_MIN_LENGTH, BRAND_MAX_LENGTH);

    private static final int CATEGORY_NAME_MIN_LENGTH = 3;
    private static final int CATEGORY_NAME_MAX_LENGTH = 10;
    private static final String CATEGORY_NAME_ERROR_MESSAGE = String.format("Category name should be between %d and %d symbols.", CATEGORY_NAME_MIN_LENGTH, CATEGORY_NAME_MAX_LENGTH);

    private static final int PRODUCT_NAME_MIN_LENGTH = 3;
    private static final int PRODUCT_NAME_MAX_LENGTH = 10;

    private static final String PRODUCT_NAME_ERROR_MESSAGE = String.format("Name needs to be between %d and %d characters long", PRODUCT_NAME_MIN_LENGTH, PRODUCT_NAME_MAX_LENGTH);
    private static final String PRICE_ERROR_MESSAGE = "Price can't be negative.";

    public static void validateArguments(List<String> list, int expectedArgumentsCount) {
        if (list.size() < expectedArgumentsCount || list.size() > expectedArgumentsCount) {
            throw new InvalidArgumentCountException(ARGUMENTS_INVALID_COUNT_MESSAGE);
        }
    }

    public static void validatePriceFormat(String price) {
        if (price.length() >= 1) {
            if (!Character.isDigit(price.charAt(0)) && price.charAt(0) != '-')
                throw new IllegalPriceFormatException(VALIDATE_PRICE_ERROR_MESSAGE);
        }
        for (int i = 1; i < price.length(); i++) {
            if (Character.isAlphabetic(price.charAt(i)))
                throw new IllegalPriceFormatException(VALIDATE_PRICE_ERROR_MESSAGE);
        }
    }

    public static void validateGenderType(String gender) {

        ArrayList<String> genderTypes = new ArrayList<>(GenderType.values().length);
        for (GenderType f : GenderType.values())
            genderTypes.add(f.name());
        if (!genderTypes.contains(gender)) {
            throw new InvalidGenderTypeException(VALIDATE_GENDER_ERROR_MESSAGE);
        }
    }

    public static void validateCommandType(String command) {
        ArrayList<String> listOfEnums = new ArrayList<>();

        EnumSet.allOf(CommandType.class)
                .forEach(commandType -> listOfEnums.add(commandType.toString()));

        if (!listOfEnums.contains(command.toUpperCase())) {
            throw new InvalidCommandException(String.format(COMMAND_S_IS_NOT_SUPPORTED, command));
        }
    }

    public static void validateProductBrand(String brand) {
        if (brand.length() < BRAND_MIN_LENGTH || brand.length() > BRAND_MAX_LENGTH) {
            throw new InvalidBrandLengthException(BRAND_ERROR_MESSAGE);
        }
    }

    public static void validateProductName(String name) {
        if (name.length() < PRODUCT_NAME_MIN_LENGTH || name.length() > PRODUCT_NAME_MAX_LENGTH) {

            throw new InvalidNameLengthException(PRODUCT_NAME_ERROR_MESSAGE);
        }
    }

    public static void validatePriceNotNegative(double price) {
        if (price < 0) {
            throw new InvalidPriceRangeException(PRICE_ERROR_MESSAGE);
        }
    }

    public static void validateCategoryName(String name) {
        if (name.length() < CATEGORY_NAME_MIN_LENGTH || name.length() > CATEGORY_NAME_MAX_LENGTH) {
            throw new InvalidNameLengthException(CATEGORY_NAME_ERROR_MESSAGE);
        }
    }
}
