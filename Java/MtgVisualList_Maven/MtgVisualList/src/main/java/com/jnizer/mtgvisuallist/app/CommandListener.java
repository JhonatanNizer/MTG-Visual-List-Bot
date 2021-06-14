package com.jnizer.mtgvisuallist.app;

import com.jnizer.mtgvisuallist.resource.Card;
import com.jnizer.mtgvisuallist.resource.Deck;
import java.io.IOException;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {

    final protected String prefix = "!visual";

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String rawMessage = event.getMessage().getContentRaw();
        String message = rawMessage.substring(prefix.length());
        if (rawMessage.startsWith(prefix)) {
            try {
                DeckBiulder deckBiulder = new DeckBiulder();
                Deck deck = deckBiulder.biuldDeckFromMessage(message);
                if (deck == null) { throw new IOException(); }
                
                deck = ImageAPIManager.setDeckImages(deck);
                
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage("Here is your card: ").addFile(ImageAPIManager.getCardImage(message)).queue();
            } catch (IOException ex) {
                event.getChannel().sendMessage("Error loading visual list").queue();
            }            
        }
    }
    
    protected String TesteMessage(Deck deck){
        String mensagemParaEnvio = "";
        String commander = "O seu deck não tem commander\n\n";
        String companion = "O seu deck não tem companion\n\n";
        String maindeck = "\n\n";
        String sideboard = "\nO seu deck não tem sideboard\n\n";
        if(deck.HasCommander()){
            commander = "O seu commander é: " + deck.getCommander().getName() + "\n\n";
        }
        if(deck.HasCompanion()){
            companion = "O seu companion é: " + deck.getCompanion().getName() + "\n\n";
        }
        maindeck = "As cartas do seu deck são: \n";
        for (Card card : deck.getMainDeck()) {
            maindeck += card.getName() + "\n";
        }
        if(deck.HasSideBoard()){
            sideboard = "\nAs cartas do seu sideboard são: \n";
            for (Card card : deck.getSideBoard()) {
                sideboard += card.getName() + "\n";
            }
        }
        mensagemParaEnvio = commander + companion + maindeck + sideboard;
        return mensagemParaEnvio;
    }

}
