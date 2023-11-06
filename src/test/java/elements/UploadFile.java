package elements;

import com.codeborne.selenide.SelenideElement;

//файл
public class UploadFile {
    private final String name;
    private final SelenideElement selector;

    public UploadFile(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }

    public void upLoadFile(String file) {
        System.out.println("Загружаем" + " " + name);
        selector.uploadFromClasspath(file);
    }
}
