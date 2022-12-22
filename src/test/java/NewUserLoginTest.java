import client.Credentials;
import client.UserModel;
import client.UserClient;
import io.restassured.response.ValidatableResponse;
import pageobjects.MainPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class NewUserLoginTest extends MainTest{

    private UserClient userClient;
    private Credentials creds;
    private UserModel userModel;
    private boolean afterToBeLaunched;

    @Before
    public void setUp() {
        afterToBeLaunched = true;
        userClient = new UserClient();
        userModel = UserModel.getRandom();
        creds = Credentials.from(userModel);
    }

    @After
    public void teardown() {
        if (!afterToBeLaunched) {
            return;
        }

        String bearerToken = userClient.login(creds)
                .then().log().all()
                .extract()
                .path("accessToken");
        userClient.delete(bearerToken);
    }

    @Test
    @DisplayName("Проверка регистрации пользователя с некорректным паролем")
    public void registerNewUserWithIncorrectPassFails() {
        userModel.setPassword("five");
        final boolean incorrectPasswordWarningDisplayed = Selenide.open(MainPage.URL, MainPage.class)
                .clickLoginButton()
                .clickRegisterLink()
                .registerNewUser(userModel)
                .isIncorrectPassDisplayed();
        if (!incorrectPasswordWarningDisplayed) {
            String bearerToken = userClient.login(Credentials.from(userModel)).then().log().all().extract().path("accessToken");
            userClient.delete(bearerToken);
        }
            assertTrue(incorrectPasswordWarningDisplayed);
            afterToBeLaunched = false;
            //Если пользователь создастся в этом методе в результате пойманного бага, то он удалится в After
    }
}
