package com.jnizer.mtgvisuallist;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
    public static String prefix = "!visual";
    
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split(" ");
        if(args[0].equalsIgnoreCase(prefix)){
            event.getChannel().sendMessage("Here is your list!").queue();
        }
    }
}
