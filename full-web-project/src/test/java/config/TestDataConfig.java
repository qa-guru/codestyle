package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/authorization.properties"
})
public interface TestDataConfig extends Config {
    @Key("app.url")
    String googleUsername();

    @Key("google.password")
    String googlePassword();
}
