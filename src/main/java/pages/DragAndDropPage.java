package pages;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static pages.Constants.BASE_URL_DragAndDrop;

public class DragAndDropPage {
    private final SelenideElement column_a = $x("//div[@id='column-a']");
    private final SelenideElement column_b = $x("//div[@id='column-b']");

    public void open(){
        Selenide.open(BASE_URL_DragAndDrop);
    }
    public void DragAndDrop(){
        actions().dragAndDrop(column_a,column_b).perform();
    }
    public void DragAndDropReverce(){
        actions().dragAndDrop(column_b,column_a).perform();
    }
    public String getAText() {
        return column_a.getText();
    }

    public String getBText() {
        return column_b.getText();
    }

}
