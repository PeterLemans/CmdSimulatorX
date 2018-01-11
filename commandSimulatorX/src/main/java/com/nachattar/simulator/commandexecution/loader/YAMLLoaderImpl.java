package com.nachattar.simulator.commandexecution.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

/**
 * The class <code>YAMLLoaderImpl</code> defines the implementation for reading command execution yaml files and creating an in memory database of commands with multiple states
 *
 * @author  Deed Singh (deedsing)
 * @version %I%, %G%
 */
public class YAMLLoaderImpl implements YAMLLoader {
	private static Logger log = Logger.getLogger(YAMLLoaderImpl.class);
	
	/**
     * @inheritDoc
     *
     * This method is the implementation for {@link YAMLLoader}.
     */
	@SuppressWarnings("unchecked")
	public JSONObject getJSONFromYaml(String yamlFile) throws YAMLLoaderException {
		Yaml yaml = new Yaml();

		Map<String, Object> map;
		try {
			map = (Map<String, Object>) yaml.load(new FileInputStream(new File(yamlFile)));
			log.debug("Command File Content: \n"+ yaml.dump(map));
		} catch (Exception e) {
		   throw new YAMLLoaderException(e.getMessage(),e.getCause());
			
		}

		JSONObject jsonObject = new JSONObject(map);
		return jsonObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getMapFromYaml(String yamlFile) throws YAMLLoaderException {
		Yaml yaml = new Yaml();

		Map<String, Object> map;
		try {
			map = (Map<String, Object>) yaml.load(new FileInputStream(new File(yamlFile)));
			log.debug("Command File Content: \n"+ yaml.dump(map));
		} catch (Exception e) {
		   throw new YAMLLoaderException(e.getMessage(),e.getCause());
			
		}
		
		return map;
	}

}
