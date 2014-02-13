package org.adligo.ant_log;

import org.adligo.i.log.shared.I_LogFactory;
import org.adligo.i.log.shared.Log;
import org.adligo.i.log.shared.LogFactory;
import org.adligo.i.log.shared.LogPlatform;
import org.adligo.i.util.shared.StringUtils;
import org.adligo.jse.util.JSEPlatform;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public class AntCommonInit {
	private static final Log log = LogFactory.getLog(AntCommonInit.class);
	private static I_LogFactory FACTORY;
	
	
	public static void initOrReload(String configFile, String message, Task task) throws BuildException {
		log.warn(message);
		if (StringUtils.isEmpty(configFile)) {
			configFile = "adligo_log.properties";
		}
		
		if (FACTORY == null) {
			FACTORY = new AntLogFactory();
			try {
				JSEPlatform.init();
			} catch (Exception x) {
				throw new BuildException(x);
			}
			AntLogFactory.setCurrentTask(task);
			LogPlatform.init(configFile, FACTORY);
		} else {
			AntLogFactory.setCurrentTask(task);
			LogPlatform.resetLevels(configFile);
		}
		
		
	}
	
}
