package MavenTasks;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MgmProject3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.mgmresorts.com");
        
        
        WebElement groupsWeddings = driver.findElement(By.linkText("Groups & Weddings"));
        groupsWeddings.click();

        WebElement SocialGroups = driver.findElement(By.linkText("Social Groups"));
        if(SocialGroups.isDisplayed()){
            System.out.println("Social Group Button is Displayed");
        }else{
            System.out.println("Social Group Button is not Displyed");
        }

        WebElement bookNow = driver.findElement(By.id("nav-book"));
        bookNow.click();
        WebElement groupVacations = driver.findElement(By.id("nav-book-dd-4"));
        groupVacations.click();

        WebElement socialForm = driver.findElement(By.xpath("//div[@class='btn-learn-more']/a"));
        socialForm.sendKeys(Keys.ENTER);
        System.out.println("Social form button is working");
        
         Faker faker = new Faker();
       
        WebElement inputName = driver.findElement(By.xpath("//form[@id='fsForm2785668']//div[@class='fsSubField fsNameFirst']/input"));
        Actions action = new Actions(driver);
        action.moveToElement(inputName).click().build().perform();
        Thread.sleep(1000);

        inputName.sendKeys("name");

        WebElement inputlastName = driver.findElement(By.id("field55468381-last"));
        inputlastName.sendKeys(faker.name().lastName());

        WebElement inputEmail = driver.findElement(By.id("field55468385"));

        WebElement contactNumber = driver.findElement(By.id("field55468383"));
        contactNumber.sendKeys(faker.number().digit());

        WebElement contactPreference = driver.findElement(By.id("fsLegend55468410"));













    }
            }
