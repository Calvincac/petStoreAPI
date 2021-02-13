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
}
