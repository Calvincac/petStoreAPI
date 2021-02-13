package data;

import com.github.javafaker.Faker;
import pojo.Category;
import pojo.Pet;
import pojo.Status;
import pojo.Tag;

import java.util.List;

public class DataBuilder {
    Faker faker = new Faker();

    public Pet getPetAllFields() {
        Pet pet = new Pet();
        pet.setStatus(Status.AVAILABLE);
        pet.setName(faker.funnyName().name());
        pet.setId(Integer.parseInt(String.valueOf(faker.number().numberBetween(2,78989678))));
        Category category = new Category();
        category.setId(Integer.parseInt(faker.number().digit()));
        category.setName(faker.name().firstName());
        pet.setCategory(category);
        Tag tag = new Tag();
        tag.setId(Integer.parseInt(faker.number().digit()));
        tag.setName(faker.name().lastName());
        pet.setTags(List.of(tag));
        pet.setPhotoUrls(List.of(faker.company().url()));
        return pet;
    }
}
