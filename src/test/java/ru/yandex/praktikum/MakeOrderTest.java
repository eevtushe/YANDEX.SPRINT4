package ru.yandex.praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MakeOrderTest {
    private final String testName;
    private final String testSurname;
    private final String testAddress;
    private final int testStation;
    private final String testPhone;
    private final int testDate;
    private final String testPeriod;
    private final String testColor;
    private final String testComment;
    public MakeOrderTest(String testName, String testSurname, String testAddress, int testStation, String testPhone, int testDate, String testPeriod, String testColor, String testComment ) {
        this.testName = testName;
        this.testSurname = testSurname;
        this.testAddress = testAddress;
        this.testStation = testStation;
        this.testPhone = testPhone;
        this.testDate = testDate;
        this.testPeriod = testPeriod;
        this.testColor = testColor;
        this.testComment = testComment;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"Сергей", "Петров", "ул. Усова, 4", 3, "+79818410000", 1, "cутки", "black", "Жду заказ, спасибо"},
                {"Василий", "Кузнецов", "ул. Павлова, 5", 2, "+79818410022", 1, "трое суток", "grey", "Жду, спасибо"},
        });
    }
    @Test
    public void MakeOrderTest() {

        //Создаем объект драйвера, который будет управлять нашим браузером
        WebDriver webDriver = new ChromeDriver();
        //Открываем сайт с помощью драйвера
        webDriver.get("https://qa-scooter.praktikum-services.ru");
        //Кликаем по кнопке заказа
        webDriver.findElement(By.xpath("//*[@id='root']/div/div/div[1]/div[2]/button[1]")).click();

        //Заполняем поля (Имя, Фамилия, Адрес)
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input")).sendKeys(testName);
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/input")).sendKeys(testSurname);
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input")).sendKeys(testAddress);

        //Выбираем из выпадающего списка станцию метро
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div")).click();
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/div[2]")).click();

        //Заполняем поля (Телефон)
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input")).sendKeys(testPhone);

        //Нажимаем на кнопку "Далее"
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[3]/button")).click();

        //Вторая страница заказа

        //Выбор даты
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/input")).click();
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")).click();
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]")).click();

        //Выбор поля срока аренды
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]")).click();
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]")).click();
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]")).click();

        //Выбираем цвет
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/div")).click();
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]")).click();

        //Комментарий
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input")).sendKeys(testComment);

        //Жмем кнопку заказа
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]")).click();

        //Тест падает, так как кнопка "Да" не работает - это баг
        webDriver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]")).click();

        webDriver.quit();
    }
}

