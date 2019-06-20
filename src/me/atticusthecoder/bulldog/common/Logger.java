package me.atticusthecoder.bulldog.common;

public class Logger {
	public static void info(String module, String message) {
		System.out.println("[" + module + "]: " + message);
	}
}
