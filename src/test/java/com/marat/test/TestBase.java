package com.marat.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    String URL = "https://demoqa.com/automation-practice-form";

    @BeforeAll
    public static void beforeAll() {
        Configuration.browserSize = "2560x1440";
    }
}
