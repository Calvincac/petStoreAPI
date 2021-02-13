package client;

import io.restassured.response.Response;
import pojo.Pet;

public interface AbstractRequest {
    Response postPet(Pet pet);
    Response deletePet(Integer petId);
    Response updatePet();
    Response getPet();
}
