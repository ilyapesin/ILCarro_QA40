import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
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
        app.getUser().submitOkButton();

    }

}
