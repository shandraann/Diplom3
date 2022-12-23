package pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH,using = ("//button[text()='Войти в аккаунт']"))
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH,using = ("//button[text()='Оформить заказ']"))
    private SelenideElement orderButton;

    @FindBy(how = How.XPATH,using = ("//p[text()='Личный Кабинет']"))
    private SelenideElement profileLink;

    @FindBy(how = How.XPATH,using = ("//h1[text()='Соберите бургер']"))
    private SelenideElement createBurgerText;

    @FindBy(how = How.XPATH,using = ("//span[text()='Булки']//parent::div"))
    private SelenideElement bunsTab;

    @FindBy(how = How.XPATH,using = ("//span[text()='Соусы']//parent::div"))
    private SelenideElement saucesTab;

    @FindBy(how = How.XPATH,using = ("//span[text()='Начинки']//parent::div"))
    private SelenideElement fillingsTab;

    @FindBy(how = How.CLASS_NAME,using = "BurgerIngredients_ingredients__list__2A-mT")
    private SelenideElement ingredientsScrollDown;

    @Step("Нажать кнопку Войти")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return Selenide.page(LoginPage.class);
    }

    @Step("Нажать кнопку Заказ")
    public LoginPage clickOrderButton() {
        orderButton.click();
        return Selenide.page(LoginPage.class);
    }

    public boolean isOrderButtonDisplayed() {
        return orderButton.shouldBe(visible).isDisplayed();
    }
    @Step("Нажать Личный кабинет")
    public LoginPage clickProfileLink() {
        profileLink.click();
        return Selenide.page(LoginPage.class);
    }
    @Step("Нажать Личный кабинет после логина")
    public ProfilePage clickProfileLinkUserLogged() {
        profileLink.click();
        return Selenide.page(ProfilePage.class);
    }

    public boolean isCreateBurgerTextDisplayed() {
        return createBurgerText.shouldBe(visible).isDisplayed();
    }

    public MainPage displayAvailableBuns() {
        bunsTab.click();
        return this;
    }

    public MainPage displayAvailableSauces() {
        saucesTab.click();
        return this;
    }

    public MainPage displayAvailableFillings() {
        fillingsTab.click();
        return this;
    }

    public String getBunsTabClassValue() {
        return bunsTab.getAttribute("class");
    }

    public String getSaucesTabClassValue() {
        return saucesTab.getAttribute("class");
    }

    public String getFillingsTabClassValue() {
        return fillingsTab.getAttribute("class");
    }
}
