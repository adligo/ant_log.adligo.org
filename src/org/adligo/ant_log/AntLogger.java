package org.adligo.ant_log;

import org.adligo.i.log.shared.SimpleLog;
import org.adligo.i.util.shared.I_ImmutableMap;


public class AntLogger extends SimpleLog  {

	public AntLogger(String name, I_ImmutableMap props) {
		super(name, props);
	}
	
	@Override
	protected void print(String p) {
		AntLogFactory.getCurrentTask().log(p);
	}
}
