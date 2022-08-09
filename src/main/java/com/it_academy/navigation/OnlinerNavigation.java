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

    public static synchronized void openOnlinerHeaderPage(String browser, boolean remote){
        setDriver(browser, remote);
        Configuration.browser = browser;
        Selenide.open(ONLINER_URL);
        new OnlinerHeaderPage();
    }
}
