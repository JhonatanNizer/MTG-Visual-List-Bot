package com.jnizer.mtgvisuallist.app;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class App {

    public static void main(String[] args) throws LoginException {
        String botToken = FileManager.getBotToken();
        JDA jda;
        jda = JDABuilder.createDefault(botToken).build();
        jda.getPresence().setActivity(Activity.playing("Kassinããão"));
        jda.addEventListener(new CommandListener());
    }

}