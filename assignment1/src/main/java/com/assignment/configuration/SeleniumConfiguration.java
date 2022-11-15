package com.assignment.configuration;

import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfiguration {
    void postConstruct()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/adamr/Downloads/**/chromedriver_win32");
    }

    public ChromeDriver driver()
    {
        return new ChromeDriver();
    }

}
