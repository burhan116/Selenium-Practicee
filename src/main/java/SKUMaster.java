import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;



import java.time.Duration;

public class SKUMaster {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        driver.manage().window().maximize();
        driver.get("http://192.168.3.14:7000/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("rgladmin@yopmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("prsingh007");
        driver.findElement(By.id("btnSearch")).click();
        driver.findElement(By.linkText("Master")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[6]/div[1]/ul[1]/li[4]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-left-menu[1]/nav[1]/div[1]/ul[1]/li[6]/div[1]/ul[1]/li[4]/div[1]/ul[1]/li[4]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-list[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]/a[1]/i[1]")).click();
        driver.findElement(By.name("shortname")).sendKeys("P1");
        driver.findElement(By.name("name")).sendKeys("Test SKU");
        driver.findElement(By.name("reference_code")).sendKeys("G1");
        Select UOM=new Select(driver.findElement(By.name("uom_id")));
        UOM.selectByVisibleText("123");
        Select  altUOM=new Select(driver.findElement(By.name("alt_uom_id")));
        altUOM.selectByVisibleText("123");
        Select  category=new Select(driver.findElement(By.name("sku_category_id")));
        category.selectByVisibleText("Brad Nails");
        Select  subcategory=new Select(driver.findElement(By.name("sku_sub_category_id")));
        subcategory.selectByVisibleText("11");
        Select  strlevel=new Select(driver.findElement(By.name("bin_storage_level")));
        strlevel.selectByVisibleText("Floor");
        driver.findElement(By.name("description")).sendKeys("Test Description");
        driver.findElement(By.name("description2")).sendKeys("Test Description 2");
        driver.findElement(By.name("unit_weight")).sendKeys("10");
        driver.findElement(By.name("unit_price")).sendKeys("1000");
        driver.findElement(By.name("unit_per_box")).sendKeys("1");
        driver.findElement(By.name("box_weight")).sendKeys("50");
        driver.findElement(By.name("box_length")).sendKeys("30");
        driver.findElement(By.name("box_width")).sendKeys("80");
        driver.findElement(By.name("box_height")).sendKeys("50");

        //SKU Properties Tab

        driver.findElement(By.cssSelector("#sku-properties-tab")).click();
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(1) div.form-group.col-4:nth-child(1) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(1) div.form-group.col-4:nth-child(2) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(2) div.form-group.col-4:nth-child(1) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(2) div.form-group.col-4:nth-child(2) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(3) div.form-group.col-4:nth-child(1) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(3) div.form-group.col-4:nth-child(2) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(4) div.form-group.col-4:nth-child(1) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(4) div.form-group.col-4:nth-child(2) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(5) div.form-group.col-4:nth-child(1) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(5) div.form-group.col-4:nth-child(2) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
         driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(6) div.form-group.col-4:nth-child(1) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
//        Select iemino=new Select(driver.findElement(By.name("imeino_type")));
//        iemino.selectByVisibleText("One");
        driver.findElement(By.cssSelector("app-dashboard.someClass1.ng-star-inserted:nth-child(2) div.container-scroller div.container-fluid.page-body-wrapper app-crud.someClass1.ng-star-inserted:nth-child(3) div.container-scroller:nth-child(1) div.container-fluid.page-body-wrapper div.main-box div.content-wrapper form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.row div.col-md-12.mb-3.stretch-card div.tab-content div.tab-pane.fade.active.show:nth-child(2) form.forms-sample.needs-validation.wm-forms1.ng-untouched.ng-pristine.ng-valid div.d-flex.flex-wrap.row:nth-child(6) div.form-group.col-4:nth-child(2) label.switch.ng-star-inserted > span.slider.round:nth-child(2)")).click();
        Select storagetype=new Select(driver.findElement(By.name("storage_type_id")));
        storagetype.selectByVisibleText("A1");
        driver.findElement(By.name("crating_charges")).sendKeys("100");
        driver.findElement(By.name("freshness_days")).sendKeys("1");
        driver.findElement(By.name("hsn_code")).sendKeys("HSN1");
        Select packingtype=new Select(driver.findElement(By.name("packaging_type_id")));
        packingtype.selectByVisibleText("ABC");
        driver.findElement(By.name("reorder_level")).sendKeys("1");
        driver.findElement(By.name("reorder_quantity")).sendKeys("10");
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-dashboard[1]/div[1]/div[1]/app-crud[1]/div[2]/div[1]/div[1]/button[1]/i[1]")).click();
        //driver.navigate().refresh();
    }
}
