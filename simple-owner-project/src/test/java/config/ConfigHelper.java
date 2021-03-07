package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
    public static String getUserLogin() {
        return getWebConfig().userLogin();
    }

    public static String getUserPassword() {
        return getWebConfig().userPassword();
    }

    private static TestConfig getWebConfig() {
        return ConfigFactory.newInstance().create(TestConfig.class, System.getProperties());
    }
}
