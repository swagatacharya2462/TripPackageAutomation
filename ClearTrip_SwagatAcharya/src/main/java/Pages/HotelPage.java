package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Base.Base;

public class HotelPage extends Base {

	By hotel = By.xpath("//div[normalize-space()='Hotels']");
	// locality
	By locality = By.xpath("//input[@placeholder='Enter locality, landmark, city or hotel']");
	By bbsr = By.xpath("//p[normalize-space()='Bhubaneswar, Orissa, India']");
	// from and to date
	By fromDate = By.xpath("(//*[name()='svg'][contains(@class,'mr-8px')])[1]");
	By fromDate1 = By.cssSelector(
			"div[aria-label='Mon May 15 2023'] div[class='p-1 day-gridContent flex flex-middle flex-column flex-center Round-trip']");
	By toDate1 = By.cssSelector(
			"div[aria-label='Fri May 26 2023'] div[class='p-1 day-gridContent flex flex-middle flex-column flex-center Round-trip']");
	// adult room
	By adultRoom = By.xpath("(//span[@class='fw-500 fs-4 ml-4'])[1]");
	By noAdult = By.xpath("//li[normalize-space()='2 Rooms, 4 Adults']");
	// search
	By search = By.xpath("//div[contains(text(),'Search hotels')]");

	public void hotelPage() {

		logger = report.createTest("Hotel Page");
		try {
			driver.findElement(hotel).click();
			driver.findElement(locality).sendKeys("bhubaneswar");
			Thread.sleep(2000);
			driver.findElement(bbsr).click();
			Thread.sleep(2000);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("window.scrollBy(0,300)");
			Thread.sleep(2000);
			reportPass("Bhubaneswar is clicked");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		try {
			driver.findElement(fromDate).click();
			driver.findElement(fromDate1).click();
			Thread.sleep(2000);
			driver.findElement(toDate1).click();
			Thread.sleep(2000);
			reportPass("from and to date are clicked");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		try {
			driver.findElement(adultRoom).click();
			Thread.sleep(2000);
			driver.findElement(noAdult).click();
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		try {
			driver.findElement(search).click();
			Thread.sleep(7000);
			reportPass("Search button is clicked");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

}
