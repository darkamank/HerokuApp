import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploader extends BaseTest{

    @Test
    public void uploadFile(){
        driver.get("http://the-internet.herokuapp.com/upload");
File file = new File("D:\\testing\\HeruvoAPP\\src\\test\\resources\\uploader.txt");
driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys(file.getAbsolutePath());
driver.findElement(By.xpath("//input[@id='file-submit']")).click();
String fileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(fileName,"uploader.txt","File name incorrectly");
    }
}
