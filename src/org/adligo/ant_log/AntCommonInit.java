package org.adligo.ant_log;

import org.adligo.i.log.client.I_LogFactory;
import org.adligo.i.log.client.Log;
import org.adligo.i.log.client.LogFactory;
import org.adligo.i.log.client.LogPlatform;
import org.adligo.i.util.client.StringUtils;
import org.adligo.jse.util.JSEPlatform;
import org.apache.tools.ant.Task;

public class AntCommonInit {
	private static final Log log = LogFactory.getLog(AntCommonInit.class);
	private static I_LogFactory FACTORY;
	
	
	public static void initOrReload(String configFile, String message, Task task) throws Exception {
		log.warn(message);
		if (StringUtils.isEmpty(configFile)) {
			configFile = "adligo_log.properties";
		}
		if (FACTORY == null) {
			FACTORY = new AntLogFactory();
			JSEPlatform.init();
			
			AntLogFactory.setCurrentTask(task);
			LogPlatform.init(configFile, FACTORY);
		} else {
			AntLogFactory.setCurrentTask(task);
			LogPlatform.resetLevels(configFile);
		}
		
		
	}
	
}
