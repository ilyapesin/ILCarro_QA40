import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitRegistrationForm();


    }
    @AfterMethod
    public void postconditions() {
        app.getUser().submitOkButton();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()=' Logout ']")));
    }

}

