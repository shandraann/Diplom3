import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

public class MainTest {
    @Before
    public void setUp() {
        System.setProperty("selenide.browser", "chrome");
        //System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver");
    }

    @After
    public void tearDown() {
        Selenide.closeWindow();
    }
}