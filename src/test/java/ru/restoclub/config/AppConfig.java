package ru.restoclub.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:ru.restoclub.config/app.properties"
})
public interface AppConfig extends Config {

    String webUrl();
    String apiUrl();
    String userLogin();
    String userPassword();

}
