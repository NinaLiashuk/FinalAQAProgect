package com.it_academy.navigation;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.it_academy.driver.CapabilityFactory;
import com.it_academy.driver.WebDriverFactoryStaticThreadRemote;
import com.it_academy.pageObject.OnlinerHeaderPage;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OpenOnlinerPage{

    private static final String ONLINER_URL = "https://onliner.by";
    private WebDriverFactoryStaticThreadRemote remote = new WebDriverFactoryStaticThreadRemote();

    public static void openOnlinerHeaderPage(){
        Selenide.open(ONLINER_URL);
        new OnlinerHeaderPage();
    }

//    public static OnlinerHeaderPage openOnliner(String browser){
//        Configuration.browser = browser;
//        Selenide.open(ONLINER_URL);
//        return new OnlinerHeaderPage();
//    }

    public static OnlinerHeaderPage openOnlinerWithDriverLocal(String browser){
        WebDriverFactoryStaticThreadRemote.setDRIVE(browser);
        Configuration.browser = browser;
        Selenide.open(ONLINER_URL);
        return new OnlinerHeaderPage();
    }

    public static OnlinerHeaderPage openOnlinerWhisCapabilitiesRemote(String browser){
        WebDriverFactoryStaticThreadRemote.setDriver(browser);
        Configuration.browser = browser;
        Selenide.open(ONLINER_URL);
        return new OnlinerHeaderPage();
    }
}
