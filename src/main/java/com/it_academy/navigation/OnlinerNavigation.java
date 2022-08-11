package com.it_academy.navigation;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.it_academy.ui_tests.OnlinerHeaderPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.it_academy.framework.WebDriverFactoryStaticThreadRemote.*;

public class OnlinerNavigation {

    private static final String ONLINER_URL = "https://onliner.by";
    private static final Logger LOG = LoggerFactory.getLogger(OnlinerNavigation.class);

    public static void openOnlinerHeaderPage(){
        Selenide.open(ONLINER_URL);
        new OnlinerHeaderPage();
    }

    public static synchronized void openOnlinerHeaderPage(String browser, boolean remote){
        setDriver(browser, remote);
        Configuration.browser = browser;
        Selenide.open(ONLINER_URL);
        LOG.info(browser + "has been opened");
        new OnlinerHeaderPage();
    }
}
