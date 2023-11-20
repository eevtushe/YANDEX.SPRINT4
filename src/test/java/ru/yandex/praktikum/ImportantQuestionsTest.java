package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends BaseTest{

    private final By panelLocator;

    public ImportantQuestionsTest(By panelLocator) {
        this.panelLocator = panelLocator;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testDataOne() {
        return Arrays.asList(new Object[][]{
                {By.xpath("//*[@id='accordion__panel-0']")},
                {By.xpath("//*[@id='accordion__panel-1']")},
                {By.xpath("//*[@id='accordion__panel-2']")},
                {By.xpath("//*[@id='accordion__panel-3']")},
                {By.xpath("//*[@id='accordion__panel-4']")},
                {By.xpath("//*[@id='accordion__panel-5']")},
                {By.xpath("//*[@id='accordion__panel-6']")},
                {By.xpath("//*[@id='accordion__panel-7']")}
        });
    }

    @Test
    public void questionsTest() {
        ImportantQuestionsPage importantQuestionsPage = new ImportantQuestionsPage(webDriver);

        //Вызываем метод, который будет скроллить страницу вниз и кликать по кнопке "Cookies"
        importantQuestionsPage.clickCookieButton();

        //Вызов методов, которые открывают категорию "Вопросы/Ответы"
        importantQuestionsPage.clickHowMuchDoesItCost();
        importantQuestionsPage.clickWantSeveralScooters();
        importantQuestionsPage.clickHowToCalculateRentTime();
        importantQuestionsPage.clickCanOneMakeOrderForToday();
        importantQuestionsPage.clickCanOneProlongAnOrder();
        importantQuestionsPage.clickDoYouBringACharger();
        importantQuestionsPage.clickCanOneCancelAnOrder();
        importantQuestionsPage.clickIfILiveOutOfMKAD();

        //Проверяем, что ответы на вопросы есть
        Assert.assertFalse("Выпадающий ответ на вопрос", webDriver.findElements(panelLocator).isEmpty());
    }
}
