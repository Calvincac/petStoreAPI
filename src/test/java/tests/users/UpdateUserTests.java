package tests.users;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.User;
import resources.BaseTest;

import static asserters.UserAsserters.assertUser;

public class UpdateUserTests extends BaseTest {

    private User user, updatedUser;

    @BeforeMethod
    public void beforeMethod() {
        user = dataBuilder.getUserAllFields();
        userService.addAnUser(user);
    }

    @Test
    public void canUpdatePassword() {
        user.setPassword(faker.internet().password());
        updateAndAssertUser(user);
    }

    @Test
    public void canUpdateUserName() {
        String updatedUserName = faker.internet().emailAddress();
        user.setUsername(updatedUserName);
        userService.updateUser(user, user.getUsername());
        updatedUser = userService.retrieveUserByUserName(updatedUserName);
        assertUser(user, updatedUser);
    }

    @Test
    public void canUpdateLastName() {
        user.setLastName(faker.name().lastName());
        updateAndAssertUser(user);
    }

    @Test
    public void canUpdateFirstName() {
        user.setFirstName(faker.name().firstName());
        updateAndAssertUser(user);
    }

    @Test
    public void canUpdateEmail() {
        user.setEmail(faker.internet().emailAddress());
        updateAndAssertUser(user);
    }

    @Test
    public void canUpdatePhone() {
        user.setPhone(faker.phoneNumber().cellPhone());
        updateAndAssertUser(user);
    }

    private void updateAndAssertUser(User user) {
        userService.updateUser(user, user.getUsername());
        updatedUser = userService.retrieveUserByUserName(user.getUsername());
        assertUser(user, updatedUser);
    }

}
