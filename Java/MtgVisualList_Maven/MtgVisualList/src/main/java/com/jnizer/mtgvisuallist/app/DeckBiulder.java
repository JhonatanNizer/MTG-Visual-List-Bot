package com.jnizer.mtgvisuallist.app;

import com.jnizer.mtgvisuallist.resource.Deck;
import com.jnizer.mtgvisuallist.resource.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeckBiulder {

    final protected String cardRegex = "([0-9]+)(\\s)(\\D+)(\\(\\w+\\))(\\s)(\\d+)";
    final protected Pattern cardPattern = Pattern.compile(cardRegex, Pattern.MULTILINE);

    public Deck biuldDeckFromMessage(String message) {
        try {
            String[] splittedMessage = message.split("\\s\\s");
            Deck deck = initializeDeck(splittedMessage);
            return deck;
        } catch(Exception ex) {
            return null;
        }
    }
    
    protected Deck initializeDeck(String[] splittedMsg) throws Exception {
        Deck deck = new Deck();
        switch (splittedMsg.length) {
            case 0 -> throw new Exception("ERROR: Deck cannot be null");
            case 1 -> {
                deck.setHasCommander(false);
                deck.setHasCompanion(false);
                deck.setHasSideBoard(false);
                deck.setMainDeck(getMaindeckFromMessage(splittedMsg[0]));
                break;
            }
            case 2 -> {
                if(splittedMsg[0].contains(("Commander"))){
                    deck.setHasCommander(true);
                    deck.setHasCompanion(false);
                    deck.setCommander(getCommanderFromMessage(splittedMsg[0]));
                } else {
                    deck.setHasCommander(false);
                    deck.setHasCompanion(true);
                    deck.setCompanion(getCompanionFromMessage(splittedMsg[0]));
                }
                deck.setHasSideBoard(false);
                deck.setMainDeck(getMaindeckFromMessage(splittedMsg[1]));
                break;
            }
            case 3 -> {
                if(splittedMsg[0].contains(("Commander"))){
                    deck.setHasCommander(true);
                    deck.setHasCompanion(true);
                    deck.setHasSideBoard(false);
                    deck.setCommander(getCommanderFromMessage(splittedMsg[0]));
                    deck.setCompanion(getCompanionFromMessage(splittedMsg[1]));
                    deck.setMainDeck(getMaindeckFromMessage(splittedMsg[2]));
                } else {
                    deck.setHasCommander(false);
                    deck.setHasCompanion(true);
                    deck.setHasSideBoard(true);
                    deck.setCompanion(getCompanionFromMessage(splittedMsg[0]));
                    deck.setMainDeck(getMaindeckFromMessage(splittedMsg[1]));
                    deck.setSideBoard(getSideboardFromMessage(splittedMsg[2]));
                }
            }
            default -> {
                throw new Exception("ERROR: Deck cannot be null");
            }
        }        
        return deck;
    }
    protected Card getCommanderFromMessage(String msg) {
        final Pattern pattern = Pattern.compile("(Commander)(\\s)" + cardRegex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(msg);
        Card commander = new Card();
        while (matcher.find()) {
            //System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                switch(i) {
                        case 3 -> commander.setQuantity(Integer.parseInt(matcher.group(i)));
                        case 5 -> commander.setName(String.format(matcher.group(i)));
                        case 6 -> commander.setBlock(String.format(matcher.group(i)));
                        case 8 -> commander.setCode(Integer.parseInt(matcher.group(i)));
                    }
                //System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
        return commander;
    } 
    protected Card getCompanionFromMessage(String msg) {
        final Pattern pattern = Pattern.compile("(Companion)(\\s)" + cardRegex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(msg);
        Card companion = new Card();
        while (matcher.find()) {
            //System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                switch(i) {
                        case 3 -> companion.setQuantity(Integer.parseInt(matcher.group(i)));
                        case 5 -> companion.setName(String.format(matcher.group(i)));
                        case 6 -> companion.setBlock(String.format(matcher.group(i)));
                        case 8 -> companion.setCode(Integer.parseInt(matcher.group(i)));
                    }
                //System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
        return companion;
    }
    protected List<Card> getMaindeckFromMessage(String msg) {
        List<Card> cardList = new ArrayList<>();
        Matcher matcher = cardPattern.matcher(msg);
        while (matcher.find()) {
            Card card = new Card();
            for (int i = 1; i <= matcher.groupCount(); i++) {
                //System.out.println("Full match: " + matcher.group(0));
                switch(i) {
                    case 1 -> card.setQuantity(Integer.parseInt(matcher.group(i)));
                    case 3 -> card.setName(String.format(matcher.group(i)));
                    case 4 -> card.setBlock(String.format(matcher.group(i)));
                    case 6 -> card.setCode(Integer.parseInt(matcher.group(i)));
                }
                //System.out.println("Group " + i + ": " + matcher.group(i));
            }
            cardList.add(card);
            }
        return cardList;
    } 
    protected List<Card> getSideboardFromMessage(String msg) {
        List<Card> cardList = new ArrayList<>();
        Matcher matcher = cardPattern.matcher(msg);
        while (matcher.find()) {
            Card card = new Card();
            for (int i = 1; i <= matcher.groupCount(); i++) {
                //System.out.println("Full match: " + matcher.group(0));
                switch(i) {
                    case 1 -> card.setQuantity(Integer.parseInt(matcher.group(i)));
                    case 3 -> card.setName(String.format(matcher.group(i)));
                    case 4 -> card.setBlock(String.format(matcher.group(i)));
                    case 6 -> card.setCode(Integer.parseInt(matcher.group(i)));
                }
                //System.out.println("Group " + i + ": " + matcher.group(i));
            }
            cardList.add(card);
            }
        return cardList;
    } 
}