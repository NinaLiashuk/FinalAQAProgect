package com.it_academy.utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    protected final static Logger LOG = LoggerFactory.getLogger(ScreenshotUtils.class);

    private ScreenshotUtils(){
    }

    public static void takeScreenshorAndAttachToAllureReport(){
        try {
            File screecshotAs = Screenshots.takeScreenShotAsFile();
            Allure.addAttachment("Screenshot", FileUtils.openInputStream(screecshotAs));
        }catch (IOException e){
            LOG.error("Error creating screenshot");
        }
    }
}
