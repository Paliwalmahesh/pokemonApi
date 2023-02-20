package com.example;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

@MicronautTest
class TestIntegration {

    @Test
    void testAddPokemon(RequestSpecification spec) {
        spec.given()
                .body("{\"name\": \"TestPokemon\", \"specialityId\": 1, \"imageUrl\": \"TestPokemon.com\"}")
                .header("Content-Type", "application/json")
                .when()
                .post("/pokemon")
                .then()
                .statusCode(201)
                .assertThat()
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("TestPokemon"))
                .body("speciality.id", Matchers.equalTo(1))
                .body("speciality.name", Matchers.equalTo("Grass"));
    }

    @Test
    void testGetPokemonById(RequestSpecification spec) {
        spec.given()
                .pathParam("id", 2)
                .when()
                .get("/pokemon/{id}")
                .then()
                .statusCode(200)
                .assertThat()
                .body("id", Matchers.equalTo(2))
                .body("name", Matchers.equalTo("TestPokemon"))
                .body("speciality.id", Matchers.equalTo(1))
                .body("speciality.name", Matchers.equalTo("Grass"));
    }



    @Test
    void testDeleteById(RequestSpecification spec) {
        spec.given().pathParam("id", 2).when().delete("/pokemon/{id}").then().statusCode(200);
    }
}