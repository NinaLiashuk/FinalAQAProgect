package com.it_academy.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactoryStaticThreadRemote {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static CapabilityFactory capabilityFactory = new CapabilityFactory();

    public static void setDriver(String browser) {
        try {
            driver.set(new RemoteWebDriver(new URL("http://192.168.0.52:4444/"),
                    capabilityFactory.getCapabilities(browser)));
        } catch (MalformedURLException e) {
            System.out.println("Cannot create connection with remote server");
            e.printStackTrace();
        }
    }

    public static void setDRIVE(String browser) {
        if(browser.equals("firefox")){
            driver.set(new FirefoxDriver());
        }
        if(browser.equals("edge")){
           driver.set(new EdgeDriver());
        }  else{
            driver.set(new ChromeDriver());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().close();
        driver.remove();
    }
}
