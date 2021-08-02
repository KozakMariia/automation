package webapp;

import com.codeborne.selenide.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

public class MealPlan {

    @Test
    public void verifyImageIngridientsDescriptionIsNotEmpty() {

        Configuration.browser = Browsers.CHROME;
        Selenide.open("https://app.dev.betterme.world/login");
        SelenideElement emailInput = $("input[data-input='email-login-email']");
        SelenideElement passwordInput = $("input[data-input='email-login-password']");
        SelenideElement loginButton = $("div[class*='login_button'] button");
        ElementsCollection mealFragments = $$("a[class*='meal-card_container']");
        SelenideElement dinnerFragment = mealFragments.get(2);
        SelenideElement image = $("div[class*='meal_imageTablet__4zk0z']");

        emailInput.setValue("kakiyiv233@spinwinds.com");
        passwordInput.setValue("111111");
        loginButton.click();
        dinnerFragment.click(); //переписати селектор щоб був на будь-який день

        ElementsCollection description = $$("div[class*='meal_howToMake'] li")
                .should(CollectionCondition.sizeNotEqual(0))
                .filter(Condition.visible);

        ElementsCollection ingredient = $$("div[class*='meal_ingredients'] li")
                .should(CollectionCondition.sizeNotEqual(0))
                .filter(Condition.visible);

        assertThat(description).isNotEmpty();
        assertThat(ingredient).isNotEmpty();
    }
}
