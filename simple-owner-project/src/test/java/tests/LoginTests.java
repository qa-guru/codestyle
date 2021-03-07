package tests;

import config.ConfigHelper;
import org.junit.jupiter.api.Test;

class LoginTests {

    @Test
    void fakeLoginTest() {
        String login = ConfigHelper.getUserLogin();
        String password = ConfigHelper.getUserPassword();
        String message = String.format("Try to authorize with login %s and password %s", login, password);

        System.out.println(message);
    }
}
