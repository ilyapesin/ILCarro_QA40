package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }
    public void fillSearchForm(String city, String dataFrom, String dataTo){
        fillCity(city);
        //selectPeriodDays(dataFrom,dataTo);
       // selectPeriodDaysDatePicker(dataFrom,dataTo);
       // selectPeriodMonthsDatePicker(dataFrom,dataTo);
        selectPeriodYearsDatePicker(dataFrom,dataTo);
    }
    public void fillCity(String address){
        type(By.id("city"), address);
        click(By.cssSelector("div.pac-item"));

    }
    public void selectPeriodDays(String dateFrom, String dateTo){
        //click(By.id("dates"));
        type(By.id("dates"), dateFrom+" - "+dateTo);
        pause(3000);
        click(By.id("city"));
    }
    public void selectPeriodDaysDatePicker(String dateFrom, String dateTo){
        String[]startDate=dateFrom.split("/");
        String[]endDate=dateTo.split("/");
        click(By.id("dates"));
        pause(1000);
       // click(By.xpath("//div[.=' " +startDate[1]+ " ']"));
       // pause(1000);
      //  click(By.xpath("//div[.=' " +endDate[1]+ " ']"));
        String locatorStartDate=String.format("//div[.=' %s ']",startDate[1]);
        String locatorEndDate=String.format("//div[.=' %s ']",endDate[1]);
        click(By.xpath(locatorStartDate));
        pause(1000);
        click(By.xpath(locatorEndDate));
        pause(3000);
    }
    public void selectPeriodMonthsDatePicker(String dateFrom, String dateTo){
        int fromNowToStart=0, fromStartToEnd=0;
        String[]startDate=dateFrom.split("/");
        String[]endDate=dateTo.split("/");
        click(By.id("dates"));
        pause(1000);
        fromStartToEnd=Integer.parseInt(endDate[0])-Integer.parseInt(startDate[0]);
        if(LocalDate.now().getMonthValue()!=Integer.parseInt(startDate[0])){
            fromNowToStart=Integer.parseInt(startDate[0])-LocalDate.now().getMonthValue();

        }
        for(int i = 0; i < fromNowToStart; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        String locatorStartDate=String.format("//div[.=' %s ']",startDate[1]);
        String locatorEndDate=String.format("//div[.=' %s ']",endDate[1]);
        click(By.xpath(locatorStartDate));
        pause(3000);
        for(int i = 0; i < fromStartToEnd; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorEndDate));
        pause(3000);
    }
    public void selectPeriodYearsDatePicker(String dateFrom, String dateTo){
        LocalDate startDate=LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate endDate=LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate nowDate=LocalDate.now();
        String locatorStartDate=String.format("//div[.=' %s ']",startDate.getDayOfMonth());
        String locatorEndDate=String.format("//div[.=' %s ']",endDate.getDayOfMonth());
        click(By.id("dates"));
        pause(1000);

        int startToEndMonth=startDate.getYear()-nowDate.getYear()==0 ?
                startDate.getMonthValue()-nowDate.getMonthValue():
                12-nowDate.getMonthValue()+startDate.getMonthValue();
        for(int i = 0; i < startToEndMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }
        click(By.xpath(locatorStartDate));

        startToEndMonth=endDate.getYear()-startDate.getYear()==0 ?
                endDate.getMonthValue()-startDate.getMonthValue():
                12-startDate.getMonthValue()+endDate.getMonthValue();
        for(int i = 0; i < startToEndMonth; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
            pause(1000);
        }

        click(By.xpath(locatorEndDate));
        pause(1000);


    }



    public void submitSearchForm(){

        //click(By.xpath("//button[@type='submit']"));
        wd.findElement(By.xpath("//button[@type='submit']")).submit();
    }
}
