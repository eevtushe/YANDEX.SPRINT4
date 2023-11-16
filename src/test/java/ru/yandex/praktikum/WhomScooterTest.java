package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class WhomScooterTest extends BaseTest{

    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String phone;

    private final int date;
    private final String period;
    private final String color;
    private final String comment;

    public WhomScooterTest(String name, String surname, String address, String station, String phone, int date, String period, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Сергей", "Иванов", "Усова,3", "Бульвар Рокоссовского", "+79818410000", 16, "сутки", "черный жемчуг", "Очень жду свой заказ"},
                {"Иван", "Петров", "Иванова,5", "Бульвар Рокоссовского", "+79818410022", 16, "сутки", "черный жемчуг", "Очень жду свой заказ"}
        });
    }
    @Test
    public void OrderTest() {

        WhomScooterPage WhomScooterPage = new WhomScooterPage(webDriver);

        //Вызов методов страницы "Для кого самокат"

        WhomScooterPage.clickOrderButton();
        WhomScooterPage.insertOrderName(name);
        WhomScooterPage.insertOrderSurname(surname);
        WhomScooterPage.insertOrderAddress(address);
        WhomScooterPage.clickStationField();
        WhomScooterPage.insertStationName(station);
        WhomScooterPage.insertOrderPhone(phone);
        WhomScooterPage.clickNextButton();

        //Вызов методов страницы "Про аренду"

        WhomScooterPage.clickOrderDate();
        WhomScooterPage.clickOrderPeriod();
        WhomScooterPage.clickOrderColor();
        WhomScooterPage.clickOrderComment(comment);
        WhomScooterPage.clickConfirmButton();
    }
}

