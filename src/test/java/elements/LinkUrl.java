package elements;

import com.codeborne.selenide.Selenide;


public class LinkUrl {
    private final String URL;
    private final String name;

    public LinkUrl(String URL, String name) {
        this.URL = URL;
        this.name = name;
    }

    public void openUrl() {
        System.out.println("Открываем" + " " + name);
        Selenide.open(URL);
    }

}
