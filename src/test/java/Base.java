import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","D:\\testing\\HeruvoAPP\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterTest
    public void exit (){
        driver.quit();
    }
}
