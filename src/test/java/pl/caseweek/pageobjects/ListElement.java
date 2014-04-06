package pl.caseweek.pageobjects;

import org.openqa.selenium.WebElement;

/**
 * Created by Ludwik on 06.04.14.
 */
public interface ListElement {

	public <E extends ListElement> E remove();

	public <E extends ListElement> E toggleLinks();

	public <E extends ListElement> E typeTitle(String title);

	public <E extends ListElement> E typeLink(String url);

	public String getTitle();

	public String getUrl();

	public boolean isLinkVisible();

	public boolean autocompleteContains(String expectedToSeeInAutocomplete);
}
