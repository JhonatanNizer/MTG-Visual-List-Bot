package com.jnizer.mtgvisuallist.app;

import com.jnizer.mtgvisuallist.resource.Deck;
import com.jnizer.mtgvisuallist.resource.Card;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    final protected String regex = "(([0-9]+)(\\s)(\\D+)(\\(\\w+\\))(\\s)(\\d+))";
    final protected Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);

    public Deck createDeckFromRegex(String message) {
        try {
            List<Card> cardList = new ArrayList<Card>();
            final Matcher matcher = pattern.matcher(message);
            while (matcher.find()) {
                Card card = new Card();
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    switch(i) {
                        case 2:
                            card.setQuantity(Integer.parseInt(matcher.group(i)));
                            break;
                        case 4: 
                            card.setName(String.format(matcher.group(i)));
                            break;
                        case 5:
                            card.setBlock(String.format(matcher.group(i)));
                            break;
                        case 7:
                            card.setCode(Integer.parseInt(matcher.group(i)));
                            break;
                    }
                    cardList.add(card);
                    System.out.println("Group " + i + ": " + matcher.group(i));
                }
                System.out.println("");
            }
            Deck deck = new Deck();
            deck.setMainDeck(cardList);
            return deck;
        } catch(Exception ex) {
            return null;
        }
    } 
    
}
