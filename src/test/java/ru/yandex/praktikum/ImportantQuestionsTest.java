package ru.yandex.praktikum;
//Импортируем нужные библиотеки
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Создаем тестовый класс

public class ImportantQuestionsTest {

    //Пишем метод, который будет искать текст вопросов, кликать и проверять наличие ответов в выпадающем списке
    @Test
    public void ImportantQuestionsTest() {
        //Создаем объект драйвера, который будет управлять нашим браузером
        WebDriver webDriver = new ChromeDriver();
        //Открываем сайт с помощью драйвера
        webDriver.get("https://qa-scooter.praktikum-services.ru/");

        //Скроллим страницу вниз и кликаем по кнопке куки "Да все привыкли"
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        webDriver.findElement(By.xpath(".//*[@id='rcc-confirm-button']")).click();

        //Далее с помощью локаторов ищем нужные нам элементы выпадающего списка
        //1 - Сколько это стоит? И как оплатить?
        webDriver.findElement(By.xpath("//*[@id='accordion__heading-0']")).click();
        Assert.assertTrue("Выпадающий ответ на вопрос",
                !webDriver.findElements(By.xpath("//*[@id='accordion__panel-0']")).isEmpty());

        //2 - Хочу сразу несколько самокатов! Так можно?
        webDriver.findElement(By.xpath("//*[@id='accordion__heading-1']")).click();
        Assert.assertTrue("Выпадающий ответ на вопрос",
                !webDriver.findElements(By.xpath("//*[@id='accordion__panel-1']")).isEmpty());

        //3 - Как рассчитывается время аренды?
        webDriver.findElement(By.xpath("//*[@id='accordion__heading-2']")).click();
        Assert.assertTrue("Выпадающий ответ на вопрос",
                !webDriver.findElements(By.xpath("//*[@id='accordion__panel-2']")).isEmpty());

        //4 - Можно ли заказать самокат прямо на сегодня?
        webDriver.findElement(By.xpath("//*[@id='accordion__heading-3']")).click();
        Assert.assertTrue("Выпадающий ответ на вопрос",
                !webDriver.findElements(By.xpath("//*[@id='accordion__panel-3']")).isEmpty());

        //5 - Можно ли продлить заказ или вернуть самокат раньше?
        webDriver.findElement(By.xpath("//*[@id='accordion__heading-4']")).click();
        Assert.assertTrue("Выпадающий ответ на вопрос",
                !webDriver.findElements(By.xpath("//*[@id='accordion__panel-4']")).isEmpty());

        //6 - Вы привозите зарядку вместе с самокатом?
        webDriver.findElement(By.xpath("//*[@id='accordion__heading-5']")).click();
        Assert.assertTrue("Выпадающий ответ на вопрос",
                !webDriver.findElements(By.xpath("//*[@id='accordion__panel-5']")).isEmpty());

        //7 - Можно ли отменить заказ?
        webDriver.findElement(By.xpath("//*[@id='accordion__heading-6']")).click();
        Assert.assertTrue("Выпадающий ответ на вопрос",
                !webDriver.findElements(By.xpath("//*[@id='accordion__panel-6']")).isEmpty());

        //8 - Я жизу за МКАДом, привезёте?
        webDriver.findElement(By.xpath("//*[@id='accordion__heading-7']")).click();
        Assert.assertTrue("Выпадающий ответ на вопрос",
                !webDriver.findElements(By.xpath("//*[@id='accordion__panel-7']")).isEmpty());

        //Закрываем браузер
        webDriver.quit();
    }
}

