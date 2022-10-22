import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;

public class AddPacking {
    WebDriver driver=new ChromeDriver();

    public void launchApp()
    {
        driver.manage().window().maximize();
        driver.get("http://192.168.3.14:7000/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public void Login()
    {
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("rgladmin@yopmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("prsingh007");
        driver.findElement(By.id("btnSearch")).click();
        driver.findElement(By.linkText("Outbound")).click();
        System.out.println("Logged In Successfully");
    }

    public void addpacking() throws Exception {
        // packing
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[4]/div[1]/ul[1]/li[3]/a[1]")).click();
        // Generate
        driver.findElement(By.xpath("(//button[@class='btn btn-add btn-green btn-icon-text ng-star-inserted'][normalize-space()='PACKING'])[1]")).click();
        // Save Button of Packing
        driver.findElement(By.xpath("(//i[@title='Save'])[1]")).click();
        // Release Button
        driver.findElement(By.xpath("//i[@title='Release']")).click();
        // Yes Button of release pop
        driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
        // Outbound
        driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[4]/a[1]")).click();
        // Dispatch
        driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[4]/div[1]/ul[1]/li[4]/a[1]")).click();
        // Dispatch Button
        driver.findElement(By.xpath("//button[contains(text(),'DISPATCH')]")).click();
        // Dispatch Box Shipped
        driver.findElement(By.name("disp_boxes_shipped_")).sendKeys("10");
        // weight
        driver.findElement(By.name("disp_weight_")).sendKeys("10");
        // Content
        driver.findElement(By.name("disp_content_")).sendKeys("Test Remark");

        Select Transporter = new Select(driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/div[1]/div[2]/select[1]")));
        Transporter.selectByIndex(1);

        // Booking To
        driver.findElement(By.name("disp_booking_to_")).sendKeys("Goa");
        // Dispatch Docket No
        driver.findElement(By.name("disp_docket_no_")).sendKeys("DIS01");

        // Dispatch Docket Date
        Actions action1 = new Actions(driver);
        WebElement docketdate =driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[11]/div[2]/div[1]/div[2]/kendo-datepicker[1]/span[1]/kendo-dateinput[1]/span[1]/input[1]"));
        action1.sendKeys(docketdate, "22-10-2022").build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='22']")).click();
        // Save Button for Dispatch
        driver.findElement(By.xpath("//i[@title='Save']")).click();


    }
    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }

    public static void main(String[] args) {
        try {
            WebDriverManager.chromedriver().setup();
            AddPacking addPacking=new AddPacking();
            addPacking.launchApp();
            addPacking.Login();
            addPacking.addpacking();
        }
        catch (Exception e)
        {
            System.out.println("Exception" +e.getMessage());
        }
    }
}
