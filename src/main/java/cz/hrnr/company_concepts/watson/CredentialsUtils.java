package cz.hrnr.company_concepts.watson;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import com.google.gson.Gson;

public class CredentialsUtils {
	public static Credentials parseJSON(Path path) throws IOException {
		try (FileReader reader = new FileReader(path.toFile())) {
			Gson parser = new Gson();
			Credentials credentials = parser.fromJson(reader, Credentials.class);

			return credentials;
		} catch (IOException e) {
			throw new IOException(e);
		}
	}
}
