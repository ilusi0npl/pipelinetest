package com.capgemini.rest.tests.utils;

import com.capgemini.rest.tests.pojo.Category;
import com.capgemini.rest.tests.pojo.Pet;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class PetGenerator {

    public static Pet generatePet() {
        Faker faker = new Faker();

        Pet pet = new Pet();
        pet.setId(Integer.valueOf(RandomStringUtils.randomNumeric(5)));
        pet.setName(faker.funnyName().name());
        pet.setStatus("Available");

        Category category = new Category();
        category.setId(1);
        category.setName(faker.ancient().god());
        pet.setCategory(category);
        return pet;
    }


}
