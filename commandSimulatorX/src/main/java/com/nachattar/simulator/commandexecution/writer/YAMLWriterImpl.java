package com.nachattar.simulator.commandexecution.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import org.apache.log4j.Logger;
import org.yaml.snakeyaml.Yaml;

public class YAMLWriterImpl implements YAMLWriter {

	private Logger log = Logger.getLogger(YAMLWriterImpl.class);
    
	/**
     * @inheritDoc
     *
     * This method is the implementation for {@link YAMLWriter}.
     */

	public boolean dumpYaml(Map<String, Object> map, String yamlFile) throws YAMLWriterException {
		Yaml yaml = new Yaml();
		try {
			yaml.dump(map, new PrintWriter(new File(yamlFile)));
			log.debug("Command File Content: \n"+ yaml.dump(map));
		} catch (FileNotFoundException e) {
			log.error(e);
			throw new YAMLWriterException(e.getMessage(), e);
		}
		return false;
	}

}
