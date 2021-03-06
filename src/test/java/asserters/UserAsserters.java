package asserters;

import pojo.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserAsserters {

    public static void assertUser(User expectedUser, User retrievedUser) {
        assertThat(expectedUser.getId(), equalTo(retrievedUser.getId()));
        assertThat(expectedUser.getEmail(), equalTo(retrievedUser.getEmail()));
        assertThat(expectedUser.getUsername(), equalTo(retrievedUser.getUsername()));
        assertThat(expectedUser.getUserStatus(), equalTo(retrievedUser.getUserStatus()));
        assertThat(expectedUser.getFirstName(), equalTo(retrievedUser.getFirstName()));
        assertThat(expectedUser.getLastName(), equalTo(retrievedUser.getLastName()));
        assertThat(expectedUser.getPhone(), equalTo(retrievedUser.getPhone()));
    }
}
