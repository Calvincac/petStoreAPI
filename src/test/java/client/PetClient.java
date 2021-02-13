package client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Pet;
import resources.PetStoreResources;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class PetClient implements AbstractRequest{
    Utils utils = new Utils();

    @Override
    public Response postPet(Pet pet) {
        return  given()
                .spec(utils.requestSpecification())
                .body(pet)
                .when()
                .log()
                .all()
                .post(PetStoreResources.PET.getResource());
    }

    @Override
    public Response deletePet() {
        return null;
    }

    @Override
    public Response updatePet() {
        return null;
    }

    @Override
    public Response getPet() {
        return null;
    }
}
