import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class AddDockUnloading {
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
        driver.findElement(By.linkText("Inbound")).click();
        System.out.println("Logged In Successfully");
    }

    public void dockunloading() throws Exception {

        // Dock and Unloading
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[3]/div[1]/ul[1]/li[2]/a[1]")).click();

        // Dock and Unload Button
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-list[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/app-page-grid[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/button[1]")).click();

        // Type of Inward
       Select typeofinward=new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/select[1]")));
       typeofinward.selectByIndex(1);

       // Transporter Mode
        Select transportermode=new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[2]/select[1]")));
        transportermode.selectByIndex(1);

       // Eway Bill
        Select ewaybill=new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]/div[2]/select[1]")));
        ewaybill.selectByIndex(2);

        // Vehicle Type
        Select vehicletype=new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[5]/div[1]/div[1]/div[2]/select[1]")));
        vehicletype.selectByIndex(2);

        // Dock Snap

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[3]/div[1]/div[2]/a[1]/i[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[5]/div[1]/div[1]/div[3]/button[2]"))).click();

        // save dock and unloading

        Actions action3 = new Actions(driver);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[5]/div[1]/div[1]/div[3]/button[2]"))).click();
        WebElement save = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[3]/div[1]/div[1]/div[1]/button[1]"));
        action3.click(save).build().perform();
        takeSnapShot(driver, "E:\\Selenium\\Selenium-Practicee-master\\DockSave.png") ;

        //lineofitemtab
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/button[1]")).click();
        driver.findElement(By.name("noofboxes_as_per_lr")).sendKeys("2");
        driver.findElement(By.name("total_invoice_quantity")).sendKeys("2");
        driver.findElement(By.name("total_box_breakup")).sendKeys("2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[3]/div[1]/div[2]/a[1]/i[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[6]/div[1]/div[1]/div[3]/button[2]"))).click();
        driver.findElement(By.name("damage_qty")).sendKeys("1");

        WebElement file =driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]"));
        file.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");

        driver.findElement(By.name("remarks")).sendKeys("Test Remark");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[3]/div[1]/div[1]/div[1]/button[4]/i[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/app-delete-pop[1]/div[1]/div[3]/button[2]")).click();

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
            AddDockUnloading dockUnloading = new AddDockUnloading();
            dockUnloading.launchApp();
            dockUnloading.Login();
            dockUnloading.dockunloading();



        }
        catch (Exception e)
        {
            System.out.println("Exception" +e.getMessage());
        }
    }

}
