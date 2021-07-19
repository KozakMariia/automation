package webapp;

import com.codeborne.selenide.*;
import com.codeborne.selenide.impl.ElementsContainerCollection;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MealPlan {

    @Test
    public void verifyUserCanLoginWithValidParameters() {
        // configure browser
        Configuration.browser = Browsers.CHROME;
        Selenide.open("https://app.dev.betterme.world/login");
        SelenideElement emailInput =  $("input[data-input='email-login-email']");
        SelenideElement passwordInput =  $("input[data-input='email-login-password']");
        SelenideElement loginButton =  $("div[class*='login_button'] button");
        SelenideElement dinner = $("[href='/meal?selectedDate=2021-07-19&currentDish=431847']");
        SelenideElement image = $("div[class*='meal_imageTablet__4zk0z']");

        emailInput.setValue("gifatog434@godpeed.com");
        passwordInput.setValue("111111");
        loginButton.click();
        dinner.click(); //переписати селектор щоб був на будь-який день

        ElementsCollection description = $$("div[class = 'meal_howToMakeTablet__14h9b']");
        ElementsCollection ingredients = $$("ul[class='ingredients_list__2rQQc']");
        image.isDisplayed();
        assertThat(description).isNotNull(); //не факт що норм перевірка
        assertThat(ingredients).isNotNull();




    }
}
