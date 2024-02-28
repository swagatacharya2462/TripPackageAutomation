package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import Base.Base;

public class FlightsPage extends Base {

	// trip
	By cross = By.xpath("(//*[name()='svg'][@class=' c-pointer c-neutral-900'])[1]");
	By oneWay = By.xpath("//span[normalize-space()='One way']");
	By round = By.xpath("//span[normalize-space()='Round trip']");
	// adult & economy
	By adultEconomy = By.xpath("//span[normalize-space()='1 Adult, Economy']");
	By adultEconomy2 = By.xpath("//span[normalize-space()='5 Adults, 3 Children, 3 Infants, Business class']");
	By adultPlus = By.xpath("(//li[@class='flex-inline'])[1]");
	By childrenPlus = By.xpath("(//li[@class='flex-inline'])[2]");
	By infantsPlus = By.xpath("(//li[@class='flex-inline'])[3]");
	By classEco = By.xpath("//div[contains(text(),'Business class')]");
	// from
	By from = By.xpath("//input[contains(@placeholder,'Where from?')]");
	By bbsr = By.xpath("(//div[@class='flex flex-middle'])[5]");
	// to
	By to = By.xpath("//input[@placeholder='Where to?']");
	By bangalore = By.xpath("(//div[@class='flex flex-middle'])[5]");
	// from and to date
	By date = By.xpath("//div[contains(@class,'col flex flex-middle w-100p')]//button[1]");
	By fromDate = By.xpath(
			"(//div[contains(@class,'p-1 day-gridContent fs-14 fw-500 flex flex-middle flex-column flex-center Round-trip')])[46]");
	By toDate = By.cssSelector(
			"div[aria-label='Mon Jun 12 2023'] div[class='p-1 day-gridContent fs-14 fw-500 flex flex-middle flex-column flex-center Round-trip']");
	By search = By.xpath("//span[contains(text(),'Search flights')]");

	public void flightsPage() {

		logger = report.createTest("Flights Page");
		try {
			driver.findElement(cross).click();
			driver.findElement(oneWay).click();
			driver.findElement(round).click();

			WebElement wbElement = driver.findElement(round);
			if (wbElement.isEnabled()) {
				reportPass("Roundtrip is clicked");
			}
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		try {
			driver.findElement(adultEconomy).click();
			for (int i = 0; i <= 3; i++) {
				driver.findElement(adultPlus).click();
			}
			Thread.sleep(2000);
			for (int j = 0; j <= 2; j++) {
				driver.findElement(childrenPlus).click();
			}
			Thread.sleep(2000);
			for (int k = 0; k <= 2; k++) {
				driver.findElement(infantsPlus).click();
			}
			Thread.sleep(2000);
			driver.findElement(classEco).click();
			driver.findElement(adultEconomy2).click();
			reportPass("Adult & Economy is clicked");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		try {
			driver.findElement(from).sendKeys("Bhubaneswar");
			Thread.sleep(2000);
			driver.findElement(bbsr).click();
			Thread.sleep(2000);
			driver.findElement(to).sendKeys("Bangalore");
			Thread.sleep(2000);
			driver.findElement(bangalore).click();
			Thread.sleep(2000);

			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("window.scrollBy(0,250)");
			Thread.sleep(2000);
			reportPass("From & to are clicked");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		try {
			driver.findElement(date).click();
			driver.findElement(fromDate).click();
			Thread.sleep(2000);
			driver.findElement(toDate).click();
			Thread.sleep(2000);
			reportPass("From and To date are clicked");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

		try {
			driver.findElement(search).click();
			Thread.sleep(7000);
			reportPass("search buttton is clicked");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

}
