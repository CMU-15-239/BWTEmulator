package edu.cmu.scripting;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.Map;

/**
 * A class used to find and load user scripts that reside
 * in ./scripts folder
 * @author ziw
 *
 */
public class ScriptLoader {

	private static final String SCRIPT_FOLDER_PATH = "./scripts";
	private static final String SCRIPT_EXTENSION = ".bwt";

	private File scriptsFolder;//the root folder that holds all scripts
	
	public ScriptLoader(){
		checkAndCreateFolder();
	}

	private void checkAndCreateFolder(){
		File f = new File(SCRIPT_FOLDER_PATH);
		if(!f.exists() ||  !f.isDirectory()){
			f.mkdir();
		}
		scriptsFolder = f;
	}
	
	public Map<String, String> getScriptsContents(){
		Map<String, String> m = new HashMap<String,String>();
		String[] allScripts = scriptsFolder.list(new FilenameFilter(){

			@Override
			public boolean accept(File dir, String name) {
				return name!= null && name.endsWith(SCRIPT_EXTENSION);
			}
			
		});
		
		for(String scriptName : allScripts){
			Map<Integer, String> result = ScriptParser.parseScript(scriptName);
			String status = result.get(ScriptParser.STATUS_KEY);
			String message = result.get(ScriptParser.MESSAGE_KEY);
			if(status == null || !status.equals(ScriptParser.SUCCESS)){
				m.put(scriptName, prepareErrorMsg(message));
			}
			else{
				m.put(scriptName, message);
			}
			
		
		}
		
		
		
		return m;
	}
	
	private String prepareErrorMsg(String message){
		return null;
	}
	
	public static void main(String[] args){
		ScriptLoader s = new ScriptLoader();
		s.getScriptsContents();
	}
	
}

