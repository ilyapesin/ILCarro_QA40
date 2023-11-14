package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        wd.findElement(By.xpath("//*[text()=' Log in ']")).click();
    }
    public void fillLoginForm(String email, String password){
        type(By.xpath("//*[@id='email']"), email);
        type(By.xpath("//*[@id='password']"), password);


    }
    public void submitLoginForm(){

        click(By.xpath("//button[@type='submit']"));
    }
    public void submitOkButton(){
        click(By.xpath("//button[@type='button']"));
    }
    public void logOut(){

        click(By.xpath("//*[text()=' Logout ']"));
    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));

    }


}



