package br.com.southsystem.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Log
 * 
 * @author marcioferoli <marcioferoli@gmail.com>
 * @version 1.0
 * @since 2020-05-07
 */
public class Log {

	private static final Logger LOGGER = Logger.getLogger(Log.class.getName());

	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
		LOGGER.setLevel(Level.WARNING);
	}

	public static void info(String message) {
		LOGGER.info(message);
	}

	public static void warning(String message) {
		LOGGER.warning(message);
	}

	public static void severe(Exception e) {
		LOGGER.severe(e.getMessage());
		e.printStackTrace();
	}

}
