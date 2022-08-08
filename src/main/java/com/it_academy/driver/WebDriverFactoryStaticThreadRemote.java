package com.it_academy.driver;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

import static com.it_academy.driver.CapabilityFactory.getCapabilities;
import static com.it_academy.rest_api.property.PropertiesReader.getGridUrl;

public class WebDriverFactoryStaticThreadRemote {

    private static final ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static void setSetDriver(String browser, boolean remote) {
        if(!remote){
            if(browser.equals("firefox")){
                Configuration.browser = "firefox";
            }
            if(browser.equals("edge")){
                Configuration.browser = "edge";
            }  else {
                Configuration.browser = "chrome";
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
