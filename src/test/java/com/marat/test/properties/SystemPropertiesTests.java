package com.marat.test.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("properties")
    void someTest() {
        String browser = System.getProperty("browser", "yandex");
        String version = System.getProperty("version", "23");
        String bit = System.getProperty("bit", "64");
        String browserSize = System.getProperty("browserSize", "3840×2160");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(bit);
        System.out.println(browserSize);
    }
}
