package ru.restoclub;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.CredentialsConfig;
import helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import static java.lang.String.format;

public class TestBase {
    @BeforeAll
    static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;

        CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
        Configuration.remote = format("https://%s:%s@selenoid.autotests.cloud/wd/hub/", credentials.testCloudLogin(), credentials.testCloudPassword());
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.clearBrowserCookies();
    }
}
