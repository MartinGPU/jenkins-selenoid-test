package com.marat.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTest extends TestBase {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            gender = "Male",
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            userSubject = "Math",
            userAddress = faker.address().fullAddress(),
            userHobbie1 = "Haryana",
            userHobbie2 = "Karnal",
            userHobbie3 = "Math",
            userHobbie4 = "Music",
            birthDay = "10",
            birthMonth = "February",
            birthYear = "1987",
            userPhoto = "photo_2022-11-10_13-45-13.jpg",
            filePath = "img/photo_2022-11-10_13-45-13.jpg",
            formText = "Thanks for submitting the form";

    @Test
    void fillFormTest() {
        open(URL);
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(byClassName("react-datepicker__month-select")).click();
        $(byValue("1")).click();
        $(byClassName("react-datepicker__year-select")).click();
        $(byValue("1987")).click();
        $(byClassName("react-datepicker__day--010")).click();
        $("#subjectsInput").setValue(userSubject).pressEnter();
        $(byText(userHobbie4)).click();
        $("#uploadPicture").uploadFromClasspath(filePath);
        $("#currentAddress").setValue(userAddress);
        $("#react-select-3-input").setValue(userHobbie1).pressEnter();
        $("#react-select-4-input").setValue(userHobbie2).pressEnter();
        $("#submit").pressEnter();
        $("#example-modal-sizes-title-lg").shouldHave(text(formText));
        $(byTagName("tbody")).shouldHave(text(firstName + " " + lastName))
                .shouldHave(text(userEmail))
                .shouldHave(text(gender))
                .shouldHave(text(userNumber))
                .shouldHave(text(birthDay + " " + birthMonth + "," + birthYear))
                .shouldHave(text(userHobbie3))
                .shouldHave(text(userHobbie4))
                .shouldHave(text(userPhoto))
                .shouldHave(text(userAddress))
                .shouldHave(text(userHobbie1 + " " + userHobbie2));
        $(byText("Close")).pressEnter();
    }
}
