package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    Logger logger= LoggerFactory.getLogger(TestBase.class);

    static ApplicationManager app = new
            ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    @BeforeSuite
    public void setApp(){

        app.init();
    }
    @AfterSuite
    public  void  stop(){
        app.tearDown();
    }
    @BeforeMethod
    public void setLogger(Method method){
        logger.info("Test "+method.getName()+" started");
    }
    @AfterMethod
    public void end(){
        logger.info("================================");
    }

}