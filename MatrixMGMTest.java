package test;

import org.openqa.selenium.interactions.Actions;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.TimeUnit;

public class MatrixMGMTest {
    public static void main(String[] args)throws InterruptedException{



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        /*=======================================================================
                SAMAT MAVZIUTOV
         ========================================================================


        ----------------------------------------------
        Table booking at Morimoto restaurant verification:
        ---------------------------------------------*/
        driver.get("https://www.mgmresorts.com/en.html");
        if(driver.getCurrentUrl().contains("mgmresorts")){
            System.out.println("Url verification has passed");
        }else{
            System.out.println("Url verificaiton has failed");
        }
        WebElement restaurant = driver.findElement(By.id("nav-restaurants-3"));
        Thread.sleep(3000);
        restaurant.click();
        if(driver.getCurrentUrl().contains("restaurants")){
            System.out.println("Restaurants url verificaiton has passed");
        }else{
            System.out.println("Restaurants url verification has failed");
        }
        WebElement restrButton = driver.findElement(By.xpath("//button[@id=\"tagsFilter-0-entertainment-btn\"]"));
        Thread.sleep(3000);
        restrButton.click();

        driver.findElement(By.xpath("//*[@id=\"tagsFilter\"]/div/ul/li[3]/a")).click();
        if(driver.getCurrentUrl().contains("asian")){
            System.out.println("Asian restaurants url verification has passed");
        }else{
            System.out.println("Asian restaurants url verification has failed ");
        }
        WebElement morimoto = driver.findElement(By.xpath("//div[@id='cta-dmp-en-properties-66964e2b-2550-4476-84c3-" +
                "1a4c0c5c067f-restaurants-9a09a36d-77a4-4cbd-966e-08dea25a5df9']/a"));
        morimoto.click();


        driver.findElement(By.id("d-c-8-July")).click();
        WebElement numGuests = driver.findElement(By.id("rest-resrv-guests"));
        Select selectGuests = new Select(numGuests);
        Thread.sleep(5000);
        selectGuests.selectByVisibleText("4 Guests");
        Thread.sleep(5000);
        WebElement timeOfMeal = driver.findElement(By.id("rest-resrv-hours"));
        Select selectHours = new Select(timeOfMeal);
        Thread.sleep(5000);
        selectHours.selectByIndex(2);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//h4[@id='d-special-req-hdr']")).click();
        driver.findElement(By.xpath("//textarea[@id='special-reqs']")).sendKeys("Can I get something to eat please");
        driver.findElement(By.xpath("//button[@id='d-step2-btn']")).click();
        Faker faker = new Faker();
        driver.findElement(By.id("rest-resrv-email"))
                .sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("rest-resrv-first-name")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("rest-resrv-last-name")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("rest-resrv-phone")).sendKeys(faker.phoneNumber().cellPhone().replace(".","").replace("(","").replace(")",""));
        driver.findElement(By.id("confirmTable-btn")).click();
        Thread.sleep(6000);
        if(driver.getCurrentUrl().contains("confirmation")){
            System.out.println("Table booking verification has passed");
        }else{
            System.out.println("Table booking verification has failed");
        }
        String confirmation = driver.getCurrentUrl();
        System.out.println(confirmation);

                /*--------------------------------------------------------------------
                Restaurant filters displayed verification
                ----------------------------------------------------------------------*/

        driver.get("https://www.mgmresorts.com/en.html");
        if(driver.getCurrentUrl().contains("mgmresorts")){
            System.out.println("Url verification has passed");
        }else{
            System.out.println("Url verification has failed");
        }
        WebElement restaurant1 = driver.findElement(By.id("nav-restaurants-3"));
        Thread.sleep(3000);
        restaurant1.click();
        if(driver.getCurrentUrl().contains("restaurants")){
            System.out.println("Restaurants url verification has passed");
        }else{
            System.out.println("Restaurants url verification has failed");
        }
        WebElement allRegions = driver.findElement(By.id("filter-1-btn"));
        if(allRegions.isDisplayed()){
            System.out.println("'All Regions' filter button verification has passed");
        }else{
            System.out.println("'All Regions' filter button verification has failed");
        }
        String allRegionsButton = allRegions.getText();
        System.out.println(allRegionsButton);

        WebElement cuisineButton = driver.findElement(By.id("tagsFilter-0-entertainment-btn"));
        if(cuisineButton.isDisplayed()){
            System.out.println("'Cuisine' filter button verification has passed");
        }else{
            System.out.println("'Cuisine' filer button has failed");

        }
        String cuisineButtonText = cuisineButton.getText();
        System.out.println(cuisineButtonText);

        WebElement priceButton = driver.findElement(By.id("tagsFilter1-1-entertainment-btn"));
        if(priceButton.isDisplayed()){
            System.out.println("'Price' button verification has passed");
        }else{
            System.out.println("'Price' button verification has failed");
        }
        String priceButtonText = priceButton.getText();
        System.out.println(priceButtonText);

        WebElement mealFilterButton = driver.findElement(By.id("tagsFilter2-2-entertainment-btn"));
        if(mealFilterButton.isDisplayed()){
            System.out.println("'Meal' filter button verification has passed");
        }else{
            System.out.println("'Meal' filter button verification has failed ");
        }
        String mealsButtonText = mealFilterButton.getText();
        System.out.println(mealsButtonText);


                /*---------------------------------------------------------
                 Selected restaurant type displayed verification
                -----------------------------------------------------------*/


                driver.get("https://www.mgmresorts.com/en.html");
                if(driver.getCurrentUrl().contains("mgmresorts")){
                    System.out.println("Url verification has passed");
                }else{
                    System.out.println("Url verification has failed");
                }
                WebElement restaurant2 = driver.findElement(By.id("nav-restaurants-3"));
                Thread.sleep(3000);
                restaurant2.click();
                if(driver.getCurrentUrl().contains("restaurants")){
                    System.out.println("Restaurants url verification has passed");
                }else{
                    System.out.println("Restaurants url verification has failed");
                }
                WebElement moreRestaurantsButton = driver.findElement(By.linkText("Discover more"));
                moreRestaurantsButton.click();
                Thread.sleep(6000);
                if(driver.getTitle().contains("Best Restaurants")){
                    System.out.println("Best restaurants page verification has passed");
                }else {
                    System.out.println("Best Restaurants page verification has failed");
                }
                System.out.println(driver.getTitle());
                WebElement steakhouses = driver.findElement(By.linkText("Steakhouses"));
                steakhouses.click();
                Thread.sleep(6000);
                if(driver.getCurrentUrl().contains("Steakhouses")){
                    System.out.println("Steakhouses page verification has passed");
                }else{
                    System.out.println("Steakhouses page verification has failed");
                }
                System.out.println(driver.getCurrentUrl());


        /*===============================================================================
        MINTESNOT HARKISO TEST CASES:
        =================================================================================
         --------------------------------------------------------------------------------
         first_scenario
         --------------------------------------------------------------------------------
         */


        driver.get("https://www.mgmresorts.com");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement popUp=driver.findElement(By.xpath("//button[@class='msg-close']"));
        //popUp.click();
        WebElement entertainmentButton =driver.findElement(By.id("nav-entertainment-2"));
        entertainmentButton.click();
        if(driver.getTitle().contains("Entertainment")){
            System.out.println("Entertainment page Verification passed");
        }else{
            System.out.println("Entertainment page Verification failed");
        }
        /*-----------------------------------------------------------------------------
        second_Scenario
        -------------------------------------------------------------------------------
         */
        WebElement searchEvents =driver.findElement(By.xpath("//input[@id='es-search-term']"));
        searchEvents.sendKeys("Concerts" + Keys.ENTER);
        if(driver.getTitle().contains("Concerts")){
            System.out.println("Search element display passed");
        }else{
            System.out.println("Search element display failed");
        }
        Thread.sleep(3000);
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

        /*---------------------------------------------------------------------------
         third scenario making sure all the shows have the details
         -----------------------------------------------------------------------------
         */

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

     /*=======================================================================

     GULAIYM KALIEVA TEST CASES

     =========================================================================

     -------------------------------------------------------------------------

     First Test Case:
      */


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


    /*--------------------------------------------------------------------------
        Second Test Case:
     ---------------------------------------------------------------------------
     */

        driver.get("https://www.mgmresorts.com");
        WebElement groupsWeddings1 = driver.findElement(By.linkText("Groups & Weddings"));
        groupsWeddings1.click();
//        WebElement socialGroups = driver.findElement(By.linkText("Social Groups"));
//        socialGroups.click();
        // String learnMore= driver.findElement(By.xpath("//div[@class='btn-wrapper']")).getText();
        WebElement MgmResort = driver.findElement(By.xpath("//div[@span='MGM Resorts Productions']"));
        MgmResort.click();

        WebElement requestQuote = driver.findElement(By.id("comparison-view-all-cta"));
        requestQuote.click();

        WebElement firstName = driver.findElement(By.name("txtFirstName"));
        //Faker faker = new Faker();
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


     /*----------------------------------------------------------------------------
     Third Test Case:
     ------------------------------------------------------------------------------
      */

        driver.get("https://www.mgmresorts.com");


        WebElement groupsWeddingss = driver.findElement(By.linkText("Groups & Weddings"));
        groupsWeddingss.click();

        WebElement socialGroups = driver.findElement(By.linkText("Social Groups"));
        if(socialGroups.isDisplayed()){
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

        //Faker faker = new Faker();

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


    /*============================================================================

        BAKTYGUL ORUNBAEVA TEST CASES:
     ============================================================================


     */

        driver.get("https://www.mgmresorts.com");
        //User should able to locate and click on Resorts
        //User  should be able to choose of one of the four country/city options

        driver.findElement(By.id("nav-resorts-1")).click();
        String url = driver.getCurrentUrl();
        if (url.contains("hotels")) {
            System.out.println("Url verification Passed");
        } else {
            System.out.println("Url verification didn't pass");
        }
        Thread.sleep(3000);

        WebElement lasVegas1 = driver.findElement(By.linkText("Las Vegas"));
        lasVegas1.click();
        if (driver.getCurrentUrl().contains("Vegas")) {
            System.out.println("Url verification of Las Vegas passed");
        } else {
            System.out.println("URL Verification of Las Vegas Didn't passed");
        }
        Thread.sleep(3000);


        WebElement unitedStates = driver.findElement(By.linkText("United States"));
        unitedStates.click();
        if (driver.getCurrentUrl().contains("United")) {
            System.out.println("Verification of United States Passed");
        } else {
            System.out.println("URL verification of United States didn't pass");
        }
        WebElement chinaButton = driver.findElement(By.linkText("China"));
        chinaButton.click();
        if (driver.getCurrentUrl().contains("China")) {
            System.out.println("URL verification of China passed");
        } else {
            System.out.println("URL verification of China didn't pass");
        }
        Thread.sleep(3000);
        WebElement japanButton = driver.findElement(By.linkText("Japan"));
        japanButton.click();
        if (driver.getCurrentUrl().contains("Japan")) {
            System.out.println("URL verification of Japan passed");
        } else {
            System.out.println("URL verification of japan didn't pass");
        }



        //User should be able to click on listed resort
        //User should be able to choose the check in/checkout date


        WebElement bookNoww=driver.findElement(By.xpath("//a[@href='/en/booking/room-booking.html']"));
        bookNoww.click();


        WebElement resortSelected=driver.findElement(By.xpath(".//*[contains(@class,'resort-item-container')]"));
        resortSelected.click();
        WebElement checkIn=driver.findElement(By.xpath("//a[@id='c-08-07-2019']"));
        checkIn.click();
        if(driver.getCurrentUrl().contains("2019-07-08")) {
            System.out.println("Verification of check in date passed");
        }
        else  {
            System.out.println("Verification of check in date didn't pass");
        }
        WebElement checkOut=driver.findElement(By.xpath("//a[@id='c-09-07-2019']"));
        checkOut.click();
        if(driver.getCurrentUrl().contains("2019-07-09")) {
            System.out.println("Verification of check out date is passed");
        }
        else {
            System.out.println("Verification of check out date didn't pass");
        }


        //User should be able to choose one of the listed hotels
        //User should be able to reserve a room,entering all information
        driver.findElement(By.xpath("//div[@id='2ae59b7d-ae21-470d-a36f-2649ac87f7d3']//div[2]//div[2]//button")).click();
        Faker fakerB =new Faker();
        WebElement inputFirstName=driver.findElement(By.id("guest-info-cont-first-name"));
        inputFirstName.sendKeys(faker.name().name());
        WebElement inputLastName=driver.findElement(By.id("guest-info-cont-last-name"));
        inputLastName.sendKeys(faker.name().lastName());
        WebElement inputPhoneNumber=driver.findElement(By.id("guest-info-cont-phone"));
        inputPhoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        WebElement inputEmail1=driver.findElement(By.id("guest-info-login-email-address"));
        inputEmail1.sendKeys(faker.internet().emailAddress());
        WebElement inputNameOnCard=driver.findElement(By.id("guest-info-cont-last-name"));
        inputNameOnCard.sendKeys(faker.name().fullName());
        WebElement inputCardNumber=driver.findElement(By.id("bill-card-num"));
        inputCardNumber.sendKeys(faker.finance().creditCard());
        WebElement inputExpMonth=driver.findElement(By.id("bill-card-exp-month"));
        inputEmail1.sendKeys("08");
        WebElement inputExpYear=driver.findElement(By.id("bill-card-exp-year"));
        inputExpYear.sendKeys("2020");
        WebElement inputCvv=driver.findElement(By.id("bill-card-cvv"));
        inputCvv.sendKeys("696");
        WebElement inputAddress=driver.findElement(By.id("bill-address1"));
        inputAddress.sendKeys(faker.address().streetAddress());
        WebElement inputCity=driver.findElement(By.id("bill-city"));
        inputCity.sendKeys(faker.address().cityName());
        WebElement inputState=driver.findElement(By.id("bill-us-state"));
        inputState.sendKeys(faker.address().state());
        WebElement inputZipCode=driver.findElement(By.id("bill-zip"));
        inputZipCode.sendKeys(faker.address().zipCode());
        WebElement TermAndConditions=driver.findElement(By.id("terms-label"));
        TermAndConditions.click();
        WebElement confirm=driver.findElement(By.id("review-final"));
        confirm.click();

     /*=====================================================================

     YORDANOS TEFERA TEST CASES:

     =======================================================================
      */
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

     /*==============================================================================
     MIRZAT ARABAEVA TEST CASES:
     ================================================================================
      */

        driver.get("https://www.mgmresorts.com");

        driver.findElement(By.id("nav-offers-8")).click();
        //count number of links on landing page
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("The number of links on this page: " + listOfLinks.size());

        //verify the text "offer"
        WebElement text = driver.findElement(By.id("tagsFilter-0-entertainment-btn"));
        String s = text.getText();
        System.out.println(s);
        if (s.contains("offers")) {
            System.out.println("text verification PASSED!");
        } else {
            System.out.println("text verification FAILED!!!");

        }
        //verify whether each button is clickable inside "all regions" button
        driver.findElement(By.id("filter-1-btn"));
        driver.findElement(By.xpath("//*[@id=\"region-0\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"region-1\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"region-2\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"region-3\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"region-4\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"region-5\"]/span")).click();

        //verify whether each button is clickable inside "all types" button
        driver.findElement(By.id("tagsFilter-0-entertainment-btn"));
        driver.findElement(By.id("tagsFilter-0-entertainment-btn"));
        driver.findElement(By.xpath("//*[@id=\"tagsFilter\"]/div/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"tagsFilter\"]/div/ul/li[2]/a")).click();
        driver.findElement((By.xpath("//*[@id=\"tagsFilter\"]/div/ul/li[3]/a"))).click();



    }


}







