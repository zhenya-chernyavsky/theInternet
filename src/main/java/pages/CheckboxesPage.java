package pages;

import static com.codeborne.selenide.Selenide.*;
import static pages.Constants.BASE_URL;

import com.codeborne.selenide.SelenideElement;

public class CheckboxesPage {

    private SelenideElement checkbox1 = $x("//input[@type='checkbox'][1]");
    private SelenideElement checkbox2 = $x("//input[@type='checkbox'][2]");

    public void openPage() {
        open(BASE_URL);
    }

    public void checkCheckbox1() {
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
    }

    public void uncheckCheckbox1() {
        if (checkbox1.isSelected()) {
            checkbox1.click();
        }
    }

    public void checkCheckbox2() {
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
    }

    public void uncheckCheckbox2() {
        if (checkbox2.isSelected()) {
            checkbox2.click();
        }
    }


    public SelenideElement getCheckbox1() {
        return checkbox1;
    }

    public SelenideElement getCheckbox2() {
        return checkbox2;
    }
}