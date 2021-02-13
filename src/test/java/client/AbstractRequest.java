package client;

import io.restassured.response.Response;
import pojo.Pet;

import java.io.IOException;

public interface AbstractRequest {
    Response postPet(Pet pet);
    Response deletePet();
    Response updatePet();
    Response getPet();
}
