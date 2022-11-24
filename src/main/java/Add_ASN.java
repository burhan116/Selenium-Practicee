import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Add_ASN {
    private static final Logger LOGGER = LogManager.getLogger(Add_ASN.class);
    public static void main(String[] args) {
        try {

            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver(chromeOptions);
            chromeOptions.addArguments("incognito");
            driver.manage().window().maximize();
            driver.get("http://192.168.3.14:7000/login");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

            //Login Details
            driver.findElement(By.id("exampleInputEmail1")).sendKeys("rgladmin@yopmail.com");
            LOGGER.info("Login : Email Entered");
            driver.findElement(By.id("exampleInputPassword1")).sendKeys("prsingh007");
            LOGGER.info("Login : Password Entered");
            driver.findElement(By.id("btnSearch")).click();
            LOGGER.info("Login Successfully");
            driver.findElement(By.linkText("Inbound")).click();
            LOGGER.info("Clicked on Inbound Successfully from Left navigation");

            // ASN
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[3]/div[1]/ul[1]/li[1]")).click();
            LOGGER.info("Inside Inbound clicked on ASN menu");

            // Add ASN New Button
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-list[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")).click();
            driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-list[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")).click();
            LOGGER.info("Clicked on Add ASN Button and Selected ASN option");

            // Supplier
            Actions action = new Actions(driver);
            WebElement Supplier = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/kendo-autocomplete[1]/kendo-searchbar[1]/input[1]"));
            Thread.sleep(2000);
            action.sendKeys(Supplier, "FASPACK FASTENERS").build().perform();
            Thread.sleep(5000);
            WebElement elementToClick = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-list[1]/div[1]/ul[1]/li[1]"));
            action.click(elementToClick).build().perform();
            LOGGER.info("Supplier as Faspack fasteners selected");

           //Transporter Mode
            Select TransportMode=new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[2]/select[1]")));
            TransportMode.selectByIndex(2);
            LOGGER.info("Transporter Mode Selected");

            driver.findElement(By.name("po_no")).sendKeys("PO102");
            LOGGER.info("PO Number entered");
            driver.findElement(By.name("bill_of_entry_no")).sendKeys("B102");
            LOGGER.info("Bill Of Entry No entered");

            // Transporter
            Select Transporter=new Select(driver.findElement(By.name("transporter_id")));
            Transporter.selectByIndex(1);
            LOGGER.info("Transporter Selected");

            // Vehicle no
            driver.findElement(By.name("vehicle_no")).sendKeys("MH-02-PA-7651");
            LOGGER.info("Vehicle No Entered");

            // Consignment Value
            driver.findElement(By.name("total_consignment_value")).sendKeys("1000");
            LOGGER.info("Consignment Value entered");

            // Stock Type
            Select select = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/div[1]/div[2]/select[1]")));
            select.selectByIndex(1);

            // Line of item Tab
            driver.findElement(By.xpath("//button[@id='profile-tab']")).click();
            LOGGER.info("Swtiched to Line of Item Tab");

            // Add Button for Line of Item
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/span[1]")).click();
            LOGGER.info("Clicked on Add Line of Item Tab");

            // Line of Item Pop
            driver.findElement(By.name("item_invoice_no")).sendKeys("INV127");
            LOGGER.info("Invoice No Entered");

            // ASN Date
            Actions action1 = new Actions(driver);
            WebElement ASNDate =driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/kendo-datepicker[1]/span[1]/span[1]/span[1]"));
            action1.sendKeys(ASNDate, "21-10-2022").build().perform();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-calendar[1]/kendo-calendar-viewlist[1]/kendo-virtualization[1]/table[1]/tbody[1]/tr[5]/td[2]/span[1]")).click();
            LOGGER.info("Invoice Date Selected");

            // AWS/Docket No
            driver.findElement(By.name("docket_no")).sendKeys("AWS09");
            LOGGER.info("Docket No Entered");

            // SKU Code
            Actions action3 = new Actions(driver);
            WebElement SKUCode = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[2]/kendo-autocomplete[1]/kendo-searchbar[1]/input[1]"));
            Thread.sleep(1000);
            action3.sendKeys(SKUCode, "P-10").build().perform();
            Thread.sleep(5000);
            WebElement elementToClicked = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-list[1]/div[1]/ul[1]/li[1]/div[1]"));
            action3.click(elementToClicked).build().perform();
            LOGGER.info("SKU Code Selected as P-10");


            // Quantity
            driver.findElement(By.name("item_quantity")).sendKeys("10");
            LOGGER.info("Quantity Entered");

            // Remark
            driver.findElement(By.name("item_remarks")).sendKeys("Test Remark");
            LOGGER.info("Remark Entered");

            // Save Button of Line of Item
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/div[3]/button[3]")).click();
            LOGGER.info("Clicked on Save Button of LOI");

            // Save ASN
            driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[3]/div[1]/div[1]/button[1]")).click();
            LOGGER.info("Clicked on Save ASN Button");
            takeSnapShot(driver, "E:\\Selenium\\Selenium-Practicee-master\\ASNsaved.png") ;

            // Release ASN
            Thread.sleep(3000);
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[3]/div[1]/div[1]/button[5]/i[1]")).click();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/app-delete-pop[1]/div[1]/div[3]/button[2]"))).click();
            LOGGER.info("ASN Released Successfully");
            takeSnapShot(driver, "E:\\Selenium\\Selenium-Practicee-master\\ASNsreleased.png") ;

        }catch (Exception e) {
        System.out.println("Exception"+e.getMessage());
        }
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

}
