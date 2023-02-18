package com.marat.test;

import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.marat.pages.AuthPage.*;
import static com.marat.test.TestData.loginInput;
import static com.marat.test.TestData.passwordInput;
import static io.qameta.allure.Allure.step;

    @Feature("Authorization")
public class AuthorizationTest extends TestBase{

    @Test
    @Tag("smoke")
    @AllureId("15003")
    @DisplayName("Successful login")
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
