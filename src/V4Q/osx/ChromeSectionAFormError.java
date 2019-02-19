package V4Q;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class ChromeSectionAFormError {


	public static void main(String[] args) throws InterruptedException {
        // declaration and instantiation of objects/variables
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Base log message at: " + System.currentTimeMillis());
    	
        String baseUrl = "https://veterans4quality.org/#sectionA";
        String expectedErrorMessage = "Your must enter a valid email.";
        String actualErrorMessage = "";

        // launch browser and direct it to the Base URL https://www.seleniumhq.org/docs/03_webdriver.jsp#fetching-a-page
        driver.get(baseUrl);

        System.out.println("Page title is: " + "" + " at " + System.currentTimeMillis());
        
        //This is one way of doing a select: https://www.seleniumhq.org/docs/03_webdriver.jsp#user-input-filling-in-forms
        /*<select name="sendertitle_op1" id="sendertitle_op2">
		<option value="" selected="">Title</option>
		<option value="Mr" class="smartfm-ctrl">Mr</option>
		<option value="Ms" class="smartfm-ctrl">Ms</option>
		<option value="Miss" class="smartfm-ctrl">Miss</option>
		<option value="Mrs" class="smartfm-ctrl">Mrs</option>										
		<option value="Other" class="smartfm-ctrl" data-show-id="titleother1">Other</option>
		</select>*/
        Select select = new Select(driver.findElement(By.id("sendertitle_op2")));
        select.selectByVisibleText("Miss");
        
        //Find an element by id https://www.seleniumhq.org/docs/03_webdriver.jsp#by-id
        //<input type="text" name="senderfirstname" id="senderfirstname" class="gui-input dark" placeholder="First name*">
        driver.findElement(By.id("senderfirstname")).sendKeys("Veteran");
        
        //Find an element by name https://www.seleniumhq.org/docs/03_webdriver.jsp#by-name
        //<input type="text" name="senderlastname" id="senderlastname" class="gui-input dark" placeholder="Last name*">
        driver.findElement(By.name("senderlastname")).sendKeys("4Quality");
        
        //Find an element by id https://www.seleniumhq.org/docs/03_webdriver.jsp#by-id
        //<input type="email" name="emailaddress" id="emailaddress" class="gui-input" placeholder="Email address*">
        //driver.findElement(By.("emailaddress")).sendKeys("a@b.c");

        //Find an element by tag name, then iterate over until you find the right one https://www.seleniumhq.org/docs/03_webdriver.jsp#user-input-filling-in-forms
        List<WebElement> allInputs = driver.findElements(By.tagName("input"));
        for (WebElement input : allInputs) {
            System.out.println(String.format("Input is: %s", input.getAttribute("name")));
            if (input.getAttribute("name").toString().equals("emailaddress")) {
            	input.sendKeys("a@b.c");
            	System.out.println("Found element " + input.getAttribute("name") + " at " + System.currentTimeMillis());
            	break; //don't look at therest once you find the right one.
            }
        }
        
        //<input type="tel" name="telephone" id="telephone" class="gui-input" placeholder="Telephone">
        driver.findElement(By.id("telephone")).sendKeys("555-555-5555");
        
        //<input type="text" name="sendersubject" id="sendersubject" class="gui-input" placeholder="Subject*">
        driver.findElement(By.id("sendersubject")).sendKeys("Just Testing!");
        
        //<textarea class="gui-textarea" id="sendermessage" name="sendermessage" placeholder="Message*"></textarea>
        driver.findElement(By.id("sendermessage")).sendKeys("This is a really really really really really really really really really really really really really really really long string");
        
        Thread.sleep(5000); //sleep 5 seconds so classcan see it working
        
        //<button type="submit" data-btntext-sending="Sending..." class="button btn-primary blue">Submit</button>
        driver.findElement(By.cssSelector("#smart-form1 > div.form-footer > button")).click();
        
        Thread.sleep(5000); //sleep 5 seconds so classcan see it working
        
        //Find element by cssSelector https://www.seleniumhq.org/docs/03_webdriver.jsp#by-css
        // #smart-form1 > div > div.result > div > ul > li
        // #smart-form1 > div:nth-child(1) > div.result > div > ul > li
        actualErrorMessage = driver.findElement(By.cssSelector("#smart-form1 > div > div.result > div > ul > li")).getText();
        
        /*
         * compare the actual ErrorMessage of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualErrorMessage.contentEquals(expectedErrorMessage)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        //close browser
        driver.close();
       
    }

}