package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private static ElementsCollection cards = $$(".list__item div");
    private static final String balanceStart = "баланс: ";
    private static final String balanceFinish = " р.";
    private SelenideElement upButton = $("[data-test-id=action-deposit]");
    private SelenideElement pageRefresh = $("[data-test-id='action-reload']");

    public DashboardPage() {
        heading
                .shouldBe(visible)
                .shouldHave(Condition.text("  Личный кабинет"));
    }

}