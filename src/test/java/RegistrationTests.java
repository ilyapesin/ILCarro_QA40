import manager.TestNGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNGListener.class)

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preconditions() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }
    @Test
    public void testRegistrationPositive() {
        int i=(int)(System.currentTimeMillis()/1000)%3600;
        User user=new User()
                .withName("Vasya"+i)
                .withLastName("Pupkin"+i)
                .withEmail("vasya_pupkin"+i+"@gmail.com")
                .withPassword("Vp12345$")
                ;
        app.getUser().openRegistrationForm();
        //logger.info("openRegistrationForm invoked");
        app.getUser().fillRegistrationForm(user);
        //logger.info("fillRegistrationForm invoked");
        app.getUser().submitRegistrationForm();
       // logger.info("submitRegistrationForm invoked");
       // logger.info("registrationPositive starts successfully with credentials: login "+user.getEmail()+" password "+user.getPassword());
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()=' Logout ']")));


    }
    @Test
    public void testRegistrationNegativeWrongPassword() {
        int i=(int)(System.currentTimeMillis()/1000)%3600;
        User user=new User()
               .withName("Vasya"+i)
               .withLastName("Pupkin"+i)
               .withEmail("vasya_pupkin"+i+"@gmail.com")
               .withPassword("Vp12345")
                ;
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitRegistrationForm();
    }
   @AfterMethod
    public void postconditions() {
       app.getUser().submitOkButton();
   }

}

