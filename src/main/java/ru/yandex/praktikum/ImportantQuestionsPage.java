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
    private By howMuchDoesItCost = By.xpath(
            "//div[text()='Сколько это стоит? И как оплатить?']");
    private By wantSeveralScooters = By.xpath(
            "//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    private By howToCalculateRentTime = By.xpath(
            "//div[text()='Как рассчитывается время аренды?']");
    private By canOneMakeOrderForToday = By.xpath(
            "//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    private By canOneProlongAnOrder = By.xpath(
            "//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    private By doYouBringACharger = By.xpath(
            "//div[text()='Вы привозите зарядку вместе с самокатом?']");
    private By canOneCancelAnOrder = By.xpath(
            "//div[text()='Можно ли отменить заказ?']");
    private By ifILiveOutOfMKAD = By.xpath(
            "//div[text()='Я жизу за МКАДом, привезёте?']");

    public ImportantQuestionsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(URL);
    }

    //Метод, который будет кликать по кнопке "Cookies" + JavascriptExecutor для скролла до кнопки "Cookies"
    public void clickCookieButton() {
        jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriver.findElement(cookieButton).click();
    }

    public void clickQuestion(
            By questionLocator) {
        webDriver.findElement(questionLocator).click();
    }

    public boolean isAnswerDisplayed(
            By answerLocator) {
        return !webDriver.findElements(answerLocator).isEmpty();
    }

    public By getQuestionLocatorByText(String textOfQuestion) {
        return By.xpath("//div[text()='" + textOfQuestion + "']");
    }

    public By getAnswerLocatorByText(String answerText) {
        return By.xpath("//div[p[contains(text(),'" + answerText + "')]]");
    }
}
