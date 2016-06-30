package cz.hrnr.company_concepts;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ConsoleApplication {

	public static void main(String[] args) {
		Options options = new Options();
		Option credentials = Option.builder("c").required().hasArg()
				.desc("path to JSON file with API credentials for IBM Watson AlchemyAPI.").argName("credentials")
				.build();
		options.addOption(credentials);

		CommandLineParser parser = new DefaultParser();
		HelpFormatter helpFormatter = new HelpFormatter();
		try {
			CommandLine cmd = parser.parse(options, args);
			// this option is required
			String credentialsPath = cmd.getOptionValue("c");
			List<String> files = cmd.getArgList();
			if (files.size() != 2) {
				System.err.println("missing input or output file");
				throw new IllegalArgumentException();
			}
		} catch (ParseException | IllegalArgumentException e) {
			helpFormatter.printHelp("company_concepts [OPTIONS]... [INPUT FILE] [OUTPUT FILE]", options);
			System.exit(2);
		}

	}

}
