import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Console;
import java.time.Duration;

public class EditASN {
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

    public void EditASN() throws InterruptedException {
        // ASN
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[3]/div[1]/ul[1]/li[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[9]/div[1]/button[1]/i[1]"))).click();
        driver.findElement(By.linkText("Edit")).click();
        Select TransportMode=new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[2]/select[1]")));
        TransportMode.selectByIndex(2);

        //Switch to Line Of Item Tab
        driver.findElement(By.xpath("//button[@id='profile-tab']")).click();

        // Add Button for Line of Item
        driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/a[1]")).click();

        // Line of Item Pop
        WebElement invoiceno = driver.findElement(By.name("item_invoice_no"));
        if (invoiceno != null) {
            invoiceno.clear();
            invoiceno.sendKeys("INV301");
        }


        // ASN Date
        Actions action1 = new Actions(driver);
        WebElement ASNDate =driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/kendo-datepicker[1]/span[1]/span[1]/span[1]"));
        action1.sendKeys(ASNDate, "18-10-2022").build().perform();
        Thread.sleep(2000);
         WebElement elementClick= driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-calendar[1]/kendo-calendar-viewlist[1]/kendo-virtualization[1]/table[1]/tbody[1]/tr[5]/td[3]/span[1]"));
         Thread.sleep(2000);
         action1.click(elementClick).build().perform();

        // AWS/Docket No
        driver.findElement(By.name("docket_no")).sendKeys("AWS11");

        // SKU Code
        Actions action3 = new Actions(driver);
        WebElement SKUCode = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[1]/div[2]/kendo-autocomplete[1]/kendo-searchbar[1]/input[1]"));
        Thread.sleep(1000);
        action3.sendKeys(SKUCode, "P-10").build().perform();
        Thread.sleep(5000);
        WebElement elementToClicked = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-list[1]/div[1]/ul[1]/li[1]/div[1]"));
        action3.click(elementToClicked).build().perform();

        // Quantity
        driver.findElement(By.name("item_quantity")).sendKeys("10");

        // Remark
        driver.findElement(By.name("item_remarks")).sendKeys("Test Remark");


        // Save Button of Line of Item
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/div[3]/button[3]")).click();

        // Save ASN
        driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[3]/div[1]/div[1]/button[1]")).click();

        // Release ASN
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[3]/div[1]/div[1]/button[5]/i[1]")).click();
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/mat-dialog-container[1]/app-delete-pop[1]/div[1]/div[3]/button[2]"))).click();
    }


    public static void main(String[] args) throws ElementClickInterceptedException {
        try{
            WebDriverManager.chromedriver().setup();
            EditASN editASN = new EditASN();
            editASN.launchApp();
            editASN.Login();
            editASN.EditASN();
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
}
