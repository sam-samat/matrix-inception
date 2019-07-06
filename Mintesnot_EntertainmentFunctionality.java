package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EntertainmentFunctionality {

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.mgmresorts.com");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement popUp=driver.findElement(By.xpath("//button[@class='msg-close']"));
         popUp.click();
        WebElement entertainmentButton =driver.findElement(By.id("nav-entertainment-2"));
        entertainmentButton.click();
        if(driver.getTitle().contains("Entertainment")){
            System.out.println("Entertainment page Verification passed");
        }else{
            System.out.println("Entertainment page Verification failed");
        }
        //first_Scenario
       WebElement searchEvents =driver.findElement(By.xpath("//input[@id='es-search-term']"));
       searchEvents.sendKeys("Concerts" + Keys.ENTER);
       if(driver.getTitle().contains("Concerts")){
           System.out.println("Search element display passed");
       }else{
           System.out.println("Search element display failed");
       }
       WebElement cityDropDown=driver.findElement(By.xpath("//div[@id='search-location-drop']"));
       cityDropDown.click();
      WebElement lasVegas=driver.findElement(By.xpath("//li[@aria-label='Mississippi']/../li[1]"));
      lasVegas.click();
      String expectedCityName="Las Vegas";
       if(lasVegas.getText().contains(expectedCityName)){
           System.out.println("City verification passed");
       }else{
           System.out.println("City verification failed");
       }
       WebElement subCityAllLasVegasFilter=driver.findElement(By.xpath("//li[@aria-label='Mississippi']/../li[1]//li[@aria-label='All Las Vegas']"));
       subCityAllLasVegasFilter.click();
       WebElement durationFilterSearch=driver.findElement(By.xpath("//div[@class='duration-search ']"));
       durationFilterSearch.click();
     if(durationFilterSearch.getText().contains(" View All Dates")){
         System.out.println("View all dates verification passed");
     }else{
         System.out.println("View all dates verification failed");
     }
        WebElement thisWeekendSearch=driver.findElement(By.xpath("//li[@aria-label=\"This Weekend\"]"));
     thisWeekendSearch.click();

   WebElement search=driver.findElement(By.xpath("//div[@class='search-btn']"));
     search.click();
   // third scenario making sure all the shows have the details
    WebElement hughJackmanShow=driver.findElement(By.xpath("//div[@ng-show='searchResult.showSearchResult']/div[2]"));
        WebElement pentatonixConcertDiscription=driver.findElement(By.xpath("//div[@ng-show='searchResult.showSearchResult']/div[2]/div[2]"));
        String availableDatesOfTheShow="Available Dates";

        if(pentatonixConcertDiscription.getText().contains(availableDatesOfTheShow)){
            System.out.println("Available date display passed");
        }else{
            System.out.println("Available date display failed");
        }
        String ticketPrice="$39";
        if(pentatonixConcertDiscription.getText().contains(ticketPrice)){
            System.out.println("Ticket Price display passes");
        }else{
            System.out.println("Ticket Price display failed");
        }
       String buyTicket="BUY TICKETS";
        if(pentatonixConcertDiscription.getText().contains(buyTicket)){
            System.out.println("Buy ticket display verification passed");
        }else{
            System.out.println("Buy ticket display verification failed");
        }
       WebElement buyTicketButton= driver.findElement(By.xpath("//a[@href='https://www.mgmresorts.com/en/booking/show-booking.html#/show-listing&showFilter=postmodern-jukebox-1oak&arrive=07/05/2019']"));
            buyTicketButton.sendKeys(Keys.ENTER);
            String bookingPage="Show Booking - MGM Resorts";
         if(driver.getTitle().contains(bookingPage)){
             System.out.println("Booking page verification passed");
         }else{
             System.out.println("Booking page verification failed");
         }


    }


}
