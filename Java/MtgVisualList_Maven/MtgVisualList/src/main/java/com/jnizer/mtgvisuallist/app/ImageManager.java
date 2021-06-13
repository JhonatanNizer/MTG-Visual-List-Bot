package com.jnizer.mtgvisuallist.app;

import forohfor.scryfall.api.Card;
import java.io.File;
import forohfor.scryfall.api.MTGCardQuery;
//import io.magicthegathering.javasdk.api.CardAPI;
//import io.magicthegathering.javasdk.resource.Card;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

public class ImageManager {
    
    public static File getCardImage(String cardName) throws IOException {
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
        String path = "C:\\Users\\Nizer\\Documents\\GitHub\\MTG VisualList Bot\\MTG-Visual-List-Bot\\Java\\MtgVisualList_Maven\\MtgVisualList\\images-api\\image.jpg";
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
