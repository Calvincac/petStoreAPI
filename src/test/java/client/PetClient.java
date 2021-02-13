package client;

import io.restassured.response.Response;
import pojo.Pet;
import resources.PetStoreResources;
import resources.Utils;

import static io.restassured.RestAssured.given;

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
    public Response deletePet(Integer petId) {
        return  given()
                .spec(utils.requestSpecification())
                .when()
                .log()
                .all()
                .delete(PetStoreResources.PET.getResource() + String.valueOf(petId));
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
