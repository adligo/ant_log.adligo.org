package org.adligo.ant_log;

import org.adligo.i.log.client.SimpleLog;
import org.adligo.i.util.client.I_ImmutableMap;


public class AntLogger extends SimpleLog  {

	public AntLogger(String name, I_ImmutableMap props) {
		super(name, props);
	}
	
	@Override
	protected void print(String p) {
		// TODO Auto-generated method stub
		super.print(p);
		AntLogFactory.getCurrentTask().log(p);
	}
}
