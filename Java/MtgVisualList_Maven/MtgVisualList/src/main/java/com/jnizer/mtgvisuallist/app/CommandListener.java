package com.jnizer.mtgvisuallist.app;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                //Regex regex = new Regex();
                //regex.createDeckFromRegex(message);
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage("Here is your card:").addFile(ImageManager.getCardImage(message)).queue();
            } catch (IOException ex) {
                Logger.getLogger(CommandListener.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }

}
