package haardikgoswami.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import hardikgoswami.Abstract.AbstractData;

public class loggerData {

	public Logger getLog() {
		// TODO Auto-generated method stub
		Logger log = (Logger) LogManager.getLogger(AbstractData.class.getName());
		return log;
	}
}
