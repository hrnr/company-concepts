package cz.hrnr.company_concepts.annotator;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;

/**
 * Annotates JSON data of companies with keywords describing their business
 *
 */
public class JSONAnnotator {
	private CompanyConceptsAnalyzer analyzer;
	Gson parser;

	public JSONAnnotator(CompanyConceptsAnalyzer analyzer) {
		this.analyzer = analyzer;
		parser = new GsonBuilder().setPrettyPrinting().create();
	}

	public void annotateCompanies(Reader reader, Writer writer) throws IOException {
		Type companyListType = new TypeToken<List<Company>>() {
		}.getType();
		// read from json a retrieve relevant keywords for each company
		List<Company> companies = parser.fromJson(reader, companyListType);
		for (Company company : companies) {
			List<String> keywords = analyzer.analyzeCompanyConcepts(company);
			company.setKeywords(keywords);
		}

		// write out annotated companies with keywords
		try (JsonWriter jsonWriter = parser.newJsonWriter(writer)) {
			parser.toJson(companies, companyListType, jsonWriter);
		} catch (IOException e) {
			throw new IOException("could not write resulting JSON", e);
		}
	}
}
