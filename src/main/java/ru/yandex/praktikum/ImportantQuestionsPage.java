package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ImportantQuestionsPage {
    private final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver webDriver;
    protected JavascriptExecutor jse;

    //Локатор кнопки "Cookies"
    private By cookieButton = By.xpath(".//*[@id='rcc-confirm-button']");

    //Локаторы вопросов на главной странице
    private By howMuchDoesItCost = By.xpath("//*[@id='accordion__heading-0']");
    private By wantSeveralScooters = By.xpath("//*[@id='accordion__heading-1']");
    private By howToCalculateRentTime = By.xpath("//*[@id='accordion__heading-2']");
    private By canOneMakeOrderForToday = By.xpath("//*[@id='accordion__heading-3']");
    private By canOneProlongAnOrder = By.xpath("//*[@id='accordion__heading-4']");
    private By doYouBringACharger = By.xpath("//*[@id='accordion__heading-5']");
    private By canOneCancelAnOrder = By.xpath("//*[@id='accordion__heading-6']");
    private By ifILiveOutOfMKAD = By.xpath("//*[@id='accordion__heading-7']");

    public ImportantQuestionsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(URL);
    }
    public void clickCookieButton() {
        jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriver.findElement(cookieButton).click();
    }

    public void clickHowMuchDoesItCost() {
        webDriver.findElement(howMuchDoesItCost).click();
    }

    public void clickWantSeveralScooters() {
        webDriver.findElement(wantSeveralScooters).click();
    }

    public void clickHowToCalculateRentTime() {
        webDriver.findElement(howToCalculateRentTime).click();
    }

    public void clickCanOneMakeOrderForToday() {
        webDriver.findElement(canOneMakeOrderForToday).click();
    }

    public void clickCanOneProlongAnOrder() {
        webDriver.findElement(canOneProlongAnOrder).click();
    }

    public void clickDoYouBringACharger() {
        webDriver.findElement(doYouBringACharger).click();
    }

    public void clickCanOneCancelAnOrder() {
        webDriver.findElement(canOneCancelAnOrder).click();
    }

    public void clickIfILiveOutOfMKAD() {
        webDriver.findElement(ifILiveOutOfMKAD).click();
    }
}
