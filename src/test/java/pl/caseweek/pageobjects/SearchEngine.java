package pl.caseweek.pageobjects;

import java.util.List;

/**
 * This interface connected with search engine functionality, prepared for CaseWeek 2014 Selenium workshop
 * Created by Ludwik and Yaci
 */
public interface SearchEngine {

	/**
	 * Search functionality - type phrase to search, and click search button, after that wait for search result
	 * @param searchTerm
	 */
	public <S extends SearchEngine> S search(String searchTerm);

	/**
	 * Get search results headings
	 * @return List of headings from search results
	 */
	public List<String> getSearchHeadings();

}
