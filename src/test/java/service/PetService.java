package service;

import client.PetClient;
import io.restassured.response.Response;
import pojo.Pet;

import java.io.IOException;


public class PetService extends PetClient {

    public Pet addPet(Pet pet) {
        return  postPet(pet)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(Pet.class);
    }

    public Response deleteAPet(Integer petId) {
        return  deletePet(petId)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
    }

    public Response deleteAPetNotFound(Integer petId) {
        return  deletePet(petId)
                .then()
                .log()
                .all()
                .statusCode(404)
                .extract()
                .response();
    }
}
