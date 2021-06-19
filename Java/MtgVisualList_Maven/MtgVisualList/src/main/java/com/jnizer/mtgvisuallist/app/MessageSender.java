package com.jnizer.mtgvisuallist.app;

import com.jnizer.mtgvisuallist.resource.Deck;
import java.io.IOException;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class MessageSender {

    public void SendMessage(GuildMessageReceivedEvent event, Deck deck) throws IOException { 
        event.getChannel()
                .sendMessage("Here is your list: ")
                .addFile(ImageManager.biuldImageToSend(deck))
                .queue();
    }
    
}
