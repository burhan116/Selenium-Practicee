import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;

public class AddSalesOrder {
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

    public void addsalesorder() throws Exception {
        // Sales Order Menu
        driver.findElement(By.linkText("Sales Order")).click();
        // new Button for Sales Order
        driver.findElement(By.xpath("(//button[@id='dropdownMenuSizeButton3'])[1]")).click();
        // Add new Sales order
        driver.findElement(By.xpath("//span[normalize-space()='Sales Order (SO)']")).click();
        // party to ship
        Actions action3 = new Actions(driver);
        WebElement partytoship = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/kendo-autocomplete[1]/kendo-searchbar[1]/input[1]"));
        Thread.sleep(1000);
        action3.sendKeys(partytoship, "fas").build().perform();
        Thread.sleep(5000);
        WebElement elementToClicked = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-list[1]/div[1]/ul[1]/li[1]/div[1]"));
        action3.click(elementToClicked).build().perform();
        // Invoice No
        driver.findElement(By.name("sod_invoice_no")).sendKeys("INV678");
        // Invoice DAte
        Actions action1 = new Actions(driver);
        WebElement invdate =driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[3]/div[1]/div[2]/div[1]/kendo-datepicker[1]/span[1]/kendo-dateinput[1]/span[1]/input[1]"));
        action1.sendKeys(invdate, "20-10-2022").build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-calendar[1]/kendo-calendar-viewlist[1]/kendo-virtualization[1]/table[1]/tbody[1]/tr[5]/td[5]/span[1]")).click();
        // Line of item tab
        driver.findElement(By.xpath("//button[@id='grn-item-tab3']")).click();
        // Add Button of line of item tab
        driver.findElement(By.xpath("(//a[@class='btn btn-add-pop'])[1]")).click();
        // SKU Code
        Actions action2 = new Actions(driver);
        WebElement skucode =driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/kendo-autocomplete[1]/kendo-searchbar[1]/input[1]"));
        action2.sendKeys(skucode, "M-10").build().perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='ng-star-inserted']")).click();
        // Quantity
        driver.findElement(By.name("item_quantity")).sendKeys("20");
        // Remark
        driver.findElement(By.name("sod_remrk")).click();
        // Save Button
        driver.findElement(By.xpath("//button[@class='btn btn-pop-save ng-star-inserted']")).click();

        // Save Sales Order Button
        driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/button[1]/i[1]")).click();
        Thread.sleep(3000);
        takeSnapShot(driver,"E:\\Selenium\\Selenium-Practicee-master\\SOsaved.png");

        // Release SO
        driver.findElement(By.xpath("//button[@id='sodreleasedbtn_']")).click();
        // Yes Button
        driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
        takeSnapShot(driver,"E:\\Selenium\\Selenium-Practicee-master\\SOreleased.png");


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
            AddSalesOrder salesOrder=new AddSalesOrder();
            salesOrder.launchApp();
            salesOrder.Login();
            salesOrder.addsalesorder();
        }
        catch (Exception e)
        {
            System.out.println("Exception" +e.getMessage());
        }

    }

}
