import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Checkboxes extends BaseTest {

    @Test
    public void check() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse(checkboxes.get(0).isSelected(),"First Checkbox is selected");
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected(),"First checkbox is not selected ");
        Assert.assertTrue(checkboxes.get(1).isSelected(),"Second checkbox is notSelected");
        checkboxes.get(1).click();
        Assert.assertFalse(checkboxes.get(1).isSelected(),"Second checkbox is selected");
    }
}