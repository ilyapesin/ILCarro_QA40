package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar extends HelperBase {
    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        //pause(5000);
        click(By.xpath("//a[.=' Let the car work ']"));
    }

    public void fillCarForm(Car car) {
      // if(isCarFormPresent()==false){return;}
        typeLocation(car.getLocation());
        type(By.id("make"), car.getMake());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"), car.getFuel());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getCarClass());
        type(By.id("serialNumber"), car.getCarRegNumber());
       // clickSerialNumber(car.getCarRegNumber());
        type(By.id("price"), car.getPrice());

    }
    public void typeLocation(String address) {
        type(By.id("pickUpPlace"), address);
        click(By.cssSelector("div.pac-item"));
    }
    public void select(By locator, String value) {
        new Select(wd.findElement(locator)).selectByValue(value);

    }

    public void submitShowCar() {
        click(By.xpath("//*[text()='Show car']"));
    }
    public boolean isCarFormPresent() {
    return new WebDriverWait(wd, 10)
            .until(ExpectedConditions
                    .textToBePresentInElement(
                            wd.findElement(By.cssSelector("h2")),
                            "details"));

}
    public void clickSerialNumber(String text){

//        Rectangle rect = wd.findElement(By.id("serialNumber")).getRect();
        WebElement rect = wd.findElement(By.id("serialNumber"));
//        int x = rect.getX() + rect.getWidth() * 7 / 8;
//        int y = rect.getY() + rect.getHeight() / 2;
        Actions actions = new Actions(wd);
//        actions.moveByOffset(x, y).click().perform();
        actions.moveToElement(rect).click().perform();
        rect.clear();
        rect.sendKeys(text);
    }

}
