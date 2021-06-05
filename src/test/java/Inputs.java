import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Inputs extends Base{

    @Test
    public void enterDigitsAndCheckArrowUp() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("90");
        Assert.assertEquals(input.getAttribute("value"), "90", "Input digits are not possible");
        input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(input.getAttribute("value"), "91", "Arrow UP doesn't work");
    }
        @Test
        public void checkArrowDown(){
            driver.get("http://the-internet.herokuapp.com/inputs");
            WebElement input = driver.findElement(By.tagName("input"));
            input.clear();
            input.sendKeys("91");
            input.sendKeys(Keys.ARROW_DOWN);
            Assert.assertEquals(input.getAttribute("value"), "90", "Arrow DOWN doesn't work");
            input.clear();
        }
        @Test
    public void enterNonDigits(){
            driver.get("http://the-internet.herokuapp.com/inputs");
            WebElement input = driver.findElement(By.tagName("input"));
            input.clear();
            input.sendKeys("Fgfd");
            Assert.assertEquals(input.getAttribute("value"), "", "Input letters are possible");
        }

    }

