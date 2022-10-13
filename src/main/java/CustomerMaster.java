import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.function.Function;


import java.time.Duration;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CustomerMaster {


    public static void main(String[] args) throws InterruptedException , StaleElementReferenceException {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("incognito");
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
            // Customer Master
            driver.findElement(By.linkText("Customer")).click();
            // Add Customer New Button
            Thread.sleep(5000);
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-list[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[2]")).click();
            // Customer Record Entry
            driver.findElement(By.name("code")).sendKeys("CUST01");
            driver.findElement(By.name("name")).sendKeys("Test Customer");
            driver.findElement(By.name("email_address")).sendKeys("test@yopmail.com");

            //Billing Information
            driver.findElement(By.name("billing_name")).sendKeys("Rajeev Sinha");
            driver.findElement(By.name("addressline1")).sendKeys("Ground Floor Room No 6 , Rizvi Nagar , Old Rizvi Bldg , S V Road , Santacruz West");
            driver.findElement(By.name("addressline2")).sendKeys("Mumbai , Maharashtra");

            Actions action = new Actions(driver);
            WebElement City = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/kendo-autocomplete[1]/kendo-searchbar[1]/input[1]"));
            action.sendKeys(City, "MUMBAI").build().perform();
            Thread.sleep(2000);
            WebElement elementToClick = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-list[1]/div[1]/ul[1]/li[1]/div[1]"));
            action.click(elementToClick).build().perform();
            Thread.sleep(2000);
            //PostCode
            driver.findElement(By.name("post_code")).sendKeys("400054");

            // Save Button
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/button[1]")).click();
        }
        catch (Exception exception)
        {
            System.out.println("Exception :"+exception);
        }
    }


}

