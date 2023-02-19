package com.marat.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TicketSearchPage {

    public static SelenideElement
            busTab = $("[data-content='bus']"),
            routBeginsField = $$("[data-ti='suggest-selector']").get(0),
            routEndsField = $$("[data-ti='suggest-selector']").get(1),
            dateDepartureField = $("[data-ti='date-input']"),
            selectDay = $$("[data-ti='date-link']").get(1),
            passengersField = $("[data-ti='passengers-input']"),
            addPassenger = $$("[data-ti='passenger-counter-button']").get(1),
            addChildPassenger = $$("[data-ti='passenger-counter-button']").get(3),
            runSearch = $("[data-ti='submit-button']"),
            departureResultContent = $$("[data-ti='stopover-place']").get(0),
            arrivalResultsContent = $$("[data-ti='stopover-place']").get(1);
}
