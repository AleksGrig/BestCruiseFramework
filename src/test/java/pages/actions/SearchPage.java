package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import enums.By;
import pages.locators.SearchPageLocators;
import testcases.BaseTest;

public class SearchPage {

	private final SearchPageLocators searchLocators = new SearchPageLocators();

	private SearchPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(BaseTest.getDriver(), 15), searchLocators);
	}

	public static SearchPage load() {
		return new SearchPage();
	}

	public SearchPage sort(By by) {
		searchLocators.sortDrop.click();
		by.choose(searchLocators);
		return this;
	}

	public SingleCruisePage loadFirst() {
		searchLocators.firstCruiseLink.click();
		return SingleCruisePage.load();
	}

	public boolean isFirstCruiseCheaperThan(double priceLimit) {
		double price = Double.parseDouble(searchLocators.firstPriceTag.getText().split(" ")[0]);
		if (price < priceLimit) {
			return true;
		}
		return false;
	}
}
