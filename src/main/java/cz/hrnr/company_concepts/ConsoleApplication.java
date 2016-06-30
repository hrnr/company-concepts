package cz.hrnr.company_concepts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import cz.hrnr.company_concepts.watson.Credentials;
import cz.hrnr.company_concepts.watson.CredentialsUtils;

public class ConsoleApplication {

	public static void main(String[] args) {
		Options options = new Options();
		Option credentialsOpt = Option.builder("c").required().hasArg()
				.desc("path to JSON file with API credentials for IBM Watson AlchemyAPI.").argName("credentials")
				.build();
		options.addOption(credentialsOpt);

		CommandLineParser parser = new DefaultParser();
		HelpFormatter helpFormatter = new HelpFormatter();
		String credentialsPath = null;
		List<String> files;
		Credentials credentials;
		try {
			CommandLine cmd = parser.parse(options, args);
			// this option is required
			credentialsPath = cmd.getOptionValue("c");
			files = cmd.getArgList();
			if (files.size() != 2) {
				System.err.println("missing input or output file");
				throw new IllegalArgumentException();
			}
		} catch (ParseException | IllegalArgumentException e) {
			helpFormatter.printHelp("company_concepts [OPTIONS]... [INPUT FILE] [OUTPUT FILE]", options);
			System.exit(2);
		}
		try {
			credentials = CredentialsUtils.parseJSON(new File(credentialsPath).toPath());
		} catch (FileNotFoundException e) {
			System.err.println("invalid credentials file");
			System.exit(3);
		}
	}

}
