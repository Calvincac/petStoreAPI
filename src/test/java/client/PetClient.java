package client;

import io.restassured.response.Response;
import pojo.Pet;
import resources.PetStoreResources;
import resources.Utils;

import static io.restassured.RestAssured.given;

public class PetClient {
    Utils utils = new Utils();

    public Response postPet(Object pet) {
        return  given()
                .spec(utils.requestSpecification())
                .body(pet)
                .when()
                .log()
                .all()
                .post(PetStoreResources.PET.getResource());
    }

    public Response deletePet(Long petId) {
        return  given()
                .spec(utils.requestSpecification())
                .when()
                .log()
                .all()
                .delete(PetStoreResources.PET.getResource() + String.valueOf(petId));
    }

    public Response updatePet(Object pet) {
        return  given()
                .spec(utils.requestSpecification())
                .body(pet)
                .when()
                .log()
                .all()
                .put(PetStoreResources.PET.getResource());
    }

    public Response getPet(Long petId) {
        return  given()
                .spec(utils.requestSpecification())
                .when()
                .log()
                .all()
                .get(PetStoreResources.PET.getResource() + String.valueOf(petId));
    }

    public Response getPetByStatus(String petStatus) {
        return  given()
                .spec(utils.requestSpecification())
                .queryParam("status", petStatus)
                .when()
                .log()
                .all()
                .get(PetStoreResources.PET.getResource() + "findByStatus");
    }
}
