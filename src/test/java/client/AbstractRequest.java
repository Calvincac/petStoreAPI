package client;

import io.restassured.response.Response;
import pojo.Pet;

public interface AbstractRequest {
    Response postPet(Pet pet);
    Response deletePet(Long petId);
    Response updatePet(Pet pet);
    Response getPet(Long petId);
}
