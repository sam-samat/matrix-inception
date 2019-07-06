package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assing {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mgmresorts.com/");

        //Locating the title
        WebElement RestaurantButton = driver.findElement(By.id("nav-restaurants-3"));
        RestaurantButton.click();

        //verification of the titel Restaurants
        if(driver.getTitle().contains("Restaurants")) {
            System.out.println("Restaurants button verification passed!");
        }else{
            System.out.println("Hotels button verification failed");
        }
        //Locating the all regions button

        WebElement allRegionsText = driver.findElement(By.id("filter-1-btn"));
        String actualAllRegionText = "All Regions";

        if (allRegionsText.getText().equals(actualAllRegionText)){
         System.out.println("Expected All Regions text verification passed!");

        }else{
            System.out.println("Expected All Regions text verification failed");
        }
        //Locating the Cuisine button
        WebElement expectedCuisineText = driver.findElement(By.id("tagsFilter-0-entertainment-btn"));
        String actualCuisineText = "Cuisine";

        if (expectedCuisineText.getText().equals(actualCuisineText)){
            System.out.println("Expected Cuisine text verification passed!");
        }else {
            System.out.println("Expected Cuisine text verification failed");
        }
        //Locating the Price button
        WebElement expectedPriceText = driver.findElement(By.id("tagsFilter1-1-entertainment-btn"));
        String actualPriceText = "Price";

        if (expectedPriceText.getText().equals(actualPriceText)){
            System.out.println("Expected Price text verification passed!");
        }else {
            System.out.println("Expected Price text verification failed");
        }
        //Locating the Meal button
        WebElement expectedMealText = driver.findElement(By.id("tagsFilter2-2-entertainment-btn"));
        String actualMealText = "Meal";

        if (expectedMealText.getText().equals(actualMealText)){
            System.out.println("Expected Meal text verification passed!");
        }else {
            System.out.println("Expected Meal text verification failed");
        }
       //Locating all regions dropDown list
        WebElement allRegionsDropDown = driver.findElement(By.id("filter-1-btn"));
        allRegionsDropDown.click();

        List<WebElement> allRegionListOfLinks = driver.findElements(By.xpath("//button[@id='filter-1-btn']/../div/ul//li"));
        System.out.println("List of Links " + allRegionListOfLinks.size());
        ArrayList <String> allRegionsWebelementsText = new ArrayList<String>();
        for (WebElement allRegionsLink : allRegionListOfLinks) {
            if(!allRegionsLink.getText().isEmpty()) {
                allRegionsWebelementsText.add(allRegionsLink.getText());
                System.out.println("All Regions Link of Lists: " + allRegionsLink.getText());
            }
        }
        if( allRegionsWebelementsText.get(2).equals("Detroit")){
            System.out.println("City names Virification passed");
        }else{
            System.out.println("City names verifications failed");
        }
        //Locating cuisine dropDown list
        WebElement cuisineDropDown = driver.findElement(By.id("tagsFilter-0-entertainment-btn"));
        cuisineDropDown.click();

        List<WebElement> cuisineListOfLinks = driver.findElements(By.xpath("//button[@id='tagsFilter-0-entertainment-btn']/../div/ul//li"));
        System.out.println("List of Links " + cuisineListOfLinks.size());
        ArrayList <String> cuisineWebelementsText = new ArrayList<String>();
        for (WebElement cuisineLink : cuisineListOfLinks) {
            if(!cuisineLink.getText().isEmpty()) {
                cuisineWebelementsText.add(cuisineLink.getText());
                System.out.println("Cuisines Link of Lists: " + cuisineLink.getText());
            }
        }
        if( cuisineWebelementsText.get(3).equals("Buffet")){
            System.out.println("Cuisine names virification passed");
        }else{
            System.out.println("Cuisine names verifications failed");
        }
        //Locating price dropDown list
        WebElement priceDropDown = driver.findElement(By.id("tagsFilter1-1-entertainment-btn"));
        priceDropDown.click();

        List<WebElement> priceListOfLinks = driver.findElements(By.xpath("//button[@id='tagsFilter1-1-entertainment-btn']/../div/ul//li"));
        System.out.println("List of Links " + priceListOfLinks.size());
        ArrayList <String> priceWebelementsText = new ArrayList<String>();
        for (WebElement priceLink : priceListOfLinks) {
            if(!priceLink.getText().isEmpty()) {
                priceWebelementsText.add(priceLink.getText());
                System.out.println("Price Link of Lists: " + priceLink.getText());
            }
        }
        if(priceWebelementsText.get(5).equals("$$$$")){
            System.out.println("Price names virification passed");
        }else{
            System.out.println("Price names verifications failed");
        }
        //Locating meal dropDown list
        WebElement mealDropDown = driver.findElement(By.id("tagsFilter2-2-entertainment-btn"));
        mealDropDown.click();

        List<WebElement> mealListOfLinks = driver.findElements(By.xpath("//button[@id='tagsFilter2-2-entertainment-btn']/../div/ul//li"));
        System.out.println("List of Links " + mealListOfLinks.size());
        ArrayList <String> mealWebelementsText = new ArrayList<String>();
        for (WebElement mealLink : mealListOfLinks) {
            if(!mealLink.getText().isEmpty()) {
                mealWebelementsText.add(mealLink.getText());
                System.out.println("Meal Link of Lists: " + mealLink.getText());
            }
        }
        if(mealWebelementsText.get(6).equals("Dessert")){
            System.out.println("Meal names virification passed");
        }else{
            System.out.println("Meal names verifications failed");
        }
        driver.close();
        driver.quit();
    }
}
