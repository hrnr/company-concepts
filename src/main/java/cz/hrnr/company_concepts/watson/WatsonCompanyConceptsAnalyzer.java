package cz.hrnr.company_concepts.watson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concept;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keyword;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;

import cz.hrnr.company_concepts.annotator.Company;
import cz.hrnr.company_concepts.annotator.CompanyConceptsAnalyzer;

/**
 * Uses IBM watson REST api to get the most relevant concepts (keywords) for
 * company. Curently uses solely company's webpage (url) to extract keywords.
 *
 */
public class WatsonCompanyConceptsAnalyzer implements CompanyConceptsAnalyzer {
	AlchemyLanguage service;

	public WatsonCompanyConceptsAnalyzer(Credentials credentials) {
		service = new AlchemyLanguage(credentials.getApikey());
	}

	/**
	 * Filters keywords with several heuristic approches to get the most
	 * relevant ones.
	 *
	 * @param keywords
	 *            keywords sorted by relevance
	 * @return filtered keywords
	 */
	private List<String> filterKeywords(String companyName, List<String> keywords) {
		return keywords.stream()
				// filter away keywords too similar to company name
				.filter(x -> StringUtils.getLevenshteinDistance(companyName, x, 2) == -1)
				// badly recognized keywords
				.filter(x -> !x.contains("\n")).filter(x -> !x.contains("\t"))
				// remove duplicates
				.distinct()
				// limit to 20 keywords (hard limit)
				.limit(20).collect(Collectors.toList());
	}

	@Override
	public List<String> analyzeCompanyConcepts(Company company) {
		List<String> keywords = new ArrayList<>();
		Map<String, Object> params = new HashMap<>();
		params.put(AlchemyLanguage.URL, company.getUrl());

		Concepts concepts = service.getConcepts(params).execute();
		if (concepts == null) {
			return null;
		}
		for (Concept concept : concepts.getConcepts()) {
			keywords.add(concept.getText());
		}

		Keywords keywords2 = service.getKeywords(params).execute();
		if (keywords2 == null) {
			return null;
		}
		for (Keyword keyword : keywords2.getKeywords()) {
			keywords.add(keyword.getText());
		}

		// final filtering
		return filterKeywords(company.getName(), keywords);
	}

}
