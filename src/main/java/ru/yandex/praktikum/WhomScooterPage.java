package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class WhomScooterPage {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver webDriver;

    public WhomScooterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Локаторы страницы "Для кого самокат"
    private final By orderButton = By.xpath("//*[@id='root']/div/div/div[1]/div[2]/button[1]");
    private final By orderName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    private final By orderSurname = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input");
    private final By orderAddress = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");
    private final By stationField = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div");
    private final By stationName = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div/input");
    private final By orderPhone = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    private final By nextButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button");

    //Локаторы страницы "Про Аренду"

    private final By orderDate = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/input");
    private final By orderPeriod = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div/div[1]");
    private final By orderColor = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/label[1]");
    private final By orderComment = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input");
    private final By ConfirmButton = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");

    public void open() {
        webDriver.get(URL);
    }

    //Методы страницы "Для кого самокат"

    public void clickOrderButton() {
        webDriver.findElement(orderButton).click();
    }

    public void insertOrderName(String name) {
        webDriver.findElement(orderName).sendKeys(name);
    }

    public void insertOrderSurname(String surname) {
        webDriver.findElement(orderSurname).sendKeys(surname);
    }

    public void insertOrderAddress(String address) {
        webDriver.findElement(orderAddress).sendKeys(address);
    }

    public void clickStationField() {
        webDriver.findElement(stationField).click();
    }

    public void insertStationName(String station) {
        webDriver.findElement(stationName).sendKeys(station, Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void insertOrderPhone(String phone) {
        webDriver.findElement(orderPhone).sendKeys(phone);
    }

    public void clickNextButton() {
        webDriver.findElement(nextButton).click();
    }

    //Методы страницы "Про Аренду"

    public void clickOrderDate() {
        webDriver.findElement(orderDate).click();
        webDriver.findElement(orderDate).sendKeys(Keys.ENTER);
    }

    public void clickOrderPeriod() {
        webDriver.findElement(orderPeriod).click();
    }

    public void clickOrderColor() {
        webDriver.findElement(orderColor).click();
    }

    public void clickOrderComment(String comment) {
        webDriver.findElement(orderComment).sendKeys(comment);
    }

    public void clickConfirmButton() {
        webDriver.findElement(ConfirmButton).click();
    }
}

