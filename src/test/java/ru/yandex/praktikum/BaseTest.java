package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected WebDriver webDriver;

    //До теста происходит открытие сайта + добавлено ожидание
    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //Сюда я вынес закрытие браузера после всех тестов
    @After
    public void closeBrowser() {
        webDriver.quit();
    }
}