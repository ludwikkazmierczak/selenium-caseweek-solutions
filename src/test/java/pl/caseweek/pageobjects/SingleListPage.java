package pl.caseweek.pageobjects;

import org.openqa.selenium.WebElement;
import pl.caseweek.pageobjects.listgeeks.ListGeeksElement;

/**
 * This interface connected with 'single list' page functionality, prepared for CaseWeek 2014 Selenium workshop
 * Created by Ludwik and Yaci
 */
public interface SingleListPage {
	/**
	 * Get single element from the list by index
	 * @param itemIndex - index of an element you want to get
	 * @return ListElement
	 */
	public <L extends ListElement> L getListItem(int itemIndex);

	/**
	 * Change order of the list by dragging one element over the second area
	 * @param elementToDrag - dragable area of an element
	 * @param dropArea - drop area of an element to change order of en elements
	 */
	public void changeOrder(WebElement elementToDrag, WebElement dropArea);
}
