package com.jnizer.mtgvisuallist.app;

import com.jnizer.mtgvisuallist.resource.Deck;
import java.io.IOException;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {

    final protected String prefix = "!visual";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String rawMessage = event.getMessage().getContentRaw();
        String message = rawMessage.substring(prefix.length());
        if (rawMessage.startsWith(prefix)) {
            try {
                DeckBiulder deckBiulder = new DeckBiulder();
                Deck deck = deckBiulder.biuldDeckFromMessage(message);
                
                if (deck == null || deck.getMainDeck().size() < 60) { throw new IOException(); }
                //event.getChannel().sendTyping().queue();
                //event.getChannel().sendMessage("Here is your card:").addFile(ImageManager.getCardImage(message)).queue();
            } catch (IOException ex) {
                event.getChannel().sendMessage("Error loading visual list").queue();
            }            
        }
    }

}
