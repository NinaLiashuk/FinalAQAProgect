package com.it_academy.navigation;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.it_academy.page_object.OnlinerHeaderPage;

import static com.it_academy.driver.WebDriverFactoryStaticThreadRemote.*;

public class OnlinerNavigation {

    private static final String ONLINER_URL = "https://onliner.by";

    public static void openOnlinerHeaderPage(){
        Selenide.open(ONLINER_URL);
        new OnlinerHeaderPage();
    }

    public static synchronized OnlinerHeaderPage openOnlinerHeaderPage(String browser, boolean remote){
        setSetDriver(browser, remote);
        Configuration.browser = browser;
        Selenide.open(ONLINER_URL);
        return new OnlinerHeaderPage();
    }
}
