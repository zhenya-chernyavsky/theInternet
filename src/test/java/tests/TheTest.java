package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CheckboxesPage;
import pages.ContextMenuPage;
import pages.DragAndDropPage;
import pages.DropDownPage;

import static org.testng.Assert.assertEquals;
import static pages.Constants.BASE_URL;

public class TheTest {

    private CheckboxesPage checkboxesPage = new CheckboxesPage();
    private ContextMenuPage contextMenuPage = new ContextMenuPage();
    private DragAndDropPage dragAndDropPage = new DragAndDropPage();
    private DropDownPage dropdownPage = new DropDownPage();

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

    @Test(description = "Тест для проверки контекстного меню")
    public void testContextMenu() {
        contextMenuPage.open();

        contextMenuPage.rightClick();

        String alertText = contextMenuPage.getAlert();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(alertText, "You selected a context menu", "Текст alert не совпадает");

        contextMenuPage.acceptAlert();

        softAssert.assertAll();
    }

    @Test(description = "Тест для проверки функциональности DragAndDrop")
    public void testDragAndDrop() {
        SoftAssert softAssert = new SoftAssert();
        dragAndDropPage.open();
        dragAndDropPage.DragAndDrop();
        dragAndDropPage.DragAndDropReverce();
        softAssert.assertEquals("A", dragAndDropPage.getAText());
        softAssert.assertEquals("B", dragAndDropPage.getBText());
        softAssert.assertAll();
    }

    @Test(description = "Тест для проверки функциональности DropDown")
    public void testDropDown() {
        SoftAssert softAssert = new SoftAssert();
        dropdownPage.open();
        dropdownPage.selectOption1("Option 1");
        softAssert.assertEquals("Option 1", dropdownPage.getOption());
        dropdownPage.selectOption2("Option 2");
        softAssert.assertEquals("Option 2", dropdownPage.getOption());
        softAssert.assertAll();

    }
}



