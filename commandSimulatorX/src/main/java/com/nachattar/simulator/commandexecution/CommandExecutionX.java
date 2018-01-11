package com.nachattar.simulator.commandexecution;

import java.util.Map;

import com.nachattar.simulator.commandexecution.loader.YAMLLoader;
import com.nachattar.simulator.commandexecution.loader.YAMLLoaderException;
import com.nachattar.simulator.commandexecution.loader.YAMLLoaderImpl;
import com.nachattar.simulator.commandexecution.writer.YAMLWriter;
import com.nachattar.simulator.commandexecution.writer.YAMLWriterException;
import com.nachattar.simulator.commandexecution.writer.YAMLWriterImpl;

public class CommandExecutionX {

	@SuppressWarnings("unchecked")
	public  void startSimulatorX(String command,String yamlFile) throws YAMLWriterException, YAMLLoaderException {
		
	
	    	System.out.println("Command provided: " +command);
	    	
		   //Load the Yaml file
		   YAMLLoader loader = new YAMLLoaderImpl();
	       Map<String,Object> map= loader.getMapFromYaml(yamlFile);
		    
	       //Extract information from the map object.
	       Map<String, Object> out =  (Map<String, Object>) map.get(command);
	       CommandOutputBO bo = null ;
	       
	       if(out!=null) {
	    	int  executeKey= (Integer)out.get("ExecuteKey");
	   	    Map<String, Object> values =  (Map<String, Object>) out.get("Values");
	   	    Map<String, Object> value =  (Map<String, Object>) values.get(executeKey);
	   	    bo = new CommandOutputBO((String)value.get("Output"), (Integer)value.get("SystemRC"), (String)value.get("Result"), (String)value.get("Error"));
	   	    System.out.println("Values Size"+ values.size());
	   	    System.out.println(bo.toString());
	   	    if(executeKey<(values.size()-1))
	   	    	out.put("ExecuteKey", ++executeKey);
	   	    else
	   	    	out.put("ExecuteKey", 0);
	   	    System.out.println(out.toString());
	   	    map.put(command, out);
	    	   	   
	    	   
	       }else {
	    	   System.err.println("Command "+command +" Not declared in the Yaml file");
	    	   System.exit(123);
	       }
		    
	       //dump the modified YAML execution key.
	       YAMLWriter writer = new YAMLWriterImpl();
	       writer.dumpYaml(map, yamlFile);
	     
		    System.out.println("Finala output ...................................");
		    processCommand(bo);
		    
	}

	private static void processCommand(CommandOutputBO bo) {
		if(bo.getError()!=null)
			System.err.println(bo.getError());
		if(bo.getOutput()!=null)
			System.out.println(bo.getOutput());
		System.exit(bo.getSystemRC());
		
	}
	
}
