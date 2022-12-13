import Client.Credentials;
import Client.UserClient;
import Client.UserModel;
import PageObjects.ForgotPasswordPage;
import PageObjects.MainPage;
import PageObjects.RegisterPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static Client.Credentials.*;
import static junit.framework.TestCase.assertTrue;

public class UserSignInTest extends MainTest {
    private UserClient userClient;
    private UserModel user;
    private String bearerToken;

    @Before
    public void setUp() {
        userClient = new UserClient();
        user = UserModel.getRandom();
        Credentials creds = from(user);
        userClient.registerNewUser(user);
        bearerToken = userClient.login(creds)
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }

    @After
    public void tearDown() {
        userClient.delete(user.getEmail(), bearerToken);
    }

    @Test
    @DisplayName("Check user is able to login successfully via the login button from the main page")
    public void successfullyLoginUserUsingLoginButtonOnTheMainPage() {
        final boolean orderButtonDisplayed = Selenide.open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .userLogin(user)
                .isOrderButtonDisplayed();

        assertTrue(orderButtonDisplayed);
    }

    @Test
    @DisplayName("Check user is able to login successfully via the profile link from the main page")
    public void successfullyLoginUserUsingProfileLinkOnTheMainPage() {
        final boolean orderButtonDisplayed = Selenide.open(MainPage.URL, MainPage.class)
                .clickProfileLink()
                .userLogin(user)
                .isOrderButtonDisplayed();

        assertTrue(orderButtonDisplayed);
    }


    @Test
    @DisplayName("Check user is able to login successfully via the login link from the register page")
    public void successfullyLoginUserUsingLoginLinkOnTheRegisterPage() {
        final boolean orderButtonDisplayed = Selenide.open(RegisterPage.URL, RegisterPage.class)
                .clickLoginLink()
                .userLogin(user)
                .isOrderButtonDisplayed();

        assertTrue(orderButtonDisplayed);
    }

    @Test
    @DisplayName("Check user is able to login successfully via the login link from the restore password page")
    public void successfullyLoginUserUsingLoginLinkOnTheRestorePasswordPage() {
        final boolean orderButtonDisplayed = Selenide.open(ForgotPasswordPage.URL, ForgotPasswordPage.class)
                .clickLoginLink()
                .userLogin(user)
                .isOrderButtonDisplayed();

        assertTrue(orderButtonDisplayed);
    }
}