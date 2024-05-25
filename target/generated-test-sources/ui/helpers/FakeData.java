package ui.helpers;

import com.github.javafaker.Faker;
import java.util.Locale;

public class FakeData {
    Faker faker = new Faker(new Locale("ru"));

    public String getFirstName (){

        return faker.name().firstName();
    }

    public String getLastName () {
        return faker.name().lastName();
    }

    public String getMobileNum (){
        return faker.bothify("##########");
    }

    public String getEmail (){
        return faker.bothify("?????###@mail.ru");
    }

    public String getAddress (){
        return faker.address().fullAddress();
    }
}
