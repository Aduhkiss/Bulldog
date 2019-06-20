package me.atticusthecoder.bulldog.command.commands;

import java.util.Random;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import me.atticusthecoder.bulldog.common.Command;

public class CoinFlipCommand extends Command {
	
	public CoinFlipCommand() {
		super("coinflip", "Flip a coin");
	}

	@Override
	public void execute(MessageCreateEvent event) {
		Random rand = new Random();
		int n = rand.nextInt(2);
		n += 1;
		// Between 1 and 2;
		
		if(n == 1) {
			EmbedBuilder embed = new EmbedBuilder()
					.setTitle("Coin flipped!")
					.addField("The coin was...", "Heads!");
			
			event.getChannel().sendMessage(embed);
			return;
		}
		if(n == 2) {
			EmbedBuilder embed = new EmbedBuilder()
					.setTitle("Coin flipped!")
					.addField("The coin was...", "Tails!");
			
			event.getChannel().sendMessage(embed);
			return;
		}
		
		// An error has occured
		EmbedBuilder embed = new EmbedBuilder()
				.setTitle("This shouldn't happen...")
				.addField("There was an error while parsing the request!", "Error code: #CO-56FS23A");
		
		event.getChannel().sendMessage(embed);
		return;
	}
	
	

}
