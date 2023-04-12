import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.security.KeyStore;
import java.util.*;

public class MobileSearch extends DriverSetup {
    HomePageElements homePageElements;
    WebDriver driver;

    @Test
    public void checkCheapest() {

        homePageElements.closebtn.click();
        homePageElements.searchbar.sendKeys("Mobile");
        homePageElements.searchbtn.click();
        var cheapMbobileSelection = new HashMap<Integer, WebElement>();
        //inserted in ascending order by default
        for (int i = 0; i <= homePageElements.mobilePrices.size(); i++) {
            Integer price = Integer.parseInt(homePageElements.mobilePrices.get(i).getText().replaceAll("[^A-Za-z0-9]", ""));
            cheapMbobileSelection.put(price, homePageElements.mobileNames.get(i));
            System.out.println(cheapMbobileSelection);


        }
        //cheapest mobile is at first key value and expensive is at last key value
        Set<Map.Entry<Integer, WebElement>> cheap = cheapMbobileSelection.entrySet();
        List<Map.Entry<Integer, WebElement>> mobileList = new ArrayList<Map.Entry<Integer, WebElement>>(cheap);
        mobileList.sort(Map.Entry.comparingByKey());
        //show cheapest mobile
        System.out.println(mobileList.get(0).getValue().getText());


    }

    @Test
    public void SearchMobile() {
        homePageElements.closebtn.click();
        homePageElements.searchbar.sendKeys("Mobile");
        homePageElements.searchbtn.click();
        homePageElements.realmecheckbox.click();
        homePageElements.lowtohightoption.click();
        for (WebElement lowselection : homePageElements.mobilePrices) {
            lowselection.click();
        }
        String currwin = driver.getWindowHandle();
        Set<String> allwinhandles = driver.getWindowHandles();
        for (String handle : allwinhandles) {
            String title = driver.getTitle();
            if (title.contains("realme")) {
                driver.switchTo(handle);
            }
            if (homePageElements.buynowbtn.isEnabled()) {
                //product is not outof stock
                homePageElements.buynowbtn.click();
                //blocker of mobile number can't automate
            }

        }
    }

    @Test
    public void checkAddedToBasket() {
        homePageElements.closebtn.click();
        homePageElements.searchbar.sendKeys("Mobile");
        homePageElements.searchbtn.click();
        homePageElements.realmecheckbox.click();
        homePageElements.lowtohightoption.click();
        for (WebElement lowselection : homePageElements.mobilePrices) {
            lowselection.click();
        }
        String currwin = driver.getWindowHandle();
        Set<String> allwinhandles = driver.getWindowHandles();
        for (String handle : allwinhandles) {
            String title = driver.getTitle();
            if (title.contains("realme")) {
                break;
            }
            homePageElements.addtocartbtn.click();
            int basketvalue = Integer.parseInt(homePageElements.basket.getText());
            if (basketvalue >= 1) {
                System.out.println("Basket is not empty and item is added to cart");
            } else {
                System.out.println("Basket is empty");
            }
        }

    }
}
