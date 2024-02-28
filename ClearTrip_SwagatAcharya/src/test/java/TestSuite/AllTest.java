package TestSuite;

import org.testng.annotations.Test;

import Base.Base;
import Pages.FlightsPage;
import Pages.HotelPage;
import Pages.OffersPage;

public class AllTest extends Base {

	FlightsPage fPage = new FlightsPage();
	HotelPage hPage = new HotelPage();
	OffersPage oPage= new OffersPage();

	@Test
	public void test() {
		fPage.openUrl();
		fPage.flightsPage();
		hPage.openUrl();
		hPage.hotelPage();
		
	}

}
