package com.it_academy.framework;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

import static com.it_academy.framework.CapabilityFactory.getCapabilities;
import static com.it_academy.api_tests.property.PropertiesReader.getGridUrl;

public class WebDriverFactoryStaticThreadRemote {

    private static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String browser, boolean remote) {
        if(!remote){
            switch (browser){
                case "firefox" :
                    Configuration.browser = "firefox";
                    break;
                case "chrome" :
                    Configuration.browser = "chrome";
                    break;
            }
        }
        else {
            URL gridUrl = getGridUrl("gridUrl");
            driver.set(new RemoteWebDriver(gridUrl, getCapabilities(browser)));
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
       if (driver.get() != null){
           driver.get().close();
           driver.remove();
       }
    }
}
