package data;

import com.github.javafaker.Faker;
import pojo.*;

import java.util.ArrayList;
import java.util.List;

public class DataBuilder {
    private Faker faker = new Faker();
    private User user;
    private List<User> users = new ArrayList<User>();

    public Pet getPetAllFields() {
        Pet pet = new Pet();
        pet.setStatus(Status.AVAILABLE);
        pet.setName(faker.funnyName().name());
        pet.setId((long) faker.number().numberBetween(2,78989678));
        Category category = new Category();
        category.setId((long) faker.number().numberBetween(2,78989678));
        category.setName(faker.name().firstName());
        pet.setCategory(category);
        Tag tag = new Tag();
        tag.setId((long) faker.number().numberBetween(2,78989678));
        tag.setName(faker.name().lastName());
        pet.setTags(List.of(tag));
        pet.setPhotoUrls(List.of(faker.company().url()));
        return pet;
    }

    public Order getOrderAllFields() {
        Order order = new Order();
        order.setId((long) faker.number().numberBetween(2,78989678));
        order.setQuantity(faker.number().numberBetween(2,344334));
        order.setStatus("placed");
        order.setComplete(true);
        return order;
    }

    public User getUserAllFields() {
        User user = new User();
        user.setId((long) faker.number().numberBetween(2,78989678));
        user.setEmail(faker.internet().emailAddress());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setUsername(faker.name().username());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().phoneNumber());
        user.setUserStatus(faker.number().randomDigitNotZero());
        return user;
    }

    public List<User> getListOfUsers(int numberOfUsers) {
        for (int i = 0; i < numberOfUsers; i++) {
            user = getUserAllFields();
            users.add(user);
        }
        return users;
    }
}
