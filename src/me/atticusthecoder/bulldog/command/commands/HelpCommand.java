package me.atticusthecoder.bulldog.command.commands;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.exception.MissingPermissionsException;
import org.javacord.api.util.logging.ExceptionLogger;

import me.atticusthecoder.bulldog.Main;
import me.atticusthecoder.bulldog.common.Command;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("help", "See all commands the bot has to offer");
	}

	@Override
	public void execute(MessageCreateEvent event) {
		EmbedBuilder embed = new EmbedBuilder();
		
		embed.setTitle("My command list");
		
		for(Command cmd : Main.getBot().cm.getCommandList()) {
			embed.addField(Main.getBot().cm.PREFIX + cmd.getCommandName(), cmd.getCommandDescription());
		}
		
		event.getChannel().sendMessage(embed).exceptionally(ExceptionLogger.get(MissingPermissionsException.class));
	}

}
