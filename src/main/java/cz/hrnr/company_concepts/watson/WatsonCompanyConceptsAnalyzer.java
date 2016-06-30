package cz.hrnr.company_concepts.watson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concept;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keyword;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;

import cz.hrnr.company_concepts.annotator.Company;
import cz.hrnr.company_concepts.annotator.CompanyConceptsAnalyzer;

public class WatsonCompanyConceptsAnalyzer implements CompanyConceptsAnalyzer {
	AlchemyLanguage service;

	public WatsonCompanyConceptsAnalyzer(Credentials credentials) {
		service = new AlchemyLanguage(credentials.getApikey());
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
		return keywords;
	}

}
