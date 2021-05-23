package com.jnizer.mtgvisuallist.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class App {

    public static void main(String[] args) throws LoginException, InterruptedException, FileNotFoundException {
        JDA jda;
        jda = JDABuilder.createDefault(GetToken())
                .build();
        jda.addEventListener(new CommandListener());
    }

    private static String GetToken() throws FileNotFoundException {
        String path = "C:\\Users\\Nizer\\Documents\\GitHub\\MTG VisualList Bot\\MTG-Visual-List-Bot\\Java\\MtgVisualList\\src\\com\\jnizer\\mtgvisuallist\\app\\token.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String token = scanner.nextLine();
        return token;
    }

}
