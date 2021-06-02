package com.jnizer.mtgvisuallist.app;

import com.jnizer.mtgvisuallist.resource.Deck;
import com.jnizer.mtgvisuallist.resource.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeckBiulder {

    final protected String cardRegex = "([0-9]+)(\\s)(\\D+)(\\(\\w+\\))(\\s)(\\d+)";
    final protected Pattern pattern = Pattern.compile(cardRegex, Pattern.MULTILINE);

    public Deck biuldDeckFromMessage(String message) {
        try {
            getCommanderFromMessage(message);
            List<Card> cardList = new ArrayList<Card>();
            String[] messageList = message.split("\\n");
            
            Matcher matcher = pattern.matcher(message);
            while (matcher.find()) {
                Card card = new Card();
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    switch(i) {
                        case 2 -> card.setQuantity(Integer.parseInt(matcher.group(i)));
                        case 4 -> card.setName(String.format(matcher.group(i)));
                        case 5 -> card.setBlock(String.format(matcher.group(i)));
                        case 7 -> card.setCode(Integer.parseInt(matcher.group(i)));
                    }
                    //System.out.println("Group " + i + ": " + matcher.group(i));
                }
                cardList.add(card);
                //System.out.println("");
            }
            Deck deck = new Deck();
            deck.setMainDeck(cardList);
            return deck;
        } catch(Exception ex) {
            return null;
        }
    }
    
    protected Card getCommanderFromMessage(String msg) {
        final Pattern pattern = Pattern.compile("(Commander)(\\s)" + cardRegex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(msg);
        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }

        return null;
        
    } 
    protected Card getCompanionFromMessage(String msg) {
        return null;
    }
    protected List<Card> getMaindeckFromMessage(String msg) {
        return null;
    } 
    protected List<Card> getSideboardFromMessage(String msg) {
        return null;
    } 
    
}
