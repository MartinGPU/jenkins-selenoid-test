package com.marat.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AuthPage {

    public static SelenideElement
            userItem = $("[data-ti='login_link']"),
            loginTextInput = $("[data-ti='email-field']"),
            passwordTextInput = $("[data-ti='password-field']"),
            submitButton = $("[data-ti='submit-trigger']"),
            userItem2 = $("[data-ti='user_name_link']");
}
