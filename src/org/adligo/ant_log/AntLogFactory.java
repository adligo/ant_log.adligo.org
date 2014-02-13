package org.adligo.ant_log;

import org.adligo.i.log.shared.DefaultLogFactory;
import org.adligo.i.log.shared.I_LogDelegate;
import org.adligo.i.log.shared.LogPlatform;
import org.apache.tools.ant.Task;

/**
 * Note all i_log delegations to java.util.common have different level names for 
 * INFO and WARN(ING)
 * FINEST=TRACE
 * FINEER=DEBUG
 * FINE=INFO
 * INFO=WARN
 * WARNING=ERROR
 * SEVERE=FATAL
 * 
 * other than that just another delegation
 * 
 * @author scott
 *
 */
public class AntLogFactory extends DefaultLogFactory  {
	

	/**
	 * convention for logFactory=org.adligo.i.log.util.UtilLogFactory
	 * setting in adligo_log.properties
	 */
	public static final String LOG_FACTORY_NAME = AntLogFactory.class.getName();
	private static Task CURRENT_TASK;
	
	public static Task getCurrentTask() {
		return CURRENT_TASK;
	}

	public static void setCurrentTask(Task task) {
		CURRENT_TASK = task;
	}

	@Override
	public String getName() {
		return LOG_FACTORY_NAME;
	} 
	
	@Override
	protected I_LogDelegate createPostInitLogger(String clazz) {
		// TODO Auto-generated method stub
		return new AntLogger(clazz, LogPlatform.getProps());
	}
}
