package test;

import com.codeborne.selenide.Selenide;
import data.InvalidData;
import data.ValidData;
import helpers.FakeData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.CheckColor;
import page.PutData;
import settings.SetP;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Проверка формы регистрации студента")

public class StartTest  extends SetP {
    CheckColor checkFields = new CheckColor();
    ValidData validData = new ValidData();
    PutData putData = new PutData();
    InvalidData invalidData = new InvalidData();
    FakeData fakeData = new FakeData();


    @Test
    @DisplayName("Проверка заполнения формы валидными данными")
    public void fillUpPageTest() {
        putData.openPage()
                .setFirstName(validData.getFirstName())
                .setLastName(validData.getLastName())
                .setEmail(validData.getEmail())
                .setGender()
                .setMobileNumber(validData.getMobileNumber())
                .setCalendar( validData.getYear(), validData.getMonth(), validData.getDay())
                .setSubjects(validData.getSubjects())
                .setHobbies()
                .setPicture(validData.getFile())
                .setCurrentAddress(validData.getAddress())
                .setState(validData.getState())
                .setCity(validData.getCity());
        Selenide.executeJavaScript("document.querySelector('#submit').click();");

        Selenide.sleep(100);

        checkFields.checkVisible()
                .checkResult("Student Name", validData.getFirstName() + " " + validData.getLastName()
                        , "имя и фамилию")
                .checkResult("Student Email", validData.getEmail(), "почту")
                .checkResult("Gender", validData.getGender(), "пол")
                .checkResult("Mobile", validData.getMobileNumber(), "номер телефона")
                .checkResult("Date of Birth", validData.getDay() + " " + validData.getMonth() + ","
                        + validData.getYear(), "дату рождения")
                .checkResult("Subjects", validData.getSubjects(), "предмет")
                .checkResult("Hobbies", validData.getHobbies(), "хобби")
                .checkResult("Picture", validData.getFile(), "загруженный файл")
                .checkResult("Address", validData.getAddress(), "адрес")
                .checkResult("State and City", validData.getState() + " " + validData.getCity(),
                        "штат и город");
    }

    @Test
    @DisplayName("Валидация полей.Оставляем поля не заполненными")
    public void fillUpPageNegativeTest() {
            putData.openPage();
        Selenide.executeJavaScript("document.querySelector('#submit').click();");

        Selenide.sleep(500);

        assertThat(invalidData.getInputRedColor()).as("Ввод имени - цвет не совпадает")
                .isEqualTo(putData.InputGetCssValueFirstName());
        assertThat(invalidData.getInputRedColor()).as("Ввод фамилии - цвет не совпадает")
                .isEqualTo(putData.InputGetCssValueLastName());
        assertThat(invalidData.getInputRedColor()).as("Ввод телефона - цвет не совпадает")
                .isEqualTo(putData.InputGetCssValueMobileNumber());
        assertThat(putData.ButtonGetCssValueGender())
                .as("Кнопка выбора пола - цвет не совпадает")
                .isEqualTo(invalidData.getButtonRedColor());
    }



    @Test
    @DisplayName("Валидация полей.Вводим в поле телефон буквы")
    public void inputTelephoneNumberNegativeTest() {
            putData.openPage()
                .setMobileNumber(invalidData.getTelephone());
        Selenide.executeJavaScript("document.querySelector('#submit').click();");

        Selenide.sleep(500);

        assertThat(invalidData.getInputRedColor()).as("Ввод телефона - цвет не совпадает")
                .isEqualTo(putData.InputGetCssValueMobileNumber());

    }
}
