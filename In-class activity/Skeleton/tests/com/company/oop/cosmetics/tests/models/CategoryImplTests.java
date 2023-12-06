package com.company.oop.cosmetics.tests.models;

import com.company.oop.cosmetics.exceptions.InvalidUserInputException;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.ProductImpl;
import com.company.oop.cosmetics.models.contracts.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CategoryImplTests {
    private CategoryImpl category;
    private List<Product> product;
    @BeforeEach
    public void Before(){
         category = new CategoryImpl("Something");
    }
    @Test
    public void constructor_Should_InitializeName_When_ArgumentsAreValid() {
        String name = "Right";
        CategoryImpl category = new CategoryImpl(name);
        Assertions.assertEquals(name,category.getName());
    }

    @Test
    public void constructor_Should_InitializeProducts_When_ArgumentsAreValid() {



    }
    @Test
    public void constructor_Should_ThrowException_When_NameIsShorterThanExpected() {
        String name = "No";
        Assertions.assertThrows(InvalidUserInputException.class, () -> new CategoryImpl(name));
    }
    @Test
    public void addProduct_Should_AddProductToList() {

    }

    @Test
    public void removeProduct_Should_RemoveProductFromList_When_ProductExist() {

    }

    @Test
    public void removeProduct_should_notRemoveProductFromList_when_productNotExist() {

    }

}
