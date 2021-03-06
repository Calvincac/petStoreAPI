package tests.users;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.User;
import resources.BaseTest;

public class LoginTests extends BaseTest {
    private User user;

    @BeforeMethod
    public void beforeMethod() {
        user = dataBuilder.getUserAllFields();
        userService.addAnUser(user);
    }

    @Test
    public void canLogin() {
        userService.login(user.getUsername(), user.getPassword());
    }

    //Bug
    @Test(enabled=false)
    public void cannotLoginWithInvalidUserName() {
        userService.loginError(faker.internet().avatar(), user.getPassword());
    }

    //Bug
    @Test(enabled=false)
    public void cannotLoginWithInvalidPassword() {
        userService.loginError(user.getUsername(), user.getPassword());
    }

    //Bug
    @Test(enabled=false)
    public void cannotLoginWithInvalidPasswordAndInvalidUsername() {
        userService.loginError(faker.ancient().primordial(), faker.internet().password());
    }

    //Bug
    @Test(enabled=false)
    public void cannotLoginEmptyPassword() {
        userService.loginError(user.getUsername(), "");
    }

    //Bug
    @Test(enabled=false)
    public void cannotLoginEmptyUserName() {
        userService.loginError("", user.getPassword());
    }

    //Bug
    @Test(enabled=false)
    public void cannotLoginEmptyUserNameAndPassword() {
        userService.loginError("", "");
    }
}
