package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static com.codeborne.selenide.Selenide.*;
import testdata.TestData;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();
    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage().closeBanners()
                        .setFirstName(testData.firstName)
                        .setLastName(testData.lastName)
                        .setEmail(testData.userEmail)
                        .setGender(testData.gender)
                        .setUserNumber(testData.userNumber)
                        .setDateOfBirth(testData.dateDay,testData.dateMonth,testData.dateYear)
                        .setSubjects(testData.subjects)
                        .setHobbies(testData.hobbies)
                        .uploadPicture(testData.picture)
                        .setCurrentAddress(testData.currentAddress)
                        .setState(testData.state)
                        .setCity(testData.city)
                        .submit();

        registrationPage.checkResult("Student Name", testData.firstName+" "+testData.lastName)
                        .checkResult("Student Email", testData.userEmail)
                        .checkResult("Gender", testData.gender)
                        .checkResult("Mobile",testData.userNumber)
                        .checkResult("Date of Birth",testData.dateDay+" "+testData.dateMonth+","+testData.dateYear)
                        .checkResult("Subjects",testData.subjects)
                        .checkResult("Hobbies",testData.hobbies)
                        .checkResult("Picture",testData.picture)
                        .checkResult("Address",testData.currentAddress)
                        .checkResult("State and City",testData.state+" "+testData.city);

       // sleep(5000);
    }

    @Test
    void registrationMinTest(){
        registrationPage.openPage().closeBanners()
                        .setFirstName(testData.firstName)
                        .setLastName(testData.lastName)
                        .setGender(testData.gender)
                        .setUserNumber(testData.userNumber)
                        .submit();

        registrationPage.checkResult("Student Name", testData.firstName+" "+testData.lastName)
                        .checkResult("Gender", testData.gender)
                        .checkResult("Mobile",testData.userNumber);
        //sleep(5000);
    }

    @Test
    void registrationNegativeTest(){
        registrationPage.openPage().closeBanners()
                        //.setFirstName("Alex")  //не заполняем имя
                        .setLastName(testData.lastName)
                        .setEmail(testData.userEmail)
                        .setGender(testData.gender)
                        .setUserNumber(testData.userNumber)
                        .setDateOfBirth(testData.dateDay,testData.dateMonth,testData.dateYear)
                        .setSubjects(testData.subjects)
                        .setHobbies(testData.hobbies)
                        .uploadPicture(testData.picture)
                        .setCurrentAddress(testData.currentAddress)
                        .setState(testData.state)
                        .setCity(testData.city)
                        .submit();

        registrationPage.checkModalDialog();

         //sleep(5000);
    }
}
