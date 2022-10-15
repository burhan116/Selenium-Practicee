import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class SupplierMaster {
    public static void main(String[] args) throws InvalidSelectorException {
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
            driver.findElement(By.id("exampleInputPassword1")).sendKeys("prsingh007");
            driver.findElement(By.id("btnSearch")).click();
            driver.findElement(By.linkText("Master")).click();
            // Account
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[6]/div[1]/ul[1]/li[3]/a[1]")).click();
            // Supplier master
            driver.findElement(By.linkText("Supplier")).click();
            // Add new Supplier master button
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-list[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]")).click();

            // Supplier Master Record Add
            driver.findElement(By.name("code")).sendKeys("SUP001");
            driver.findElement(By.name("name")).sendKeys("Test Supplier");
            driver.findElement(By.name("reference_code")).sendKeys("REF01");
            driver.findElement(By.name("addressline1")).sendKeys("Santacruz West");
            driver.findElement(By.name("contact_name")).sendKeys("Test");
            driver.findElement(By.name("contact_no")).sendKeys("8169968758");
            driver.findElement(By.name("email_address")).sendKeys("test@yopmail.com");
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/button[1]/i[1]")).click();
            driver.navigate().to("http://192.168.3.14:7000/supplier");
            //driver.navigate().refresh();
            Thread.sleep(3000);
            // From List page edit the record to get back onto Compliance Tab

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[6]/div[1]/button[1]/i[1]"))).click();

            driver.findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/div[1]/a[1]")).click();
           // Compliance Tab
            driver.findElement(By.cssSelector("#btn_supplier_compliance_details_tab")).click();
            // Add Button of Compliance Tab
            driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/a[1]")).click();

            Select compType=new Select(driver.findElement(By.xpath("//body/div[2]/div[2]/div[1]/mat-dialog-container[1]/app-compliance-pop[1]/div[1]/div[2]/div[1]/div[2]/select[1]")));
            compType.selectByIndex(6);
            driver.findElement(By.xpath("//body/div[2]/div[2]/div[1]/mat-dialog-container[1]/app-compliance-pop[1]/div[1]/div[2]/div[2]/div[2]/input[1]")).sendKeys("ANHPH1322R");
            driver.findElement(By.xpath("//body/div[2]/div[2]/div[1]/mat-dialog-container[1]/app-compliance-pop[1]/div[1]/div[2]/div[3]/div[2]/input[1]")).sendKeys("Test Note");


            WebElement browse = driver.findElement(By.xpath("//input[@id='file_image']"));
            //click on ‘Choose file’ to upload the desired file
            browse.sendKeys("C:\\Users\\Saif\\Desktop\\spotify\\aboutphone.jpg"); //Uploading the file using sendKeys
            System.out.println("File is Uploaded Successfully");

//            WebElement validityStartDate = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/app-compliance-pop[1]/div[1]/div[2]/div[5]/div[2]/div[1]/kendo-datepicker[1]/span[1]/kendo-dateinput[1]/span[1]/input[1]"));
//            //Fill date as mm/dd/yyyy as 09/25/2013
//            Thread.sleep(2000);
//            validityStartDate.sendKeys("17-10-2022");
//
//            WebElement validityEndDate = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/app-compliance-pop[1]/div[1]/div[2]/div[5]/div[3]/div[1]/kendo-datepicker[1]/span[1]/kendo-dateinput[1]/span[1]/input[1]"));
//            //Fill date as mm/dd/yyyy as 09/25/2013
//            Thread.sleep(2000);
//            validityEndDate.sendKeys("27-10-2022");

            driver.findElement(By.xpath("//button[@class='btn btn-pop-save action_btn_class ng-star-inserted']")).click();

            //Save Compliance Button
            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/app-compliance-pop[1]/div[1]/div[3]/button[3]")).click();

            // Save Supplier Master
            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/app-compliance-pop[1]/div[1]/div[3]/button[3]")).click();
        }
        catch (Exception exception)
        {
            System.out.println("Exception : " +exception);
        }

    }




}
