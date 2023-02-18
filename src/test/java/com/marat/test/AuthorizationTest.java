package com.marat.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.marat.pages.AuthPage.*;
import static com.marat.test.TestData.loginInput;
import static com.marat.test.TestData.passwordInput;
import static io.qameta.allure.Allure.step;

public class AuthorizationTest extends TestBase{

    @Test
    @Tag("smoke")
    @DisplayName("Authorization")
    void authTest() {
        step("Open home page", () -> {
            open(URL2);
            sleep(3000);
        });

        step("Set login", () -> {
            $(userItem).hover();
            sleep(1000);
            $(loginButton).click();
            $(loginTextInput).setValue(loginInput);
            sleep(1000);
        });

        step("Set pass", () -> {
            $(passwordTextInput).setValue(passwordInput);
            sleep(1000);
        });

        step("Click login", () -> {
            $(submitButton).click();
            sleep(1000);
        });

        step("Check successful auth", () -> {
            $(userItem2).hover();
            $(logoutText).shouldHave(Condition.text("Выйти из системы"));
            sleep(1000);
        });
    }
}
