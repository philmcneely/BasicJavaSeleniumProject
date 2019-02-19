package examples.osx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class FirefoxTemplate {


	public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    		//System.setProperty("webdriver.firefox.marionette","/Users/philmcneely/git/SelTest/lib/geckodriver");
		WebDriver driver = new FirefoxDriver();

		System.out.println("Base log message at: " + System.currentTimeMillis());
    	
        String baseUrl = "http://google.com";
        String expectedTitle = "Google";
        String actualTitle = "";

        // launch browser and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        System.out.println("Page title is: " + actualTitle + " at " + System.currentTimeMillis());

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        //close browser
        driver.close();
       
    }

}