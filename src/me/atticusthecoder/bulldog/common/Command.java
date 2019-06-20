package me.atticusthecoder.bulldog.common;

import org.javacord.api.event.message.MessageCreateEvent;

public abstract class Command {
	private String commandName;
	private String description;
	
	public Command(String commandName, String description) {
		this.commandName = commandName;
		this.description = description;
		Logger.info("Command Manager", "Registered command " + getCommandName());
	}
	
	public abstract void execute(MessageCreateEvent event);
	
	public String getCommandName() {
		return commandName;
	}
	
	public String getCommandDescription() {
		return description;
	}
}
