package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static pages.Constants.BASE_URL_ContextMenu;

public class ContextMenuPage {
private final SelenideElement hotSpot = $x("//div[@id='hot-spot']");

public void open(){
    Selenide.open(BASE_URL_ContextMenu);
}
public void rightClick(){
    actions().contextClick(hotSpot).perform();
}
public String getAlert(){
    return switchTo().alert().getText();
}
public void acceptAlert(){
    switchTo().alert().accept();
}

}