package utils.helper;

import java.util.ArrayList;
import java.util.List;

public class Logger {
	private static String sMethodName;
	private static String sClasName;
	private static List<String> currentLogs = new ArrayList<String>();
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(Logger.class);	
	public static List<String> getCurrentLogs() {
		return currentLogs;
	}
	public static void info(String message) {
		saveLog(message);
		log.info(message);
	}
	private static void saveLog(String message) {
		String currentMethod = Thread.currentThread().getStackTrace()[3].getMethodName();
		String currentClass = Thread.currentThread().getStackTrace()[3].getClassName();
		
		if (!currentMethod.equals(sMethodName)
				|| (currentMethod.equals(sMethodName) && !currentClass.equals(sClasName))) {
			currentLogs.clear();
		}
		sMethodName = currentMethod;
		sClasName = currentClass;
		currentLogs.add(message);
	}
}
