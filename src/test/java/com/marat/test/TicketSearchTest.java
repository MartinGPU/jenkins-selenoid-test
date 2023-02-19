package com.marat.test;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.marat.pages.TicketSearchPage.*;
import static com.marat.test.TestData.*;
import static io.qameta.allure.Allure.step;

@Feature("Ticket search")
public class TicketSearchTest extends TestBase {

    @Test
    @Tag("smoke")
    @DisplayName("Selecting route details")
    @AllureId("15041")
    void ticketSearch() {
        step("Open home page", () -> {
            open(URL2);
            sleep(3000);
        });

        step("Select bus tab", () -> {
            $(busTab).click();
            sleep(1000);
        });

        step("Set rout begins", () -> {
            $(routBeginsField).click();
            $(routBeginsField).setValue(fromTown);
            sleep(1000);
        });

        step("Set rout ends", () -> {
            $(routEndsField).click();
            $(routEndsField).setValue(toTown);
            sleep(1000);
        });

        step("Set departure date", () -> {
            $(selectDay).click();
            sleep(1000);
        });

        step("Set passengers quantity", () -> {
            $(passengersField).click();
            sleep(1000);
            $(addPassenger).click();
            sleep(1000);
            $(addChildPassenger).click();

        });

        step("Run searching process", () -> {
            $(runSearch).click();
            sleep(6000);
        });

        step("Checking search results", () -> {
            $(departureResultContent).shouldHave(text(departureResults));
            $(arrivalResultsContent).shouldHave(text(arrivalResults));
        });
    }
}