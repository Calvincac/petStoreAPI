package asserters;

import pojo.Pet;
import pojo.Status;
import pojo.Tag;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class PetAsserters {

    public static void assertPet(Pet expected, Pet actual) {
        if(expected.getCategory() != null){
            assertThat(expected.getCategory().getId(), equalTo(actual.getCategory().getId()));
            assertThat(expected.getCategory().getName(), equalTo(actual.getCategory().getName()));
        }

        if(expected.getTags() != null){
            assertTags(expected.getTags(), actual.getTags());
        }
        assertThat(expected.getId(), equalTo(actual.getId()));
        assertThat(expected.getName(), equalTo(actual.getName()));
        assertThat(expected.getStatus(), equalTo(actual.getStatus()));
        assertThat(expected.getPhotoUrls(), equalTo(actual.getPhotoUrls()));
    }

    public static void assertTags(List<Tag> expectedTags, List<Tag> actualTags) {
        for(int i=0; i<expectedTags.size(); i++) {
            assertThat(expectedTags.get(i).getId(), equalTo(actualTags.get(i).getId()));
            assertThat(expectedTags.get(i).getName(), equalTo(actualTags.get(i).getName()));
        }
    }

    public static void assertStatus(List<Pet> pets, Status status) {
        pets.forEach(pet -> {
            assertThat(pet.getStatus(), equalTo(status));
        });
    }
}
