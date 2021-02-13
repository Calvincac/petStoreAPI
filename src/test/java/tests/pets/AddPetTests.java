package tests.pets;

import data.DataBuilder;
import org.testng.annotations.Test;
import pojo.Pet;
import service.PetService;

import static asserters.PetAsserters.assertPet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.io.IOException;

public class AddPetTests extends PetService {
    DataBuilder data = new DataBuilder();

    @Test
    public void canCreateAPetAllFields() {
        Pet expectedPet = data.getPetAllFields();
        Pet petResponse = addPet(expectedPet);
        assertPet(expectedPet, petResponse);
    }
}
