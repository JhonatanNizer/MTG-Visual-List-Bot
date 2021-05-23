package com.jnizer.mtgvisuallist.app;

import java.io.File;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



public class CommandListener extends ListenerAdapter {

    final protected String prefix = "!visual";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        String message = event.getMessage().getContentRaw();
        if (message.startsWith(prefix)) {
            Regex regex = new Regex();
            regex.createDeckFromRegex(message);
            event.getChannel().sendMessage("Here is your list!").queue();
        }
    }

}
