package com.it_academy.framework;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityFactory {

    public static DesiredCapabilities capabilities;

    public static DesiredCapabilities getCapabilities(String browser) {
        if (browser.equals("firefox"))
            capabilities = OptionsManager.getFirefoxDesiredCapabilities();
        else
            capabilities = OptionsManager.getChromeDesiredCapabilities();
        return capabilities;
    }
}
