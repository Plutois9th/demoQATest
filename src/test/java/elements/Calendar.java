package elements;

import com.codeborne.selenide.SelenideElement;

//календарь
public class Calendar {
private final String name;
private final SelenideElement selectorCalendar;
private final SelenideElement selectorYear;
private final SelenideElement selectorMonth;
private final SelenideElement selectorDay;
 public Calendar(String calendarName,SelenideElement selectorCalendar,
                 SelenideElement selectorYear, SelenideElement selectorMonth, SelenideElement selectorDay) {
     this.name = calendarName;
     this.selectorCalendar = selectorCalendar;
     this.selectorYear = selectorYear;
     this.selectorMonth = selectorMonth;
     this.selectorDay = selectorDay;
 }
 public void setCalendar ( String year, String month, String day) {
     selectorCalendar.click();
     selectorYear.selectOption(year);
     selectorMonth.selectOption(month);
     selectorDay.click();

 }

}
