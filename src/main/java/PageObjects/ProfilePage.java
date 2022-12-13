package PageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {
    final public static String URL = MainPage.URL + "profile";

    // локатор текстового элемента <В этом разделе вы можете изменить свои персональные данные>
    @FindBy(how = How.XPATH,using = ("//p[text()='В этом разделе вы можете изменить свои персональные данные']"))
    private SelenideElement profileText;

    // локатор элемента <Конструктор>
    @FindBy(how = How.XPATH,using = ("//p[text()='Конструктор']"))
    private SelenideElement createBurger;

    // локатор элемента логотип <Stellar Burgers>
    @FindBy(how = How.XPATH,using =("//div[@class='AppHeader_header__logo__2D0X2']/a"))
    private SelenideElement burgerLogo;

    // локатор кнопки <Выход>
    @FindBy(how = How.XPATH,using = ("//button[text()='Выход']"))
    private SelenideElement logoutButton;

    public boolean isProfileTextDisplayed() {
        return profileText.shouldBe(visible).isDisplayed();
    }

    @Step("Нажать элемент Создать бургер")
    public MainPage clickCreateBurger() {
        createBurger.click();
        return Selenide.page(MainPage.class);
    }

    @Step("Нажать кнопку Выйти")
    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return Selenide.page(LoginPage.class);
    }

    public MainPage clickBurgerLogo(){
        burgerLogo.click();
        return Selenide.page(MainPage.class);
    }
}
