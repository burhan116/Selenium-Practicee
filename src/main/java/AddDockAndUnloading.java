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

public class AddDockAndUnloading {
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

    public void dockandunloading() throws Exception {

        // Dock Assign
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).click();
        // card click
        driver.findElement(By.xpath("//div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]")).click();
        // Select Account
        Select account =new Select(driver.findElement(By.name("account_id")));
        account.selectByIndex(1);
        // Select ASN No
        Select asnono =new Select(driver.findElement(By.name("record_id")));
        asnono.selectByIndex(1);
        // Select Transporter
        Select transporter =new Select(driver.findElement(By.name("transporter_id")));
        transporter.selectByIndex(1);

//        Actions action1 = new Actions(driver);
//        WebElement docketno =driver.findElement(By.xpath("/html[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
//        action1.moveToElement(docketno).sendKeys("D21");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-calendar[1]/kendo-calendar-viewlist[1]/kendo-virtualization[1]/table[1]/tbody[1]/tr[4]/td[7]/span[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Vehicle No
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[5]/div[1]/div[2]/input[1]"))).sendKeys("MH-02-PA-7651");

        // Select Security
        Select security =new Select(driver.findElement(By.name("security_id")));
        security.selectByIndex(1);

        // Save Assign Dock
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/button[1]"))).click();
        driver.findElement(By.xpath("/html[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
        takeSnapShot(driver, "E:\\Selenium\\Selenium-Practicee-master\\DockAssign.png") ;

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
            AddDockAndUnloading dockAndUnloading = new AddDockAndUnloading();
            dockAndUnloading.launchApp();
            dockAndUnloading.Login();
            dockAndUnloading.dockandunloading();



        }
        catch (Exception e)
        {
            System.out.println("Exception" +e.getMessage());
        }
    }
}
