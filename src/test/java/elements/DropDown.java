package elements;
//штат и город

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

public class DropDown {
    private final String name;
    private final SelenideElement clickSelector;
    private final SelenideElement choiceSelector;

    public DropDown(String name, SelenideElement clickSelector, SelenideElement citySelector) {
        this.name = name;
        this.clickSelector = clickSelector;
        this.choiceSelector = citySelector;
    }

    public void set(String value) {
        System.out.println("Выбираем" + " " + name);
        clickSelector.click();
        choiceSelector.$(byText(value)).click();
    }
}
