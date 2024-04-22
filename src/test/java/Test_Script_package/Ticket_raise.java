package Test_Script_package;

import Base_package.Base_class;
import Pom_Package.Pom_Elements;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class Ticket_raise extends Base_class {
    public WebDriver driver;
    public Pom_Elements pom;

    @BeforeTest
    public void setup() {
        driver = super.getdriver();
        this.pom = new Pom_Elements(driver);
    }

    @Test(priority = 0, testName = "Login_page_validation")
    public void Test1() {
        driver.get("https://devfm.sensfix.com/");
        String Actual_Login_page_url = driver.getCurrentUrl();
        System.out.println(Actual_Login_page_url);
        Assert.assertEquals("https://devfm.sensfix.com/login", Actual_Login_page_url);
    }

    @Test(priority = 1, testName = "Login_functionality")
    public void Test2() throws InterruptedException {
        pom.Username_textfield();
        pom.Password_textfield();
        pom.Sign_in_button();
        Thread.sleep(6000);
        String Dashboard_url = driver.getCurrentUrl();
        System.out.println(Dashboard_url);
        Assert.assertEquals("https://devfm.sensfix.com/dashboard", Dashboard_url);
    }

    @Test(priority = 2, testName = "ticket_page_validation")
    public void Test3() {
        pom.My_Tickets_link();
        String Tickets_page_url = driver.getCurrentUrl();
        System.out.println(Tickets_page_url);
        Assert.assertEquals("https://devfm.sensfix.com/tickets", Tickets_page_url);
    }

    @Test(priority = 3, testName = "Add_Tickets_form_validation")
    public void Test4() throws InterruptedException {
        pom.Add_New_Tickets_button();
        pom.Add_New_Ticket_form_title();
    }

    @Test(priority = 4, testName = "ticket_addding_validation")
    public void Test5() throws InterruptedException, AWTException {
        pom.Type_Dropdown_click();
        pom.Select_type_option();
        pom.Complaint_id_button();
        pom.Complaint_type_option();
        pom.Category_id_button();
        pom.Category_type_option();
        pom.Asset_button();
        pom.Asset_type_option();
        pom.Workflow_Button();
        pom.Stream_lined_options();
        pom.Add_now_button();
        pom.write_description_field();
        pom.create_button();
        pom.successfull_message_pop();
    }
}
