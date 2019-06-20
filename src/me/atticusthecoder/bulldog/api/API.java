package me.atticusthecoder.bulldog.api;

import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import me.atticusthecoder.bulldog.Main;
import me.atticusthecoder.bulldog.common.Module;

public class API extends Module {
	
	public API() {
		super("API", "Atticus Zambrana");
	}
	
	public void onLoad() {
		// for each server the bot is registered in...
		for(Server server : Main.getBot().getApi().getServers()) {
			// for each user that said server has...
			for(User user : server.getMembers()) {
				System.out.println("Hello there " + user.getName());
			}
		}
	}
	
}
