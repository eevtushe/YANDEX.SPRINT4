package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImportantQuestionsPage {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver webDriver;

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

    public void ClickHowMuchDoesItCost() {
        webDriver.findElement(howMuchDoesItCost).click();
    }

    public void ClickWantSeveralScooters() {
        webDriver.findElement(wantSeveralScooters).click();
    }

    public void ClickHowToCalculateRentTime() {
        webDriver.findElement(howToCalculateRentTime).click();
    }

    public void ClickCanOneMakeOrderForToday() {
        webDriver.findElement(canOneMakeOrderForToday).click();
    }

    public void ClickCanOneProlongAnOrder() {
        webDriver.findElement(canOneProlongAnOrder).click();
    }

    public void ClickDoYouBringACharger() {
        webDriver.findElement(doYouBringACharger).click();
    }

    public void ClickCanOneCancelAnOrder() {
        webDriver.findElement(canOneCancelAnOrder).click();
    }

    public void ClickIfILiveOutOfMKAD() {
        webDriver.findElement(ifILiveOutOfMKAD).click();
    }
}
