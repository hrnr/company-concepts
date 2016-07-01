package cz.hrnr.company_concepts.annotator;

import java.util.List;

/**
 * Retrieves keywords that describes company business
 */
public interface CompanyConceptsAnalyzer {
	public List<String> analyzeCompanyConcepts(Company company);
}
