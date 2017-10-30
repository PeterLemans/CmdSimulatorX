package com.nachattar.simulator.commandexecution;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import au.com.bytecode.opencsv.CSVReader;

public class ReadCSV {

	final  Logger log = Logger.getLogger(ReadCSV.class);

	public Map<String, Map<String, String>> readCSV(String csvFile) {

		log.debug("Inside read csv file.");
		// read the csv file and creates a Map
		File file1 = new File(csvFile);
		Map<String, Map<String, String>> out = new HashMap<String, Map<String, String>>();
		String[] header = null;
		try {

			// Build reader instance
			CSVReader reader = new CSVReader(new FileReader(file1), ',', '"', '\n', 0, true, true);

			// Read all rows at once
			List<String[]> allRows = reader.readAll();

			// Read CSV line by line and use the string array as you want
			for (String[] row : allRows) {

				if (header == null) {
					
					header = row.clone();
					log.debug("FILE HEADER --> \n"+Arrays.toString(header));
				} else {
					Map<String, String> map = new HashMap<String, String>();
					for (int i = 0; i < row.length; i++) {
						map.put(header[i], row[i]);
					}
					out.put(map.get("COMMAND"), map);

				}
			}
			log.debug("DATA --> \n" +out);
		} catch (IOException e) {
			log.error(e);
			System.exit(2);
		}

		return out;
	}

}
