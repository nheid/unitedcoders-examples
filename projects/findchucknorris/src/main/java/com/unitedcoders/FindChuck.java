package com.unitedcoders;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class FindChuck {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("javascript.enabled", false);
        driver = new FirefoxDriver(profile);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void testFindchuck() throws Exception {
        driver.get("http://google.com");
        driver.findElement(By.id("lst-ib")).sendKeys("find chuck norris");
        driver.findElement(By.name("btnI")).click();
        driver.findElement(By.id("t1a"));
        assertTrue(StringUtils.contains(driver.getPageSource().toString(),
                "Google won't search for <b>Chuck Norris</b> because it knows you don't find <b>Chuck Norris</b>, he finds you"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
