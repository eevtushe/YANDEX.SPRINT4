package ru.yandex.praktikum;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected WebDriver webDriver;
    protected JavascriptExecutor jse;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        webDriver.get("https://qa-scooter.praktikum-services.ru/");

        jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriver.findElement(By.xpath(".//*[@id='rcc-confirm-button']")).click();
    }
    @After
    public void closeBrowser() {
        webDriver.quit();
   }
}