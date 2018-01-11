package com.nachattar.simulator.commandexecution;

import java.util.Map;
import org.apache.log4j.Logger;
import com.nachattar.simulator.commandexecution.loader.YAMLLoader;
import com.nachattar.simulator.commandexecution.loader.YAMLLoaderException;
import com.nachattar.simulator.commandexecution.loader.YAMLLoaderImpl;
import com.nachattar.simulator.commandexecution.writer.YAMLWriter;
import com.nachattar.simulator.commandexecution.writer.YAMLWriterException;
import com.nachattar.simulator.commandexecution.writer.YAMLWriterImpl;

public class CommandExecutionX {

	private  Logger log = Logger.getLogger(CommandExecutionX.class);
	@SuppressWarnings("unchecked")
	public  void startSimulatorX(String command,String yamlFile) throws YAMLWriterException, YAMLLoaderException, CommandSimulatorException {
		
	
	    	log.info("Command Input: '" +command+"'");
	    	log.info("Command File: '" +yamlFile+"'");
	    	
		   //Load the Yaml file
	    	log.debug("Loading the command file ...");
		   YAMLLoader loader = new YAMLLoaderImpl();
	       Map<String,Object> map= loader.getMapFromYaml(yamlFile);
	       log.info("Command File Successfully Loaded");
		    
	       //Extract information from the map object.
	       Map<String, Object> out =  (Map<String, Object>) map.get(command);
	       CommandOutputBO bo = null ;
	       
	       if(out!=null) {
	    	 log.debug("Command '"+command +"' is available in the command file");
	    	int  executeKey= (Integer)out.get("ExecuteKey");
	    	boolean simulationEnabled = (Boolean)out.get("SimulationEnabled");
	    	if(simulationEnabled) {
	    	log.info("Command Simulation is enabled.");	
	    	log.debug("ExecuteKey: "+executeKey);
	   	    Map<String, Object> values =  (Map<String, Object>) out.get("Values");
	   	    Map<String, Object> value =  (Map<String, Object>) values.get(executeKey);
	   	    log.debug("Available Values: \n"+values.toString());
	   	    log.debug("Selected Value based on ExecuteKey: \n"+value.toString());
	   	    log.debug("Creating CommandOutputBO ...");
	   	    bo = new CommandOutputBO((String)value.get("Output"), (Integer)value.get("SystemRC"), (String)value.get("Result"), (String)value.get("Error"));
	 
	   	    log.debug("CommandOutputBO --> "+bo.toString());
	   	    if(executeKey<(values.size()-1))
	   	    	out.put("ExecuteKey", ++executeKey);
	   	    else
	   	    	out.put("ExecuteKey", 0);
	   	    map.put(command, out);
	    	}else {
	    		log.error("Command Simulation is disabled.");	
	    		throw new CommandSimulatorException("Simulation is not enabled for the command: '"+command+"'");
	    	}   	   
	    	   
	       }else {
	    	   log.error("Command "+command +" Not declared in the Yaml file");
	    	   throw new CommandSimulatorException("Command "+command +" Not declared in the Yaml file");
	    	
	       }
		    
	       log.debug("Updating ExecuteKey to the command file ...");
	       YAMLWriter writer = new YAMLWriterImpl();
	       writer.dumpYaml(map, yamlFile);
	       log.debug("ExecuteKey updated in the command file.");
	     
		   log.info("Final Output -->");
		    processCommand(bo);
		    
	}

	private  void processCommand(CommandOutputBO bo) {
		if(bo.getError()!=null)
			System.err.println(bo.getError());
		if(bo.getOutput()!=null)
			System.out.println(bo.getOutput());
		log.info("Command Simulation Complete");
		System.exit(bo.getSystemRC());
		
	}
	
}
