package ru.yandex.praktikum;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WhomScooterPage {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver webDriver;

    public WhomScooterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Локаторы страницы "Для кого самокат"
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By orderName = By.xpath(".//input[@placeholder='* Имя']");
    private final By orderSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By orderAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By stationName = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By orderPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локаторы страницы "Про Аренду"
    private final By orderDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By orderPeriod = By.xpath(".//div[@class='Dropdown-control']");
    private final By orderPeriod2 = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    private final By orderColor = By.xpath(".//label[@for='black']");
    private final By orderComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By ConfirmButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By orderConfirmationWindow = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");
    private final By confirmationButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public void open() {
        webDriver.get(URL);
    }

    //Методы страницы "Для кого самокат"

    public void clickOrderButton() {
        //В этом коде я использовал JavascriptExecutor
        //В данном случае это помогло обойти проблему "element click intercepted", так как я постоянно ловил эту ошибку, и обычное ожидание не срабатывало
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement orderButtonElement = wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", orderButtonElement);
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

    public void clickStationField(String station) {
        webDriver.findElement(stationName).click();
        webDriver.findElement(stationName).sendKeys(station, Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void insertOrderPhone(String phone) {
        webDriver.findElement(orderPhone).sendKeys(phone);
    }

    public void clickNextButton() {
        webDriver.findElement(nextButton).click();
    }

    //Методы страницы "Про Аренду"

    public void clickOrderDate(int date) {
        webDriver.findElement(orderDate).click();
        webDriver.findElement(orderDate).sendKeys(Keys.ENTER);
    }

    public void clickOrderPeriod() {
        webDriver.findElement(orderPeriod).click();
        webDriver.findElement(orderPeriod2).click();
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
    public void assertOrderConfirmationWindowVisible() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement window = wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationWindow));

        Assert.assertTrue("Окно заказа отсутствует", window.isDisplayed());
        System.out.println("Окно заказа присутствует");
    }
    public void clickConfirmationButton() {
        webDriver.findElement(confirmationButton).click();
    }
}