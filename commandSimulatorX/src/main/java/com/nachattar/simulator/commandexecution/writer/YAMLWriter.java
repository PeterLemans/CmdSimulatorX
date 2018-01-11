package com.nachattar.simulator.commandexecution.writer;
import java.util.Map;

/**
 * The interface <code>YAMLWriter</code> defines the contract for writing command execution yaml files.
 * @author  Deed Singh (deedsing)
 * @version %I%, %G%
 */
public interface YAMLWriter {

	 /**
    *
    * Returns <tt>Boolean</tt> True or False which gives the success and failure for the operation.
    * @param yamlFile
    *        yaml file which is to be processed
    * @param map
    *        Java map object that will be converted to yaml and written to the file.    
    * @return Boolean
    *         Returns <tt>Boolean</tt> True or False which gives the success and failure for the operation.n
    * @throws YAMLWriterException
    *         If any exception occurs when performing the writing operation.
    */
	public boolean dumpYaml(Map<String,Object> map,String yamlFile) throws YAMLWriterException ;
}
