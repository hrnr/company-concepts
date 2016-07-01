package cz.hrnr.company_concepts.junit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

import cz.hrnr.company_concepts.annotator.Company;
import cz.hrnr.company_concepts.watson.Credentials;
import cz.hrnr.company_concepts.watson.CredentialsUtils;
import cz.hrnr.company_concepts.watson.WatsonCompanyConceptsAnalyzer;

public class WatsonCompanyConceptsAnalyzerTest {

	@Test
	public void testAnalyzeCompanyConcepts() throws IOException {
		Credentials credentials = CredentialsUtils
				.parseJSON(new File(System.getProperty("watson.credentials")).toPath());

		Company company = new Company();
		company.setName("Google");
		company.setUrl(new URL("https://en.wikipedia.org/wiki/Google"));

		WatsonCompanyConceptsAnalyzer analyzer = new WatsonCompanyConceptsAnalyzer(credentials);
		List<String> concepts = analyzer.analyzeCompanyConcepts(company);

		assertNotNull(concepts);
		assertFalse(concepts.isEmpty());
		assertTrue(concepts.contains("Android"));
	}

}
