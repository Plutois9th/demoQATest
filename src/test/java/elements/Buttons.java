package elements;

import com.codeborne.selenide.SelenideElement;

//сабмит
public class Buttons {
    private final String name;
    private final SelenideElement selector;

    public Buttons(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    public void click() {
        System.out.println("Нажимаем" + " " + name);
        selector.click();
    }

    public String getCssValue(String Css) {
        System.out.println("Получаем цвет кнопки" + " " + name);
        var color = selector.getCssValue(Css);
        return color;
    }
}
