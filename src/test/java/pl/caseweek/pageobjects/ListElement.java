package pl.caseweek.pageobjects;


/**
 * This interface connected with single list element functionality, prepared for CaseWeek 2014 Selenium workshop
 * Created by Ludwik on 06.04.14.
 */
public interface ListElement {

	/**
	 * Remove element from the list
	 * @return ListElement object
	 */
	public <E extends ListElement> E remove();

	/**
	 * Show / hide link input field
	 * @return ListElement object
	 */
	public <E extends ListElement> E toggleLinks();

	/**
	 * Type value into 'title' input field
	 * @param title
	 * @return
	 */
	public <E extends ListElement> E typeTitle(String title);

	/**
	 * Type value into 'link' input field
	 * @param url
	 * @return
	 */
	public <E extends ListElement> E typeLink(String url);

	/**
	 * Get value from 'title' input field
	 * @return value of 'title' input field
	 */
	public String getTitle();

	/**
	 * Get value fromm 'link' input field
	 * @return value of 'link' input field
	 */
	public String getUrl();

	/**
	 * Check if 'link' input field is visible
	 * @return true if link input is visible, false otherwise
	 */
	public boolean isLinkVisible();

	/**
	 * Check if an expected text is shown in autocomplete box
	 * @param expectedToSeeInAutocomplete - value expected to be present in autocomplete box
	 * @return true if expected text is visible in autocomplete box, false if NOT
	 */
	public boolean autocompleteContains(String expectedToSeeInAutocomplete);
}
