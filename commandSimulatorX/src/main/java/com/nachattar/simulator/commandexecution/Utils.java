package com.nachattar.simulator.commandexecution;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

public class Utils {

	@SuppressWarnings("unchecked")
	public JSONObject getJSONFromYaml(String yamlFile) throws FileNotFoundException {
		Yaml yaml = new Yaml();
	
		//System.out.println(yaml.dump(yaml.load(new FileInputStream(new File(yamlFile)))));

		    Map<String,Object> map= (Map<String, Object>)yaml.load(new FileInputStream(new File(
		    		yamlFile)));

		    JSONObject jsonObject=new JSONObject(map);
		    return jsonObject;
	}
	
	public boolean dumpJSONToYaml(String yamlFile) throws FileNotFoundException {
		Yaml yaml = new Yaml();
	
		//System.out.println(yaml.dump(yaml.load(new FileInputStream(new File(yamlFile)))));

		    Map<String,Object> map= (Map<String, Object>)yaml.load(new FileInputStream(new File(
		    		yamlFile)));

		    JSONObject jsonObject=new JSONObject(map);
		    return true;
	}
	
}
