import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class DriverSetup {
    WebDriver driver;

  @BeforeMethod
  public void urls(){
      System.setProperty("wedriver.chrome.driver","D:\\FlipkartMobileCheckout\\MobileCheckout\\chromedriver.exe");
//     System.setProperties("webdriver.chrome.driver","D\\FlipkartMobileCheckout\\MobileCheckout\\chromedriver.exe");
      WebDriver driver=new ChromeDriver();
        //WebDriverManager.chromedriver().setup();
     //   driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MICROSECONDS);
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MICROSECONDS);


    }
    @AfterMethod
    public void closeDriver(){
      driver.quit();
    }
}
