package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckboxesPage;

import static pages.Constants.BASE_URL;

public class CheckboxesTest {

    private CheckboxesPage checkboxesPage = new CheckboxesPage();

    @BeforeClass
    public void setUp() {
        // Настройки Selenide
        Configuration.baseUrl = BASE_URL;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "max";
    }

    @Test(description = "Тест для проверки функциональности чекбоксов")
    public void testCheckboxes() {
        checkboxesPage.openPage();

        SoftAssert softAssert = new SoftAssert();

        // Проверка состояния чекбоксов
        checkboxesPage.checkCheckbox1();
        softAssert.assertTrue(checkboxesPage.getCheckbox1().isSelected(), "Checkbox 1 должен быть выбран");

        checkboxesPage.checkCheckbox2();
        softAssert.assertTrue(checkboxesPage.getCheckbox2().isSelected(), "Checkbox 2 должен быть выбран");

        checkboxesPage.uncheckCheckbox1();
        softAssert.assertFalse(checkboxesPage.getCheckbox1().isSelected(), "Checkbox 1 не должен быть выбран");

        checkboxesPage.uncheckCheckbox2();
        softAssert.assertFalse(checkboxesPage.getCheckbox2().isSelected(), "Checkbox 2 не должен быть выбран");

        softAssert.assertAll();
    }
}