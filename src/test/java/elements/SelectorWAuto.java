package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

//предмет
public class SelectorWAuto {
    private final String name;
    private final SelenideElement selector;

    public SelectorWAuto(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;


    }

    public void setSubjects(String value) {
        System.out.println("Заполняем" + " " + name);
        selector.sendKeys(value);
        selector.sendKeys(Keys.TAB);
    }
}
