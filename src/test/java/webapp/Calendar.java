package webapp;

import com.codeborne.selenide.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Calendar {

    @Test
    public void verifyTodayDayIsNotDisplayedOnOtherWeek() throws InterruptedException {
        Configuration.browser = Browsers.CHROME;
        Selenide.open("https://app.dev.betterme.world/login");

        SelenideElement emailInput = $("input[data-input='email-login-email']");
        SelenideElement passwordInput = $("input[data-input='email-login-password']");
        SelenideElement loginButton = $("div[class*='login_button'] button");
        SelenideElement calendarNextWeekButton = $("button[class*='calendar_nextWeekBtn']");

        emailInput.setValue("kakiyiv233@spinwinds.com");
        passwordInput.setValue("111111");
        loginButton.click();
        calendarNextWeekButton.click();

        $("button[class^='calendar_dayCurrentAndSelected__1FilX']").shouldNot(Condition.exist);
    }
}
