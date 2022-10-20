import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.Duration;


public class AddGRN {
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

    public void addgrn() throws Exception {
        // GRN Menu
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[3]/div[1]/ul[1]/li[3]/a[1]")).click();
        // GRN Button of the row record
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-list.someClass1.ng-star-inserted:nth-child(3) div.main-panel.main-box:nth-child(1) div.content-wrapper div.row div.col-md-12.pg-body.grid-margin.stretch-card div.card div.card-body div.table-responsive.tbs4.common-table.wm-table form.needs-validation.ng-untouched.ng-pristine.ng-valid div.hack1:nth-child(1) div.hack2 div.fixTableHead table.mat-table.cdk-table.mat-sort.tb-action.du-table tbody:nth-child(2) tr.mat-row.cdk-row.ng-star-inserted:nth-child(1) td.mat-cell.cdk-cell.td-check.cdk-column-grn.mat-column-grn.ng-star-inserted:nth-child(7) > button.btn.btn-add.btn-icon-text.btn-red.ng-star-inserted")).click();
        // Remark field
        driver.findElement(By.name("remarks_hdr")).click();

        // Line of Item Tab
        driver.findElement(By.cssSelector("#grn-item-tab")).click();

        // Add Quantity Received value
//        Actions action = new Actions(driver);
//        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/app-common_editable_mattable[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/div[1]/button[1]/i[1]")).click();
//        Thread.sleep(2000);
//        WebElement elementToClick = driver.findElement(By.linkText("Edit"));
//        action.click(elementToClick).build().perform();

        driver.findElement(By.name("received_quantity_1")).sendKeys("20");

//        // Quantity Received field
//        driver.findElement(By.name("quantity_received")).sendKeys("20");
//        // Remark
//        driver.findElement(By.name("remarks")).sendKeys("Remark Added");
//
//        //Update Button
//        driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();


        // Save Button of GRN
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[3]/div[1]/div[1]/button[1]")).click();
        Thread.sleep(5000);
        takeSnapShot(driver, "E:\\Selenium\\Selenium-Practicee-master\\GRNsaved.png") ;
        Thread.sleep(2000);
        driver.navigate().to("http://192.168.3.14:7000/grn");
        driver.findElement(By.partialLinkText("19-10-20")).click();

        //Edit GRN Add Remark
        driver.findElement(By.name("remarks_hdr")).sendKeys("Releasing GRN Now");

        // Release GRN
        driver.findElement(By.xpath("//body/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[3]/div[1]/div[1]/button[5]/i[1]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
        Thread.sleep(2000);
        takeSnapShot(driver, "E:\\Selenium\\Selenium-Practicee-master\\GRNreleased.png");

//        // Putaway Button click
//        driver.findElement(By.xpath("//button[contains(text(),'Putaway')]")).click();
//
//        // Putaway Details
//        Select putawaytype=new Select(driver.findElement(By.name("putaway_type")));
//        putawaytype.selectByIndex(2);
//
//        // Putaway Assign to
//        Select assignto=new Select(driver.findElement(By.xpath("//select[@id='putaway_assign_to1']")));
//        assignto.selectByIndex(2);
//
//        // Equipment required
//        Select equipmentreq=new Select(driver.findElement(By.xpath("//select[@id='putaway_equipment_req1']")));
//        equipmentreq.selectByIndex(2);





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
            AddGRN addGRN=new AddGRN();
            addGRN.launchApp();
            addGRN.Login();
            addGRN.addgrn();
        }
      catch (Exception e)
      {
          System.out.println("Exception" +e.getMessage());
      }

    }
}
