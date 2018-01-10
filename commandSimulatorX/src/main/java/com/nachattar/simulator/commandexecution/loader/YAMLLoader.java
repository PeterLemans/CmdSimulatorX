package com.nachattar.simulator.commandexecution.loader;

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
    * @param nodeToExtract
    *        Xml element/node from where the data needs to be extracted
    * @return JSONObject
    *          Returns <tt>JSONObject</tt> which contains list of commands that is to be used for simulation
    * @throws XmlParserException
    *         If any exception occurs when the xml file is porcessed for data
    */
	public JSONObject getJSONFromYaml(String yamlFile) throws YAMLLoaderException ;
}
