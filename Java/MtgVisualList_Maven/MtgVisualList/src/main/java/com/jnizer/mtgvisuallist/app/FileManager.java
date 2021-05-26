package com.jnizer.mtgvisuallist.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {

    public static String getBotToken() {
        try {
            String tokenPath = "C:\\Users\\Nizer\\Documents\\GitHub\\MTG VisualList Bot\\MTG-Visual-List-Bot\\Java\\MtgVisualList_Maven\\MtgVisualList\\src\\main\\java\\com\\jnizer\\mtgvisuallist\\files\\token.txt";
            File file = new File(tokenPath);
            Scanner scanner;
            scanner = new Scanner(file);
            String token = scanner.nextLine();
            return token;
        } catch (FileNotFoundException ex) {
            System.err.println("Error at: " + FileManager.class.getName() + ": token file not found!");
            return null;
        }
    }

}
