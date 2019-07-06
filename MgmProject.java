package MavenTasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MgmProject {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.mgmresorts.com");
        WebElement groupsWeddings = driver.findElement(By.linkText("Groups & Weddings"));
        groupsWeddings.click();

        WebElement Weddings = driver.findElement(By.linkText("Weddings"));
        Weddings.isDisplayed();
        Weddings.click();
       WebElement ConventionMeeting =driver.findElement(By.linkText("Convention & Meeting Venues"));
       if(ConventionMeeting.isDisplayed()){
           System.out.println("Convention & Meeting Venues is displayed ");
       }else{
           System.out.println("Convention & Meeting is not displayed");
       }
        WebElement SocialGroups = driver.findElement(By.linkText("Social Groups"));
        if(SocialGroups.isDisplayed()){
            System.out.println("Social Groups is displayed");
        }else{
            System.out.println("Social Groups is not displayed");
        }
        WebElement EventCenters = driver.findElement(By.linkText("Event Centers"));
        if(EventCenters.isDisplayed()){
            System.out.println("Event Centers is displayed ");
        }else{
            System.out.println("Event Centers is not displayed");
        }

        WebElement MGMResort = driver.findElement(By.linkText("MGM Resorts Productions"));
        if(MGMResort.isDisplayed()){
            System.out.println("Mgm Resort Productions is dispalyed");
        }else{
            System.out.println("Mgm Resort Productions is not displayed");
        }
        WebElement MgmEvent = driver.findElement(By.linkText("MGM Resorts Event Services"));
        if(MgmEvent.isDisplayed()){
            System.out.println("Mgm Resorts Event Services is displayed");
        }else{
            System.out.println("MgmResorts Event is not displayed");
        }

        WebElement message = driver.findElement(By.className("rte"));
        message.getText();
        if(message.isDisplayed()){
            System.out.println("Message displayed");
        }else{
            System.out.println("Message not displayed");
        }
        WebElement learnMore=driver.findElement(By.xpath("//a[@href='/en/groups-and-weddings/wedding-planning.html']"));
        learnMore.sendKeys(Keys.ENTER);



//        WebElement LasVegasEventCenter = driver.findElement(By.className("icon-icon-groups hdr"));
//        if(LasVegasEventCenter.isDisplayed()){
//            System.out.println("Las Vegas Event Center is Displayed");
//        }else{
//            System.out.println("Las Vegas Event Center not Displayed");
//        }



        driver.findElement((By.className("icon-wedding-locations hdr")));
        WebElement weddingGallary= driver.findElement(By.className("icon-wedding-locations hdr"));
        if(weddingGallary.isDisplayed()){
            System.out.println("Photos is displayed");
        }else{
            System.out.println("Photos not displayed");
        }

    }




}
