import PageObjects.MainPage;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class IngredientsTest extends MainTest{

    private final String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

    @Test
    @DisplayName("Check the buns tab gets activated successfully")
    public void checkBunsTabGetsActivatedSuccessfully() {
        final String actual = Selenide.open(MainPage.URL, MainPage.class)
                .displayAvailableFillings()
                .displayAvailableSauces()
                .displayAvailableBuns()
                .getBunsTabClassValue();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check the sauces tab gets activated successfully")
    public void checkSaucesTabGetsActivatedSuccessfully() {
        final String actual = Selenide.open(MainPage.URL, MainPage.class)
                .displayAvailableFillings()
                .displayAvailableBuns()
                .displayAvailableSauces()
                .getSaucesTabClassValue();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Check the fillings tab gets activated successfully")
    public void checkFillingsTabGetsActivatedSuccessfully() {
        final String actual = Selenide.open(MainPage.URL, MainPage.class)
                .displayAvailableSauces()
                .displayAvailableBuns()
                .displayAvailableFillings()
                .getFillingsTabClassValue();
        assertEquals(expected, actual);
    }
}
