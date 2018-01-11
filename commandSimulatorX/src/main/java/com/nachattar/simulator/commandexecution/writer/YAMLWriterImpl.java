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
	@Override
	public boolean dumpYaml(Map<String, Object> map, String yamlFile) throws YAMLWriterException {
		log.debug("YAML Writer Starting ...");
		Yaml yaml = new Yaml();
		try {
			yaml.dump(map, new PrintWriter(new File(yamlFile)));
		} catch (FileNotFoundException e) {
			log.error(e);
			throw new YAMLWriterException(e.getMessage(), e);
		}
		return false;
	}

}
