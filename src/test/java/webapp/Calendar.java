package webapp;

import com.codeborne.selenide.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Calendar {

    @Test
    public void verifyTodayDayIsNotDisplayedOnOtherWeek() {

        Configuration.browser = Browsers.CHROME;
        Selenide.open("https://app.dev.betterme.world/login");
        SelenideElement emailInput = $("input[data-input='email-login-email']");
        SelenideElement passwordInput = $("input[data-input='email-login-password']");
        SelenideElement loginButton = $("div[class*='login_button'] button");
        SelenideElement rightButton = $("button[class='calendar_nextWeekBtn__3-8IM']");
        SelenideElement currentDay = $("button[class='calendar_dayCurrentAndSelected__1FilX']");

        emailInput.setValue("gifatog434@godpeed.com");
        passwordInput.setValue("111111");
        loginButton.click();
        rightButton.click();


        ElementsCollection weekCalendar = $$("div[class='calendar_weekDays__24S47']");

        assertThat(currentDay).isNotIn(weekCalendar);
    }
}
