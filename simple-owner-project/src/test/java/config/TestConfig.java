package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/test.properties"
})
public interface TestConfig extends Config {
    @Key("user.login")
    String userLogin();

    @Key("user.password")
    String userPassword();
}
