package tests;

import manager.TestNGListener;
import models.Car;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.TestBase;

@Listeners(TestNGListener.class)
public class AddNewCar extends TestBase {
@BeforeMethod
    public void preconditions(){

    if (app.getUser().isLogged()==false){
        app.getUser().logIn(
                new User()
                        .withEmail("vasya_pupkin@gmail.com")
                        .withPassword("Vp12345$"));
    }

}
@Test
    public void testAddNewCarPositive()  {
    int i=(int)(System.currentTimeMillis()/1000)%3600;
    Car car = Car.builder()
            .location("Tel Aviv")
            .make("KIA")
            .model("Sportage")
            .year("2023")
            .fuel("Petrol")
            .seats("5")
            .carClass("B")
            .carRegNumber("100-200-" + i)
            .price("150")
            .about("")
            .build();
    app.getCar().pause(3000);
    app.getCar().openCarForm();
    app.getCar().fillCarForm(car);
    app.getUser().submitLoginForm();

}
@AfterMethod
    public void postconditions(){

    //app.getCar().submitShowCar();
    }

}
