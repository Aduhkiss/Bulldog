package me.atticusthecoder.bulldog;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

import me.atticusthecoder.bulldog.activity.ActivityManager;
import me.atticusthecoder.bulldog.api.API;
import me.atticusthecoder.bulldog.command.CommandManager;
import me.atticusthecoder.bulldog.common.Logger;
import me.atticusthecoder.bulldog.common.Multithreading;
import me.atticusthecoder.bulldog.common.util.DateUtil;

public class Bulldog {
	
	private String version = "0.1";
	private DiscordApi api;
	
	public CommandManager cm;
	private ActivityManager am;
	private API myApi;
	
	public Bulldog() {}
	
	public void start(String TOKEN) {
		Multithreading.runAsync(() -> {
			// Officially start the bot and load the code
			Logger.info("System", "Now starting Chris Hansen Bot v" + version + " By Atticus Zambrana");
	        // We login blocking, just because it is simpler and doesn't matter here
	        api = new DiscordApiBuilder().setToken(TOKEN).login().join();
	        
	        // Enable debugging, if no slf4j logger was found
	        FallbackLoggerConfiguration.setDebug(true);

	        // Print the invite url of the bot
	        Logger.info("System", "You can invite me by using the following url: " + api.createBotInvite());
	        
	        cm = new CommandManager();
	        am = new ActivityManager();
	        myApi = new API();
	        
	        api.addServerJoinListener(event -> {
	        	System.out.println("============================");
	        	System.out.println("I have joined " + event.getServer().getName());
	        	System.out.println("Server ID: " + event.getServer().getIdAsString());
	        	System.out.println("Time Joined: " + DateUtil.getNow());
	        	System.out.println("============================");
	        });
	        api.addServerLeaveListener(event -> {
	        	System.out.println("============================");
	        	System.out.println("I have left " + event.getServer().getName());
	        	System.out.println("Server ID: " + event.getServer().getIdAsString());
	        	System.out.println("Time Left: " + DateUtil.getNow());
	        	System.out.println("============================");
	        });
		});
	}
	
	public DiscordApi getApi() {
		return api;
	}
}
