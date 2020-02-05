package testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.DataProviders;

public class SingleCruiseTest extends BaseTest {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "dp")
	public void singleCruiseTest(HashMap<String, String> data) {
		driver.get(data.get("link"));
		double price = Double.parseDouble(driver.findElement(By.id(data.get("priceTag"))).getText().split(" ")[0]);
		double priceLimit = Double.parseDouble(data.get("priceLimit"));
		String cruiseName = data.get("cruiseName");
		if (price < priceLimit) {
			Assert.fail(cruiseName + " inside range!!!. Price is " + price + ", limit is " + priceLimit);
		}
	}
}