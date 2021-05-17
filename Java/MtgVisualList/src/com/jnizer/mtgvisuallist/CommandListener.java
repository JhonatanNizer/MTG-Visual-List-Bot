package com.jnizer.mtgvisuallist;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter{
    final protected String prefix = "!visual";
    
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split(" ");
        String message = event.getMessage().getContentRaw();
        if(args[0].equalsIgnoreCase(prefix)){
            Regex regex = new Regex();
            regex.applyRegex(message);
            //event.getChannel().sendMessage("Here is your list!").queue();
        }
    }
    
}
