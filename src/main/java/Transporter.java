import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.function.Function;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Transporter{

    public static void main(String[] args) {
        try

        {
            System.setProperty("webdriver.chrome.driver", "F:\\New folder\\chromedriver\\chromedriver.exe");
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
            //Transporter
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[6]/div[1]/ul[1]/li[3]/div[1]/ul[1]/li[3]/a[1]")).click();
            //Add Transporter New button
            sleep(5000);
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-list[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/a[1]/span[1]")).click();
            //Transporter Record Entry
            driver.findElement(By.name("transporter_code_")).sendKeys("Transporter1");
            driver.findElement(By.name("name")).sendKeys("Transporter1");
            driver.findElement(By.name("reference_code")).sendKeys("T123");
            driver.findElement(By.name("parent_id")).sendKeys("sa");
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[2]/div[1]/div[2]/div[1]/section[1]/input[1]")).click();
            driver.findElement(By.name("addressline1")).sendKeys("Mumbai");
            driver.findElement(By.name("addressline2")).sendKeys("Mumbai");
            Actions action = new Actions(driver);
            WebElement City = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/kendo-autocomplete[1]/kendo-searchbar[1]/input[1]"));
            action.sendKeys(City, "MUMBAI").build().perform();
            sleep(2000);
            WebElement elementToClick = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/kendo-popup[1]/div[1]/kendo-list[1]/div[1]/ul[1]/li[1]/div[1]"));
            action.click(elementToClick).build().perform();
            sleep(2000);
            driver.findElement(By.name("post_code")).sendKeys("121122");
            driver.findElement(By.name("contact_name")).sendKeys("contact1");
            driver.findElement(By.name("phone_no")).sendKeys("2123242122");
            driver.findElement(By.name("email_address")).sendKeys("test@yopmail.com");
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/button[1]")).click();
            sleep(3000);
            driver.navigate().to("http://192.168.3.14:7000/transporter");
            sleep(3000);
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-list[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/form[1]/app-page-grid[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/div[1]/button[1]/i[1]")).click();
            driver.findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/div[1]/a[1]")).click();
            sleep(5000);
            driver.findElement(By.id("btn_transporter_contact_details_tab")).click();
            driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/span[1]")).click();
            driver.switchTo().defaultContent();
            //driver.findElement(By.xpath())

        }
        catch(Exception e)

        {
            System.out.println("Exception" + e);
        }
    }
}


