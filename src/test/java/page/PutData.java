package page;

import elements.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PutData {
    private final String TITLE_TEXT = "Student Registration Form";
    private final LinkUrl url = new LinkUrl("https://demoqa.com/automation-practice-form", "Practice Form");
    private final Input firstName = new Input("Имя", $("#firstName"));
    private final Input lastname = new Input("Фамилия", $("#lastName"));
    private final Input email = new Input("Почту", $("#userEmail"));
    private final Buttons genderButton = new Buttons("Выбор пола", $(".custom-control-label"));
    private final Input mobileNumber = new Input("Телефон", $("#userNumber"));
    private final Calendar calendar = new Calendar("Practice Form",
            $(".react-datepicker__month-select"),
            $(".react-datepicker__year-select"),
            $(".react-datepicker__day.react-datepicker__day--019"),
            $("#dateOfBirthInput"));
    private final SelectorWAuto subjects = new SelectorWAuto("Предметы", $("#subjectsInput"));
    private final Buttons hobbies = new Buttons("Хобби", $("#hobbiesWrapper"));
    private final UploadFile picture = new UploadFile("Изображение", $("#uploadPicture"));
    private final Input currentAddress = new Input("Адрес", $("#currentAddress"));
    private final DropDown state = new DropDown("Штат", $("#state"), $("#stateCity-wrapper"));
    private final DropDown city = new DropDown("Город", $("#city"), $("#stateCity-wrapper"));
    private final Buttons submit = new Buttons("Submit", $("#submit"));


    public PutData openPage() {
        url.openUrl();
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        return this;
    }
    public PutData setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public PutData setLastName(String value) {
        lastname.setValue(value);
        return this;
    }

    public PutData setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public PutData setGender() {
        genderButton.click();
        return this;
    }

    public PutData setMobileNumber(String value) {
        mobileNumber.setValue(value);
        return this;
    }

    public PutData setCalendar(String month, String year, String day) {
        calendar.setCalendar(month, year, day);
        return this;
    }

    public PutData setSubjects(String value) {
        subjects.setSubjects(value);
        return this;
    }

    public PutData setHobbies() {
        hobbies.click();
        return this;
    }

    public PutData setPicture(String value) {
        picture.upLoadFile(value);
        return this;
    }

    public PutData setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public PutData setState(String value) {
        state.set(value);
        return this;
    }

    public PutData setCity(String value) {
        city.set(value);
        return this;
    }

    public PutData submit() {
        submit.click();
        return this;
    }

    public String InputGetCssValueFirstName() {
        String color = firstName.getCssValue("border-color");
        return color;

    }

    public String InputGetCssValueLastName() {
        String color = lastname.getCssValue("border-color");
        return color;

    }

    public String InputGetCssValueMobileNumber() {
        String color = mobileNumber.getCssValue("border-color");
        return color;

    }

    public String ButtonGetCssValueGender() {
        String color = genderButton.getCssValue("color");
        return color;

    }



}
