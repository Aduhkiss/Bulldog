package me.atticusthecoder.bulldog.command;

import java.util.ArrayList;
import java.util.List;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import me.atticusthecoder.bulldog.Main;
import me.atticusthecoder.bulldog.command.commands.CoinFlipCommand;
import me.atticusthecoder.bulldog.command.commands.HelpCommand;
import me.atticusthecoder.bulldog.command.commands.UserInfoCommand;
import me.atticusthecoder.bulldog.common.Command;
import me.atticusthecoder.bulldog.common.Module;
import me.atticusthecoder.bulldog.common.Multithreading;

public class CommandManager extends Module implements MessageCreateListener {

	public CommandManager() {
		super("Command Manager", "Atticus Zambrana");
	}
	
	private List<Command> commands;
	public final String PREFIX = ";";

	@Override
	public void onLoad() {
		Multithreading.runAsync(() -> {
			// Register commands
			Main.getBot().getApi().addMessageCreateListener(this);
			
			commands = new ArrayList<Command>();
			
			// Register commands
			commands.add(new HelpCommand());
			commands.add(new UserInfoCommand());
			commands.add(new CoinFlipCommand());
		});
	}
	
	public List<Command> getCommandList() {
		return commands;
	}

	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		Multithreading.runAsync(() -> {
			for(Command cmd : commands) {
				if(event.getMessageContent().toString().startsWith(PREFIX + cmd.getCommandName())) {
					cmd.execute(event);
				}
			}
		});
	}
	
}
