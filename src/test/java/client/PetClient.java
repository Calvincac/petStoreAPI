package client;

import io.restassured.response.Response;
import pojo.Pet;

public class PetClient implements AbstractRequest{
    @Override
    public Response postPet(Pet pet) {
        return null;
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
