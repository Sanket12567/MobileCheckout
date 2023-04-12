import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageElements {
    WebDriver driver;
    @FindBy(how =How.XPATH,using = "//button[@class='_2KpZ6l _2doB4z']")
    protected WebElement closebtn;
    @FindBy(how = How.XPATH,using = "//input[@name='q']")
    protected WebElement searchbar;
    @FindBy(how = How.XPATH,using = "//button[@class='L0Z3Pu']")
    protected WebElement searchbtn;
    @FindBy(how = How.CSS,using = "div[title='realme'] div[class='_3879cV']")
    protected WebElement realmecheckbox;
    @FindBy(how = How.XPATH,using = "//div[@class='_30jeq3 _1_WHN1']")
    protected List<WebElement> mobilePrices;
    @FindBy(how = How.XPATH,using = "//div[@class='_4rR01T']")
    protected List<WebElement> mobileNames;
    @FindBy(how = How.XPATH,using = "//div[contains(text(),'Price -- Low to High')]")
    protected WebElement lowtohightoption;
    @FindBy(how = How.XPATH,using = "//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
    protected WebElement buynowbtn;
    @FindBy(how = How.XPATH,using = "//a[@class='_3SkBxJ']")
    protected WebElement basket;
    @FindBy(how = How.XPATH,using = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
    protected WebElement addtocartbtn;

    public HomePageElements(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
