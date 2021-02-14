package service;

import client.PetClient;
import io.restassured.response.Response;
import pojo.Pet;

import java.util.List;


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

    public Response deleteAPet(Long petId) {
        return  deletePet(petId)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();
    }

    public Response deleteAPetNotFound(Long petId) {
        return  deletePet(petId)
                .then()
                .log()
                .all()
                .statusCode(404)
                .extract()
                .response();
    }

    public Pet getPetById(Long petId) {
        return  getPet(petId)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(Pet.class);
    }

    public Response getPetByIdNotFound(Long petId) {
        return  getPet(petId)
                .then()
                .log()
                .all()
                .statusCode(404)
                .extract()
                .response();
    }

    public List<Pet> retrievePetByStatus(String petStatus) {
        return  getPetByStatus(petStatus)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList(".", Pet.class);
    }

    public Pet updateAPet(Pet pet) {
        return  updatePet(pet)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .as(Pet.class);
    }
}
