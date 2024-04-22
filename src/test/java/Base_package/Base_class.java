package Base_package;

import Reporting_Package.Listener_extent;
import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
@Listeners(Listener_extent.class)
public class Base_class
{
    public WebDriver driver;
    @BeforeSuite
    public void Launch_Browser()
    {
        ChromeOptions C=new ChromeOptions();
        C.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(C);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        Listener_extent listener=new Listener_extent();
        listener.Setdriver(driver);
    }
    @AfterSuite
    public void Tear_down()
    {
        driver.close();
    }
    public WebDriver getdriver()
    {
        return driver;
    }
}
