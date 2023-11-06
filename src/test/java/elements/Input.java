package elements;

import com.codeborne.selenide.SelenideElement;

// имя, фамилия, эл адрес, адрес, телефон
public class Input {
private final String name;
private final SelenideElement selector;

    public Input(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }
    public void setValue(String value) {
        System.out.println("Вводим" + " " + name);
        selector.setValue(value);
    }

    public String getCssValue(String Css) {
        System.out.println("Получаем цвет поля" + " " + name);
        var color = selector.getCssValue(Css);
        return color;
    }

    }

