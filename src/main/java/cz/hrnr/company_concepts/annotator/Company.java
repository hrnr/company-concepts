package cz.hrnr.company_concepts.annotator;

import java.net.URL;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Company {
	private String name;
	private URL url;
	private List<String> keywords;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
