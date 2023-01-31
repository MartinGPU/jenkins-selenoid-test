package com.marat.test.properties;

import com.marat.config.CredentialsConfig;
import com.marat.config.UrlConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

@Tag("properties")
public class OwnerTests {

    public CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
    public UrlConfig urlconfig = ConfigFactory.create(UrlConfig.class);

    @Test
    void readCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();

        String message = format("login = %s, password = %s", login, password);
        System.out.println(message);
    }

    @Test
    void readUrl() {
        String url = urlconfig.url();
        String message2 = format("URL = %s", url);
        System.out.println(message2);
    }
}
