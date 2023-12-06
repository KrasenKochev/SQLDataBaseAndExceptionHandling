package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductImplTests {
    private ProductImpl product;
    @BeforeEach
    public void Before(){
        product= new ProductImpl("Name","Brand",1,GenderType.MEN);
    }
    @Test
    public void constructor_Should_InitializeName_When_AllArgumentsAreValid(){
        String name = "Right";
        String brand = "Right";
        int price = 3;
        ProductImpl product = new ProductImpl(name,brand,price,GenderType.MEN);

        Assertions.assertEquals(name,product.getName());
        Assertions.assertEquals(brand,product.getBrand());
        Assertions.assertEquals(price,product.getPrice());
        Assertions.assertEquals(GenderType.WOMEN,product.getGender());
    }
    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected(){
        String name = "No";
        String brand = "Right";
        int price = 3;
        ProductImpl product = new ProductImpl(name,brand,price,GenderType.MEN);

        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl(name,brand,price,GenderType.MEN));
    }
    @Test
    public void constructor_Should_ThrowException_When_NameIsLongerThanExpected(){
        String name = "ItsToooooooLongggg";
        String brand = "Right";
        int price = 3;
        ProductImpl product = new ProductImpl(name,brand,price,GenderType.MEN);

        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl(name,brand,price,GenderType.MEN));
    }
    @Test
    public void constructor_Should_ThrowException_When_BrandIsShorterThanExpected(){
        String name = "Right";
        String brand = "N";
        int price = 3;
        ProductImpl product = new ProductImpl(name,brand,price,GenderType.MEN);

        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl(name,brand,price,GenderType.MEN));
    }
    @Test
    public void constructor_Should_ThrowException_When_BrandIsLongerThanExpected(){
        String name = "Right";
        String brand = "ItsToooooooLongggg";
        int price = 3;
        ProductImpl product = new ProductImpl(name,brand,price,GenderType.UNISEX);

        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl(name,brand,price,GenderType.MEN));
    }
    @Test
    public void constructor_Should_ThrowException_When_PriceIsNegative(){
        String name = "Right";
        String brand = "Right";
        int price = -3;
        ProductImpl product = new ProductImpl(name,brand,price,GenderType.MEN);

        Assertions.assertThrows(InvalidUserInputException.class, () -> new ProductImpl(name,brand,price,GenderType.MEN));
    }
}
