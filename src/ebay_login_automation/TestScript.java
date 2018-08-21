package ebay_login_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScript {

    private WebDriver driver;
    private String URL;
    private String email = "b7058880@nwytg.net";
    private String password = "abcd@1234";

    @BeforeTest // first thing to run , or you can just set priority to 1 same thing
    public void setup() throws Exception {
        System.getProperty("webdriver.gecko.driver", "gecko_driver\\geckodriver.exe");// you need this to run the firefox browser
        driver = new FirefoxDriver();// from this line we're saying open a firefox browser window
        URL = "https://www.google.com";		//we just assigned the url of google
    }

    @Test(priority = 2) // set the priority to 2 so this will execute in second place definitely
    public void googlesearch() throws Exception {
        driver.get(URL); // now in firefox search bar this url will be typed and will be forward towards it
        driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("ebay"); // this line we select search bar in google and type the words eaby
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[3]/center/input[1]")).click(); // click the search button
    }

    @Test(priority = 3)
    public void getlink() {
        driver.findElement(By.linkText("eBay: Electronics, Cars, Fashion, Collectibles, Coupons and More")).click();// we are using link text to go to the webpage we want
        //downside to this will be translated pages	
    }

    @Test(priority = 4)
    public void signIn() {
        driver.findElement(By.linkText("Sign in")).click();// we select the sign in and click on it
        driver.findElement(By.xpath("//*[@id=\"userid\"]")).sendKeys(email); // we select the user id textfield and enter an email
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(password);// we select the password field and enter the password
        driver.findElement(By.xpath("//*[@id=\"sgnBt\"]")).click();// and we click on sign in button
    }

    @AfterTest
    public void closeAll() {
        driver.close();
    }

}
