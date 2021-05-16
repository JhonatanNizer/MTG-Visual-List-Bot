package com.jnizer.mtgvisuallist;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class App {
    public static JDA jda;

    public static String token = "NzkzNjE1OTExMjcyNTc5MDky.X-u2aQ.47AWRs5vIpibX8m7Sj8jJmXTyZs";
    
    public static void main(String[] args) throws LoginException, InterruptedException{
        jda = JDABuilder.createDefault(token)
                .build();
        jda.addEventListener(new Commands());
    }
    
}
