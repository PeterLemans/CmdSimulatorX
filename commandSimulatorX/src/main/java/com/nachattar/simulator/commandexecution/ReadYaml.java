package com.nachattar.simulator.commandexecution;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import com.nachattar.simulator.commandexecution.loader.YAMLLoaderImpl;
public class ReadYaml {

 
  public static void main(String[] args) throws CommandSimulatorException {

	 YAMLLoaderImpl loaderImpl = new YAMLLoaderImpl();
	 Map<String, Object> data = new HashMap<String, Object>();
	 try {
		JSONObject json = loaderImpl.getJSONFromYaml("src/main/resources/ExecuteCommand.yaml");
		//System.out.println(json.toString());
	    JSONArray jsonArray= json.getJSONArray("Commands");
	    
	    for(Object a : jsonArray) {
	    	if(a!=null) {
	    		JSONObject jsonObject = (JSONObject) a;
	    		String key = jsonObject.get("Command").toString();
	    		data.put(key, jsonObject);
	    	}
	    	
	    	
	    }
	    System.out.println("Loaded Data ----------------");
	    	//data.forEach((k,v)->System.out.println( k + ": "+ v));
	    	
	    	String command="df /root |tr -s ' ' |cut -d' ' -f5|tail -n1";
	    System.out.println("Command provided: " +"df /root |tr -s ' ' |cut -d' ' -f5|tail -n1");
	    
	    JSONObject out = (JSONObject) data.get(command);
	    int  executeKey= out.getInt("ExecuteKey");
	
	    System.out.println(out.getJSONObject("Values").getJSONObject((Integer.toString(executeKey))));
	    out.put("ExecuteKey", ++executeKey);
	    System.out.println(out.toString());
	} catch (Exception e) {
       throw new CommandSimulatorException(e);
	}
	 
}
	
}
