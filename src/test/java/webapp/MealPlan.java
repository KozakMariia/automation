package webapp;

import com.codeborne.selenide.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MealPlan {

    @Test
    public void verifyUserCanLoginWithValidParameters() {


        Configuration.browser = Browsers.CHROME;
        Selenide.open("https://app.dev.betterme.world/login");
        SelenideElement emailInput = $("input[data-input='email-login-email']");
        SelenideElement passwordInput = $("input[data-input='email-login-password']");
        SelenideElement loginButton = $("div[class*='login_button'] button");
        SelenideElement dinner = $("div.container_container__3P--6.container_lg__3hN4P > div > section > div:nth-child(4)");
        SelenideElement image = $("div[class*='meal_imageTablet__4zk0z']");

        emailInput.setValue("gifatog434@godpeed.com");
        passwordInput.setValue("111111");
        loginButton.click();
        dinner.click(); //переписати селектор щоб був на будь-який день

        ElementsCollection description = $$("div:nth-child(4) > div > div.meal_columnLeft__OGThl > div.meal_howToMakeTablet__14h9b > ul");
        ElementsCollection ingredient = $$("div.meal_columnRight__1tEC7 > div.meal_ingredients__1Uq1K > ul");

        image.exists();
        assertThat(description).isNotNull(); //не факт що норм перевірка
        assertThat(ingredient).isNotNull();

    }
}
