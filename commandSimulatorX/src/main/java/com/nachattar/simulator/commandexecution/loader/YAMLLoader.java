package com.nachattar.simulator.commandexecution.loader;

import java.util.Map;

import org.json.JSONObject;

/**
 * The interface <code>YAMLLoader</code> defines the contract for reading command execution yaml files and creating an in memory database of commands with multiple states
 *
 * @author  Deed Singh (deedsing)
 * @version %I%, %G%
 */
public interface YAMLLoader {

	 /**
    *
    * Returns <tt>JSONObject</tt> which contains list of commands that is to be used for simulation
    * @param yamlFile
    *        yaml file which is to be processed
    * @return JSONObject
    *          Returns <tt>JSONObject</tt> which contains list of commands that is to be used for simulation
    * @throws YAMLLoaderException
    *         If any exception occurs when loading/reading the yaml file
    */
	public JSONObject getJSONFromYaml(String yamlFile) throws YAMLLoaderException ;
	
	 /**
    *
    * Returns <tt>Map<String,Object></tt> which contains map of commands that is to be used for simulation
    * @param yamlFile
    *        yaml file which is to be processed
    * @return Map<String,Object>
    *          Returns <tt>Map<String,Object></tt> which contains map of commands that is to be used for simulation
    * @throws YAMLLoaderException
    *         If any exception occurs when loading/reading the yaml file
    */
	public Map<String,Object> getMapFromYaml(String yamlFile) throws YAMLLoaderException ;
}
