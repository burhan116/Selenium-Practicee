import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;


public class FirstTest {


    public void TestCaseOne() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        driver.manage().window().maximize();
        driver.get("http://192.168.3.14:7000/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("rgladmin@yopmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("prsingh007");
        driver.findElement(By.id("btnSearch")).click();
        driver.findElement(By.linkText("Master")).click();
        driver.findElement(By.linkText("SKU")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[6]/div[1]/ul[1]/li[4]/div[1]/ul[1]/li[5]/a[1]")).click();
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-list.someClass1.ng-star-inserted:nth-child(3) div.main-panel.main-box:nth-child(1) div.content-wrapper div.row div.col-md-12.pg-body.grid-margin.stretch-card div.card div.card-body div.page-heading div.fillter.d-flex.justify-content-between.align-items-center div.filter-right > a.btn.btn-primary.btn-icon-text.btn-new.ng-star-inserted:nth-child(1)")).click();
        driver.findElement(By.name("bom_code_")).sendKeys("A1");
        driver.findElement(By.name("bom_reference_code")).sendKeys("A1");
        driver.findElement(By.name("bom_name_")).sendKeys("Test");
        driver.findElement(By.name("bom_quantity_")).sendKeys("2");
        Select UOM = new Select(driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/select[1]")));
        UOM.selectByVisibleText("IMPORTANT");
        driver.findElement(By.name("bom_description_")).sendKeys("Test Description");
        WebElement SKU = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/kendo-autocomplete[1]/kendo-searchbar[1]/input[1]"));
        SKU.sendKeys("t4");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/input[1]")).sendKeys("test");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/input[1]")).sendKeys("1");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/table[1]/tbody[1]/tr[1]/td[6]/div[1]/input[1]")).sendKeys("10");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[6]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/input[1]")).sendKeys("11");
        driver.findElement(By.name("bom_note_")).sendKeys("Test Description");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/button[1]/i[1]")).click();
    }


    public static void main(String[] args) {
        try {
            FirstTest firstTest = new FirstTest();
            firstTest.TestCaseOne();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
