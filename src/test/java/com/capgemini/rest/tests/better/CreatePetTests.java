package com.capgemini.rest.tests.better;

import com.capgemini.rest.tests.pojo.Pet;
import com.capgemini.rest.tests.utils.GlobalReqSpec;
import com.capgemini.rest.tests.utils.PetGenerator;
import com.github.javafaker.Faker;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CreatePetTests extends RestTestBase {

    private RequestSpecification requestSpecification;
    private Pet createdPet;

    @BeforeMethod
    public void beforeMethod() {
        requestSpecification = GlobalReqSpec.getGlobalReqSpec();
    }

    @Test
    public void asUserCreateNewPetTest() {
        Pet pet = PetGenerator.generatePet();

        createdPet = given()
                .spec(requestSpecification)
                .accept(ContentType.APPLICATION_JSON.getMimeType())
                .body(pet)
                .post("pet")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().body().as(Pet.class);

        assertThat(createdPet).isEqualToComparingFieldByFieldRecursively(pet);
    }

    @Test(dependsOnMethods = "asUserCreateNewPetTest")
    public void asUserGetCreatedPetTest() {
        Pet selfGetPet = given()
                .spec(requestSpecification)
                .get("pet/{petId}", createdPet.getId())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().body().as(Pet.class);

        assertThat(selfGetPet).isEqualToComparingFieldByFieldRecursively(createdPet);
    }

    @Test(dependsOnMethods = "asUserGetCreatedPetTest")
    public void asUserUpdateCreatedPetTest() {
        createdPet.setName(new Faker().funnyName().name());

        Pet updatePet = given()
                .spec(requestSpecification)
                .body(createdPet)
                .put("pet")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().body().as(Pet.class);

        assertThat(updatePet).isEqualToComparingFieldByFieldRecursively(createdPet);
    }


    @Test(dependsOnMethods = "asUserUpdateCreatedPetTest")
    public void asUserDeleteCreatedPetTest() {
        given()
                .spec(requestSpecification)
                .body(createdPet)
                .delete("pet/{petId}", createdPet.getId())
                .then()
                .statusCode(HttpStatus.SC_OK);
    }


}
