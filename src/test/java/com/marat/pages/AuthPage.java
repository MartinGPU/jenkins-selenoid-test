package com.marat.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AuthPage {

    public static SelenideElement
            userItem = $$(".shortcut__item--wrapper").get(2),
            loginTextInput = $("[name = 'account']"),
            passwordTextInput = $("[name = 'password']"),
            loginButton = $("[href = '//ru.buy.mi.com/ru/site/login']"),
            submitButton = $("[type = 'submit']"),
            logoutText = $$(".view-account__item").get(3),
            productName = $("[aria-label = 'Смартфоны']"),
            smartPhoneManufacturer = $(".micon-nav-xiaomi"),
            scrollToProduct = $(".site-grid--quarter"),
            userItem2 = $$(".navigation__link").get(8);
}
