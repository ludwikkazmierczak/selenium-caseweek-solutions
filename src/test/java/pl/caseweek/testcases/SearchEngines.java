package pl.caseweek.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pl.caseweek.pageobjects.searchengines.Baidu;
import pl.caseweek.pageobjects.searchengines.Goo;
import pl.caseweek.templates.TestTemplate;

public class SearchEngines extends TestTemplate {

	@Test
	public void searchInBaidu() {
		Baidu baidu = new Baidu(driver);
		baidu.get()
		.search("cognifide");

		List<String> headings = baidu.getSearchHeadings();
		Assert.assertEquals(headings.get(0), "Cognifide");
	}

	@Test
	public void searchInGoo() {
		Goo goo = new Goo(driver);

		goo.get()
		.search("cognifide");

		List<String> headings = goo.getSearchHeadings();
		Assert.assertEquals(headings.get(0), "Cognifide");

	}

}
