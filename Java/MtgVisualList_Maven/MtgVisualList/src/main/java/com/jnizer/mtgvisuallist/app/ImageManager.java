package com.jnizer.mtgvisuallist.app;

import com.jnizer.mtgvisuallist.resource.Deck;
import forohfor.scryfall.api.Card;
import java.io.File;
import forohfor.scryfall.api.MTGCardQuery;
import gui.ava.html.image.generator.HtmlImageGenerator;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
                       card.setImageUri((String) json.get("normal"));
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
        int width = 300;
        int height = 600;
 
        // Constructs a BufferedImage of one of the predefined image types.
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
 
        // Create a graphics which can be used to draw into the buffered image
        Graphics2D g2d = bufferedImage.createGraphics();
 
        // fill all the image with white
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, width, height);
 
        // create a circle with black
        //g2d.setColor(Color.black);
        //g2d.fillOval(0, 0, width, height);
 
        // create a string with yellow
        g2d.setColor(Color.BLACK);
        
        int altura = 10; 
        if(deck.HasCompanion()){
            g2d.drawString("Companhero: " + deck.getCompanion().getName(), 0, altura);
            altura = altura + 10;
        }
        
        altura = altura + 10;   
        for (int i = 0; i < deck.getMainDeck().size(); i++) {
            g2d.drawString(deck.getMainDeck().get(i).getName(), 0, altura);
            altura = altura + 10;
        }
        
        if(deck.HasSideBoard()) { 
            altura = altura + 10;
            g2d.drawString("SideBoard:", 0, altura);
            altura = altura + 10;
            for (int i = 0; i < deck.getSideBoard().size(); i++) {
                g2d.drawString(deck.getSideBoard().get(i).getName(), 0, altura);
                altura = altura + 10;
            }
        }
 
        // Disposes of this graphics context and releases any system resources that it is using. 
        g2d.dispose();
 
        // Save as PNG
        File file = new File("images-api/myimage.png");
        ImageIO.write(bufferedImage, "png", file);        
  
        return file;
    }
    private static String createHTML(Deck deck) {
        String html = 
            "<!DOCTYPE html>\n" +
            "<html>\n" +
            "\n" +
            "<head>\n" +
            "  <style>\n" +
            "    #row0col0 {\n" +
            "      float: left;\n" +
            "      background: Red;\n" +
            "      width: 310px;\n" +
            "      height: 1000px;\n" +
            "    }\n" +
            "    #row0col1 {\n" +
            "      float: left;\n" +
            "      background: Green;\n" +
            "      width: 310px;\n" +
            "      height: 1000px;\n" +
            "    }\n" +
            "    #row0col2 {\n" +
            "      float: left;\n" +
            "      background: blue;\n" +
            "      width: 310px;\n" +
            "      height: 1000px;\n" +
            "    }\n" +
            "    #row0col3 {\n" +
            "      float: left;\n" +
            "      background: blueviolet;\n" +
            "      width: 310px;\n" +
            "      height: 1000px;\n" +
            "    }\n" +
            "    #row0col4 {\n" +
            "      float: left;\n" +
            "      background: chartreuse;\n" +
            "      width: 310px;\n" +
            "      height: 1000px;\n" +
            "    }\n" +
            "  </style>\n" +
            "</head>\n" +
            "\n" +
            "<body>\n" +
            "  <div\" style=\"width: 1000; background-color: black;\">\n" +
            "    <div id=\"row0col0\">\n" +
            "      <img width=\"300px\" src=\"https://cdn1.mtggoldfish.com/images/gf/Bonecrusher%2BGiant%2B%255BELD%255D.jpg\">\n" +
            "      <img width=\"300px\" style=\"margin-top:-380px\"\n" +
            "        src=\"https://cdn1.mtggoldfish.com/images/gf/Bonecrusher%2BGiant%2B%255BELD%255D.jpg\">\n" +
            "      <img width=\"300px\" style=\"margin-top:-380px\"\n" +
            "        src=\"https://cdn1.mtggoldfish.com/images/gf/Bonecrusher%2BGiant%2B%255BELD%255D.jpg\">\n" +
            "      <img width=\"300px\" style=\"margin-top:-380px\"\n" +
            "        src=\"https://cdn1.mtggoldfish.com/images/gf/Bonecrusher%2BGiant%2B%255BELD%255D.jpg\">\n" +
            "    </div>\n" +
            "    <div id=\"row0col1\">\n" +
            "      <img width=\"300px\" src=\"https://cdn1.mtggoldfish.com/images/gf/Brazen%2BBorrower%2B%255BELD%255D.jpg\">\n" +
            "      <img width=\"300px\" style=\"margin-top:-380px\"\n" +
            "        src=\"https://cdn1.mtggoldfish.com/images/gf/Brazen%2BBorrower%2B%255BELD%255D.jpg\">\n" +
            "      <img width=\"300px\" style=\"margin-top:-380px\"\n" +
            "        src=\"https://cdn1.mtggoldfish.com/images/gf/Brazen%2BBorrower%2B%255BELD%255D.jpg\">\n" +
            "      <img width=\"300px\" style=\"margin-top:-380px\"\n" +
            "        src=\"https://cdn1.mtggoldfish.com/images/gf/Brazen%2BBorrower%2B%255BELD%255D.jpg\">\n" +
            "    </div>\n" +
            "  </div>\n" +
            "</body>\n" +
            "\n" +
            "</html>";
        return html;
    }
    public static File htmlToImage(Deck deck) {
        HtmlImageGenerator hig = new HtmlImageGenerator();
        hig.loadHtml(createHTML(deck));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ImageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        String path = "images-api\\test.png";
        hig.saveAsImage(new File(path));
        File file = new File(path);
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