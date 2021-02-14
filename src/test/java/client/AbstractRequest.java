package client;

import io.restassured.response.Response;
import pojo.Pet;

public interface AbstractRequest {
    Response postPet(Pet pet);
    Response deletePet(Long petId);
    Response updatePet();
    Response getPet(Long petId);
}
