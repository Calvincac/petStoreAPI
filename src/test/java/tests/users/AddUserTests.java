package tests.users;

import incorrect.IncorrectUser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.User;
import resources.BaseTest;

import java.util.List;

public class AddUserTests extends BaseTest {

    private User user;

    @BeforeMethod
    public void beforeMethod() {
        user = dataBuilder.getUserAllFields();
    }

    @Test
    public void canCreateAnUserAllFields() {
        userService.addAnUser(user);
    }

    @Test
    public void canCreateAnUserWithoutUsername() {
        user.setUsername(null);
        userService.addAnUser(user);
    }

    @Test
    public void canCreateAnUserWithoutFirstName() {
        user.setFirstName(null);
        userService.addAnUser(user);
    }

    @Test
    public void canCreateAnUserWithoutLastName() {
        user.setLastName(null);
        userService.addAnUser(user);
    }

    @Test
    public void canCreateAnUserWithoutId() {
        user.setId(null);
        userService.addAnUser(user);
    }

    @Test
    public void canCreateAnUserWithoutEmail() {
        user.setEmail(null);
        userService.addAnUser(user);
    }

    @Test
    public void canCreateAnUserWithoutPassword() {
        user.setPassword(null);
        userService.addAnUser(user);
    }

    @Test
    public void canCreateAnUserWithoutPhone() {
        user.setPhone(null);
        userService.addAnUser(user);
    }

    @Test
    public void canCreateAnUserWithoutUserStatus() {
        user.setUserStatus(null);
        userService.addAnUser(user);
    }

    @Test
    public void cannotCreateAnUserWithArrayOfFirstNames() {
        IncorrectUser incorrectUser = new IncorrectUser();
        incorrectUser.setFirstName(List.of("da"));
        userService.addAnUserInternalServerError(incorrectUser);
    }

}
