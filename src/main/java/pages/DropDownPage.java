package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static pages.Constants.BASE_URL_dropdown;

public class DropDownPage {
    private final SelenideElement dropdown = $x("//select[@id='dropdown']");
    private final SelenideElement option1 = $x("//option[text()='Option 1']");
    private final SelenideElement option2 = $x("//option[text()='Option 2']");

    public void open() {
        Selenide.open(BASE_URL_dropdown);
    }

    public void selectOption1(String optionText) {
        dropdown.selectOption(optionText);
    }

    public void selectOption2(String optionText) {
        dropdown.selectOption(optionText);
    }

    public String getOption() {
        return dropdown.getText();
    }

}
