package data;

import helpers.FakeData;
import lombok.Data;

@Data
public class ValidData {
    FakeData fakeData = new FakeData();
    private final String firstName = fakeData.getFirstName();
    private final String lastName = fakeData.getLastName();
    private final String mobileNumber = fakeData.getMobileNum();
    private final String email = fakeData.getEmail();
    private final String address = fakeData.getAddress();
    private final String day = "19";
    private final String month = "October";
    private final String year = "1994";
    private final String gender = "Female";
    private final String subjects = "Physics";
    private final String hobbies = "Sports";
    private final String file = "textFile.txt";
    private final String state = "Uttar Pradesh";
    private final String city = "Agra";
}
