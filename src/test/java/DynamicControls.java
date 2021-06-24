import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControls extends BaseTest{

        @Test
        public void findAndClickCheckbox(){
            driver.get("http://the-internet.herokuapp.com/dynamic_controls");
            WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
            boolean isCheckboxDisplayed = checkbox.isDisplayed();
            checkbox.click();
            Assert.assertTrue(isCheckboxDisplayed,"Checkbox doesn't displayed");
            driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
            String checkBoxTextIsGone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']"))).getText();
            Assert.assertEquals(checkBoxTextIsGone,"It's gone!", "Didn't display");
            try {
                isCheckboxDisplayed = checkbox.isDisplayed();
            } catch (StaleElementReferenceException exception){
                isCheckboxDisplayed = false;
            }
            Assert.assertFalse(isCheckboxDisplayed,"Checkbox is still displayed");
            WebElement input = driver.findElement(By.xpath("//form[@id='input-example']/input"));
            boolean isInputEnable;
            try {
                input.getAttribute("disabled");
                isInputEnable = true;
            } catch (StaleElementReferenceException exception){
                isInputEnable = false;
            }
            Assert.assertTrue(isInputEnable,"Input isn't enable");
            driver.findElement(By.xpath("//button[@onclick = 'swapInput()']")).click();
            WebElement inputField = driver.findElement(By.xpath("//p[@id='message']"));
            wait.until(ExpectedConditions.visibilityOf(inputField));
            Assert.assertEquals(inputField.getText(),"It's enabled!","Message doesn't displayed");
            try{
                input.sendKeys("something..");
                isInputEnable = true;
            } catch (ElementClickInterceptedException exception){
                isInputEnable = false;
            }
            Assert.assertTrue(isInputEnable,"Input field doesn't enable");
    }

}