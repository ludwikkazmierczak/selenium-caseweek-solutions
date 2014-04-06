package pl.caseweek.pageobjects;

import java.util.List;

/**
 * Created by Ludwik on 06.04.14.
 */
public interface SearchEngine {

	/**
	 * Search functionality - type phrase to search, and click search button, after that wait for search result
	 * @param searchTerm
	 */
	public void search(String searchTerm);

	/**
	 * Get search results headings
	 * @return List of headings from search results
	 */
	public List<String> getSearchHeadings()

}
