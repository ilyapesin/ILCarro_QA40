package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {

        super(wd);
    }
    public void openRegistrationForm(){

        wd.findElement(By.xpath("//*[text()=' Sign up ']")).click();
    }
    public void fillRegistrationForm(User user){
        type(By.xpath("//*[@id='name']"), user.getName());
        type(By.xpath("//*[@id='lastName']"), user.getLastName());
        type(By.xpath("//*[@id='email']"), user.getEmail());
        type(By.xpath("//*[@id='password']"), user.getPassword());
        clickCheckbox();

    }
    public void clickCheckbox(){
        System.out.println("clicked Checkbox");
        //Variant 1
        //click(By.cssSelector(".checkbox-label.terms-label"));
        //Variant 2
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
        //Variant 3
//        Rectangle rect = wd.findElement(By.cssSelector("div.checkbox-container")).getRect();
//        int x=rect.getX()+5;
//        int y=rect.getY()+ rect.getHeight()/4;
//        Actions actions = new Actions(wd);
//        actions.moveByOffset(x, y).click().perform();

    }

    public void openLoginForm(){

        wd.findElement(By.xpath("//*[text()=' Log in ']")).click();
    }
    public void fillLoginForm(String email, String password){
        type(By.xpath("//*[@id='email']"), email);
        type(By.xpath("//*[@id='password']"), password);


    }
    public void fillLoginForm(User user){
        type(By.xpath("//*[@id='email']"), user.getEmail());
        type(By.xpath("//*[@id='password']"), user.getPassword());


    }
    public void submitRegistrationForm() {

        //click(By.xpath("//*[@type='submit']"));
        wd.findElement(By.xpath("//*[@type='submit']")).submit();
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
    public void logIn(User user){
        openLoginForm();
        fillLoginForm(user);
        submitLoginForm();
        submitOkButton();

    }


}



