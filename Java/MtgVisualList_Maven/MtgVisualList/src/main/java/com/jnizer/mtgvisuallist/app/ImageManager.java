package com.jnizer.mtgvisuallist.app;

import com.jnizer.mtgvisuallist.resource.Deck;
import forohfor.scryfall.api.Card;
import java.io.File;
import forohfor.scryfall.api.MTGCardQuery;
import gui.ava.html.image.generator.HtmlImageGenerator;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.json.simple.JSONObject;

public class ImageManager {
    
    public static Deck setDeckImages(Deck deck) {
        try{
            List<String> cardNames = new ArrayList<>();
            deck.getMainDeck().forEach(card -> {
                cardNames.add(card.getName());
            });
            if(deck.HasCommander()) {
                cardNames.add(deck.getCommander().getName());
            }
            if(deck.HasSideBoard()) {
                deck.getSideBoard().forEach(card -> {
                    cardNames.add(card.getName());
                });
            }
            ArrayList<Card> cardsJSON = MTGCardQuery.toCardList(cardNames, false);
            deck.getMainDeck().forEach(card -> {
                for (int j = 0; j < cardsJSON.size(); j++) {
                   if(card.getName().trim().equals(cardsJSON.get(j).getName().trim())) {
                       JSONObject json = (JSONObject) cardsJSON.get(j).getJSONData().get("image_uris");
                       //card.setJson(json);
                       card.setImageUri((String) json.get("small"));
                       //System.out.println(card.getImageUri());
                       break;
                   }
                }
            });
            return deck;
        } catch(Exception ex){
            return null;
        }
    }
    public static File drawImageToSend(Deck deck) throws IOException {
        int width = 1200;
        int height = 700;
 
        // Create a white canvas
        BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = canvas.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        int x = 0;
        int y = 0;
        int cardsByLine = 0;
        for (com.jnizer.mtgvisuallist.resource.Card card : deck.getMainDeck()) {
            if(cardsByLine > 7) {
                y = y + 215;
                x = 0;
                cardsByLine = 0;
            } else { 
                cardsByLine++;
            }
            BufferedImage img = ImageIO.read(new URL(card.getImageUri()));
            g2d.drawImage(img, x, y, null);
            x = x + 150;
        }
        
        g2d.dispose();
        File file = new File("images-api/myimage.png");
        ImageIO.write(canvas, "png", file);        
        return file;
    }
    public static File getCardImage(String cardName) throws IOException {
        cardName = "Negate";
        var queryArrayCards = MTGCardQuery.search(cardName);
        Card card = null;
        int i = 0;
        String cardEscrito = null;
        String cardBaixado = null;
        for (Card c : queryArrayCards) {
            cardEscrito = cardName.toLowerCase();
            cardBaixado = c.getName().toLowerCase();
            if(cardEscrito.contains(cardBaixado)) {
                card = queryArrayCards.get(i);
                break;
            }
            i++;
        }
        //Card card = queryArrayCards.get(0);
        JSONObject json = (JSONObject) card.getJSONData().get("image_uris");
        String uri = (String) json.get("normal");
        String imageUrl = uri;
        String destinationFile = "images-api\\image.jpg";
        saveImage(imageUrl, destinationFile);
        String path = "images-api\\image.jpg";
        File file = new File(path);
        return file;
    }
    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);
        byte[] b = new byte[2048];
        int length;
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }
        is.close();
        os.close();
    } 
    
}