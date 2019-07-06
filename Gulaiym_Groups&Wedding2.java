package MavenTasks;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MgmProject2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.get("https://www.mgmresorts.com");
        WebElement groupsWeddings = driver.findElement(By.linkText("Groups & Weddings"));
        groupsWeddings.click();
//        WebElement SocialGroups = driver.findElement(By.linkText("Social Groups"));
//        SocialGroups.click();
       // String learnMore= driver.findElement(By.xpath("//div[@class='btn-wrapper']")).getText();
        WebElement MgmResort = driver.findElement(By.xpath("//div[@span='MGM Resorts Productions']"));
        MgmResort.click();

        WebElement requestQuote = driver.findElement(By.id("comparison-view-all-cta"));
        requestQuote.click();

        WebElement firstName = driver.findElement(By.name("txtFirstName"));
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.name("txtLastName"));
        lastName.sendKeys(faker.name().lastName());
         WebElement Belajio = driver.findElement(By.xpath("//div[@class='rte']"));
        Belajio.click();
        if(Belajio.isDisplayed()){
            System.out.println("Belajio button is displayed");
        }else{
            System.out.println("Belajio button is not displayed");
        }








    }
}

