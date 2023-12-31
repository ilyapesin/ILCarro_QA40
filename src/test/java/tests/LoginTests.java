package tests;

import manager.ProviderData;
import manager.TestNGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNGListener.class)
public class LoginTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void preconditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }

    @Test
    public void testLoginPositive() {
        String email = "vasya_pupkin@gmail.com", password = "Vp12345$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email,password);
        app.getUser().submitLoginForm();
    }
    @Test
    public void testLoginPositiveProps() {
      //  String email = "vasya_pupkin@gmail.com", password = "Vp12345$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(app.getEmail(), app.getPassword());
        app.getUser().submitLoginForm();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()=' Logout ']")));
    }
//    @Test
//    public void testLoginPositiveUser() {
//        User user=new User()
//                .withEmail("vasya_pupkin@gmail.com")
//                .withPassword("Vp12345$")
//                ;
//        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm(user.getEmail(),user.getPassword());
//        app.getUser().submitLoginForm();
//    }
//    @Test
//    public void testLoginPositiveUserData() {
//        User user=new User()
//                .withEmail("vasya_pupkin@gmail.com")
//                .withPassword("Vp12345$")
//                ;
//        app.getUser().openLoginForm();
//        app.getUser().fillLoginForm(user);
//        app.getUser().submitLoginForm();
//        app.getUser().pause(3000);
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()=' Logout ']")));
//
//    }
    @Test(dataProvider ="userDTO",dataProviderClass = ProviderData.class)
    public void testLoginPositiveUserDTO(User user){
//        User user=new User()
//                .withEmail("vasya_pupkin@gmail.com")
//                .withPassword("Vp12345$")
//                ;
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginForm();
        app.getUser().pause(3000);
       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()=' Logout ']")));

    }
    @AfterMethod
    public void postconditions() {
        app.getUser().submitOkButton();
//         app.getUser().pause(3000);
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()=' Logout ']")));
    }

}
