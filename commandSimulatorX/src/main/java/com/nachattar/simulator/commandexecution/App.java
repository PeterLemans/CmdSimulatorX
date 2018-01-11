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

import com.nachattar.simulator.commandexecution.loader.YAMLLoaderException;
import com.nachattar.simulator.commandexecution.writer.YAMLWriterException;

public class App {

	private static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) throws YAMLWriterException, YAMLLoaderException {
		log.info("Command Simulator Starting ...");

		// read the command line arguments
	
		String command = "";
		String file = "";
		
		Options options = new Options();
		Option csvFile = new Option("f", "yamlFile", true, "yamlFile");
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

		CommandExecutionX simulatorX = new CommandExecutionX();
		simulatorX.startSimulatorX(command, file);
	}

}
