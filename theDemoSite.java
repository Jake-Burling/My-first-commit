package com.qa.exercisebook;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class theDemoSite{
	ChromeDriver driver;
	
	@Before
	public void setup() {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Admin\\Desktop\\chromedriver.exe");
	driver = new ChromeDriver();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void testy() {
		driver.manage().window().maximize(); //opens window and maximise it
		String url = "http://thedemosite.co.uk/addauser.php"; //open url
		driver.get(url);
		String userInput = "JakeBurling";
		String password = "password";
		WebElement checkElement = driver.findElement(By.name("username"));
		checkElement.sendKeys(userInput);
		WebElement checkElement2 = driver.findElement(By.name("password"));
		checkElement2.sendKeys(password);
		WebElement checkElement3 = driver.findElement(By.name("FormsButton2"));
		checkElement3.submit();
		String url2 = "http://thedemosite.co.uk/login.php";
		driver.get(url2);
		WebElement checkElement4 = driver.findElement(By.name("username"));
		checkElement4.sendKeys(userInput);
		WebElement checkElement5 = driver.findElement(By.name("password"));
		checkElement5.sendKeys(password);
		WebElement checkElement6 = driver.findElement(By.name("FormsButton2"));
		checkElement6.submit();
		WebElement finalcheck = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		assertEquals("error","**Successful Login**", finalcheck.getText());
	}
}