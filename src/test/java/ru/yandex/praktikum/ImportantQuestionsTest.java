package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends BaseTest {

    private final By questionLocator;
    private final By answerLocator;

    public ImportantQuestionsTest(By questionLocator, By answerLocator) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
    }

    //Положил в параметры сами локаторы, так как вызвать поля, созданные в ImportantQuestionsPage, я не могу.
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {By.xpath("//div[text()='Сколько это стоит? И как оплатить?']"), By.xpath("//div[p[contains(text(),'Сутки — 400 рублей. Оплата курьеру — наличными или картой.')]]")},
                {By.xpath("//div[text()='Хочу сразу несколько самокатов! Так можно?']"), By.xpath("//div[p[contains(text(),'Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.')]]")},
                {By.xpath("//div[text()='Как рассчитывается время аренды?']"), By.xpath("//div[p[contains(text(),'Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.')]]")},
                {By.xpath("//div[text()='Можно ли заказать самокат прямо на сегодня?']"), By.xpath("//div[p[contains(text(),'Только начиная с завтрашнего дня. Но скоро станем расторопнее.')]]")},
                {By.xpath("//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']"), By.xpath("//div[p[contains(text(),'Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.')]]")},
                {By.xpath("//div[text()='Вы привозите зарядку вместе с самокатом?']"), By.xpath("//div[p[contains(text(),'Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.')]]")},
                {By.xpath("//div[text()='Можно ли отменить заказ?']"), By.xpath("//div[p[contains(text(),'Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.')]]")},
                {By.xpath("//div[text()='Я жизу за МКАДом, привезёте?']"), By.xpath("//div[p[contains(text(),'Да, обязательно. Всем самокатов! И Москве, и Московской области.')]]")},
        });
    }

    @Test
    public void questionsTest() {
        ImportantQuestionsPage importantQuestionsPage = new ImportantQuestionsPage(webDriver);
        importantQuestionsPage.clickCookieButton();

            importantQuestionsPage.clickQuestion(questionLocator);
            Assert.assertTrue("Текст с ответом не появился",importantQuestionsPage.isAnswerDisplayed(answerLocator));
        }
    }