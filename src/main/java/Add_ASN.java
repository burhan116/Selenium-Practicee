import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Add_ASN {
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
            driver.findElement(By.id("exampleInputPassword1")).sendKeys("prsingh007");
            driver.findElement(By.id("btnSearch")).click();
            driver.findElement(By.linkText("Inbound")).click();
            // ASN
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[3]/div[1]/ul[1]/li[1]")).click();

            // Add ASN New Button
            driver.findElement(By.id("dropdownMenuSizeButton3")).click();
            driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-list[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[1]")).click();

            // Supplier
            Actions action = new Actions(driver);
            WebElement Supplier = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/kendo-autocomplete[1]/kendo-searchbar[1]/input[1]"));
            Thread.sleep(2000);
            action.sendKeys(Supplier, "FASPACK FASTENERS").build().perform();
            WebElement elementToClick = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-list[1]/div[1]/ul[1]/li[1]/div[1]"));
            action.click(elementToClick).build().perform();

           //Transporter Mode
            Select TransportMode=new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[3]/div[1]/div[2]/select[1]")));
            TransportMode.selectByIndex(2);

            driver.findElement(By.name("po_no")).sendKeys("PO101");
           // driver.findElement(By.id("k-95874106-ec20-4444-8e20-565170552ca1")).sendKeys("15-10-2022");
            driver.findElement(By.name("bill_of_entry_no")).sendKeys("B101");

            // Transporter
            Select Transporter=new Select(driver.findElement(By.name("transporter_id")));
            Transporter.selectByIndex(1);

            // Vehicle no
            driver.findElement(By.name("vehicle_no")).sendKeys("MH-02-PA-7651");

            // Consignment Value
            driver.findElement(By.name("total_consignment_value")).sendKeys("1000");

            // Line of item Tab
            driver.findElement(By.xpath("//button[@id='profile-tab']")).click();

            // Add Button for Line of Item
            driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/a[1]")).click();

            // Line of Item Pop
            driver.findElement(By.name("item_invoice_no")).sendKeys("INV104");
            

            // Save ASN
            //driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[3]/div[1]/div[1]/button[1]")).click();

        }catch (Exception e) {
        System.out.println("Exception"+e.getMessage());
        }
    }
}
