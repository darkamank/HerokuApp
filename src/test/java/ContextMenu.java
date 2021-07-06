import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu extends BaseTest{

    @Test
    public void contextClickOnTheTable(){
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.xpath("//div[@id='hot-spot']"))).build().perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"You selected a context menu","PopUP doesn't display");
    }
    @Test
    public void closePopUp(){
        driver.get("http://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.xpath("//div[@id='hot-spot']"))).build().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
