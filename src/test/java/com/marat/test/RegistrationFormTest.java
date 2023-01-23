package com.marat.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

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
        step("Open reg. page", () -> {
            open(URL2);
        });
        step("Set user data", () -> {
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(userEmail);
        });
        step("Select user gender", () -> {
            $(byText(gender)).click();
        });
        step("Set user phone number", () -> {
            $("#userNumber").setValue(userNumber);
        });
        step("Select user birth date", () -> {
            $("#dateOfBirthInput").click();
            $(byClassName("react-datepicker__month-select")).click();
            $(byValue("1")).click();
            $(byClassName("react-datepicker__year-select")).click();
            $(byValue("1987")).click();
            $(byClassName("react-datepicker__day--010")).click();
        });
        step("Set user subject", () -> {
            $("#subjectsInput").setValue(userSubject).pressEnter();
        });
        step("Select music hobby", () -> {
            $(byText(userHobbie4)).click();
        });
        step("Upload user image", () -> {
            $("#uploadPicture").uploadFromClasspath(filePath);
        });
        step("Set user address", () -> {
            $("#currentAddress").setValue(userAddress);
        });
        step("Set other user hobbies", () -> {
            $("#react-select-3-input").setValue(userHobbie1).pressEnter();
            $("#react-select-4-input").setValue(userHobbie2).pressEnter();
        });
        step("Submit form", () -> {
            $("#submit").pressEnter();
        });
        step("User data results checking", () -> {
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
        });
        step("Closing form", () -> {
            $(byText("Close")).pressEnter();
        });
    }
}
