package examples.windows;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.chrome.ChromeDriver;
public class ChromeTemplate {


	public static void main(String[] args) {
        // declaration and instantiation of objects/variables
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//Assuming you placed the chromedriver and geckodriver in the directory below on your machine
		System.setProperty("webdriver.chrome.driver","C:\\Windows\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
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