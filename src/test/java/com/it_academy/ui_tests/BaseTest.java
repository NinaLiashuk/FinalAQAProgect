package com.it_academy.ui_tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.listeners.AllureListener;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(AllureListener.class)
public class BaseTest {

    @BeforeClass
    public void setUp(){
        SelenideLogger
                .addListener("AllureSelenude",
                        new AllureSelenide().screenshots(true).savePageSource(true));
    }
}
