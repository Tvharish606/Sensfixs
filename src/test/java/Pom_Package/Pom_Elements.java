package Pom_Package;
import com.thoughtworks.qdox.model.expression.Add;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Pom_Elements
{
    public WebDriver driver;
    public WebDriverWait wait;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;
    public void Username_textfield()
    {
        wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("autofm1");
    }

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    public void Password_textfield()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("autofm1");
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement Sign_in;
    public void Sign_in_button()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Sign_in));
        Sign_in.click();
    }

    @FindBy(xpath = "(//div[@class='img-container'])[3]")
    private WebElement My_Tickets;
    public void My_Tickets_link()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(My_Tickets));
        Actions A=new Actions(driver);
        A.moveToElement(My_Tickets).click().perform();
    }

    @FindBy(xpath = "//div[@class='addnewticket-myticket']//img")
    private WebElement Add_tickets;
    public void Add_New_Tickets_button() throws InterruptedException
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Add_tickets));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Add_tickets);

//        wait=new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(Add_tickets));
//        Actions A=new Actions(driver);
//        A.moveToElement(Add_tickets).perform();
//       Add_tickets.click();
    }


    @FindBy(xpath = "//b[text()='ADD NEW TICKET']")
    private WebElement Add_New_ticket_form_Heading;
    public void Add_New_Ticket_form_title() throws InterruptedException {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Add_New_ticket_form_Heading));
        if(Add_New_ticket_form_Heading.isDisplayed())
        {
            System.out.println("Add_ticket_tab is dispalyed");
            Assert.assertTrue(true);
            Thread.sleep(3000);
        }
    }

    @FindBy(xpath = "(//button[@type='dropdown-button'])[1]")
    private WebElement Type_dropdown;
    public void Type_Dropdown_click()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Type_dropdown));
        JavascriptExecutor Js=(JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click();", Type_dropdown);
    }

    @FindBy(xpath = "//ul[@class='dropdown-options show']//li[1]")
    private WebElement type_options_list;
    public void Select_type_option() throws InterruptedException
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(type_options_list));
        type_options_list.click();
//        for(WebElement type_categories_option:type_options_list)
//        {
//            String Text = type_categories_option.getText();
//
//            if (Text.equalsIgnoreCase("COMPLAINT")) {
//                JavascriptExecutor js = (JavascriptExecutor) driver;
//                js.executeScript("arguments[0].click();", type_categories_option);
//                Thread.sleep(3000);
//            }
//        }
    }
    @FindBy(xpath = "(//div[@class='app-form-container-item']//div[2])[2]//button")
    private WebElement Complaint_ID;
    public void Complaint_id_button() throws AWTException
    {
//        Robot R=new Robot();
//        R.keyPress(KeyEvent.VK_TAB);
//        R.keyRelease(KeyEvent.VK_TAB);
//        R.keyPress(KeyEvent.VK_ENTER);
//        R.keyRelease(KeyEvent.VK_ENTER);
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Complaint_ID));
        JavascriptExecutor Js=(JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click();", Complaint_ID);
//        Actions A=new Actions(driver);
//        A.moveToElement(Complaint_ID).click().perform();
    }
    @FindBy(xpath = "//li[@id='CI-TES-0007']")
    private WebElement Compliant_options_list;
    public void Complaint_type_option() throws InterruptedException
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Compliant_options_list));
        JavascriptExecutor Js=(JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click();",Compliant_options_list);

        //for(WebElement Complaint_categories_option:Compliant_options_list)
//        {
//            String Text = Complaint_categories_option.getText();
//            if (Text.equalsIgnoreCase("CI-TES-0007"))
//            {
//                JavascriptExecutor js=(JavascriptExecutor) driver;
//                js.executeScript("arguments[0].click();", Complaint_categories_option);
//               // Complaint_categories_option.click();
//            }
//            else {
//                System.out.println(Text);
//            }
//            Thread.sleep(3000);
//        }
    }

    @FindBy(xpath = "(//div[@class='app-form-container-item'])[3]//button")
    private WebElement Category;
    public void Category_id_button()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Category));
        JavascriptExecutor Js=(JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click();",Category);

    }

    @FindBy(xpath = "//*[@id='Other']")
    private WebElement Category_options_list;
    public void Category_type_option()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Category_options_list));
        JavascriptExecutor Js=(JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click();",Category_options_list);

//        for (WebElement Cat_option : Category_options_list)
//        {
//            String Text = Cat_option.getText();
//            System.out.println(Text);
//            if (Text.equalsIgnoreCase(Category_option))
//            {
//                Cat_option.click();
//            } else {
//                System.out.println(Cat_option + " " + "is not a required_thing");
//            }
//        }
    }

    @FindBy(xpath = "(//div[@class='app-form-container-item'])[4]//button")
    private WebElement Asset;
    public void Asset_button()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Asset));
        Asset.click();
    }

    @FindBy(xpath = "//li[@id='Refrigerator']")
    private WebElement Asset_options_list;
    public void Asset_type_option()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Asset_options_list));
        JavascriptExecutor Js=(JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click();",Asset_options_list);
        //        for(WebElement asset_option:Asset_options_list)
//        {
//            String Text = asset_option.getText();
//            System.out.println(Text);
//            if (Text.equalsIgnoreCase(Asset_option))
//            {
//                asset_option.click();
//            }
//            else {
//                System.out.println(asset_option+" "+"is not a required_thing");
//            }
//        }
    }

    @FindBy(xpath = "//button[@class='workflow-button']")
    private WebElement Workflow;
    public void Workflow_Button()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Workflow));
        JavascriptExecutor Js=(JavascriptExecutor) driver;
        Js.executeScript("arguments[0].click();",Workflow);

    }

    @FindBy(xpath = "//span[text()='Streamlined Dishwasher Maintenance']")
    private WebElement Streamlined;
    public void Stream_lined_options()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Streamlined));
        Actions A=new Actions(driver);
        A.moveToElement(Streamlined).click().perform();
    }

    @FindBy(xpath = "//button[text()='Add Now']")
    private WebElement Add_now;
    public void Add_now_button()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Add_now));
        Add_now.click();
    }

    @FindBy(xpath = "//textarea[@type='textarea']")
    private WebElement Write_Description;
    public void write_description_field()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(Write_Description));
        Write_Description.sendKeys("dgvjqshvbxewvxjqhvdqhvdqwgv");
    }

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement create;
    public void create_button()
    {
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(create));
        create.click();
    }

    @FindBy(xpath = "//div[text()='Ticket successfully created']")
    private WebElement successfull_message;
    public void successfull_message_pop()
    {
        //code is to validate the pop
        wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(successfull_message));
        String success= successfull_message.getText();
        System.out.println(success);
        Assert.assertEquals("Ticket successfully",success);
    }

    public Pom_Elements(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
