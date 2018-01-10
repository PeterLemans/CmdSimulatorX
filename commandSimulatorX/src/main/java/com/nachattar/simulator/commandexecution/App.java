package com.nachattar.simulator.commandexecution;

import java.io.Console;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

public class App {

	private static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {
		log.info("Command Simulator Starting ...");

		// read the command line arguments

		String command = "";
		String file = "";
		
		Options options = new Options();
		Option csvFile = new Option("f", "csvFile", true, "csvFile");
		csvFile.setRequired(true);
		options.addOption(csvFile);

		Option c = new Option("c", "command", true, "command");
		c.setRequired(true);
		options.addOption(c);

		CommandLineParser parser = new DefaultParser();
		HelpFormatter formatter = new HelpFormatter();
		CommandLine cmd;
		Console console = System.console();
		if (console == null) {
			log.error("Couldn't get Console instance");
			// System.exit(1);
		}

		try {
			cmd = parser.parse(options, args);

			if (cmd.hasOption("f")) {
				file = ((String) cmd.getParsedOptionValue("f"));
			}

			if (cmd.hasOption("c")) {
				command = ((String) cmd.getParsedOptionValue("c"));
			}

		} catch (ParseException e) {
			log.debug(e.getMessage());
			formatter.printHelp("Command Simulator X", options);
         	System.exit(1);
			return;
		}

		//read the csv file
		ReadCSV csv = new ReadCSV();
		Map<String, Map<String, String>> out = csv.readCSV(file);
		log.info("Command: "+command);
		log.info("File: "+file);
		log.info("File load complete.");
		

		// get the command output
		if (out!=null) {
		Map<String, String> output = out.get(command);
		
		if(output!=null) {
		System.out.println(output.get("OUTPUT"));
		log.info("Command Simulator Finished.");
		if(output.get("ERROR")!=null&&!output.get("ERROR").isEmpty())
			System.err.println(output.get("ERROR"));
		System.exit(Integer.parseInt(output.get("SYSTEMRC")));
		}
		else 
			log.error("Unable to read file");
		
		}
	}

}
