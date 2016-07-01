package cz.hrnr.company_concepts.junit;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

import cz.hrnr.company_concepts.annotator.CompanyConceptsAnalyzer;
import cz.hrnr.company_concepts.annotator.JSONAnnotator;
import cz.hrnr.company_concepts.watson.Credentials;
import cz.hrnr.company_concepts.watson.CredentialsUtils;
import cz.hrnr.company_concepts.watson.WatsonCompanyConceptsAnalyzer;

public class JSONAnnotatorTest {

	@Test
	public void testAnnotateCompanies() throws IOException {
		Credentials credentials = CredentialsUtils.parseJSON(new File("credentials.json").toPath());
		Reader reader = new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("input.json"));

		OutputStream outputStream = new ByteArrayOutputStream();
		Writer writer = new OutputStreamWriter(outputStream);

		CompanyConceptsAnalyzer analyzer = new WatsonCompanyConceptsAnalyzer(credentials);
		JSONAnnotator annotator = new JSONAnnotator(analyzer);
		// actual method
		annotator.annotateCompanies(reader, writer);

		String result = outputStream.toString();

		assertNotNull(result != null);
		assertTrue(result.length() > 0);
		assertTrue(result.contains("Gmail"));
		assertTrue(result.contains("Mark Hurd"));
	}

}
