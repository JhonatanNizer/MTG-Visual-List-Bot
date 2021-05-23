package com.jnizer.mtgvisuallist.app;

import java.io.File;
import forohfor.scryfall.api.MTGCardQuery;
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class ImageManager {
    
    String path = "C:\\Users\\Nizer\\Documents\\GitHub\\MTG VisualList Bot\\MTG-Visual-List-Bot\\Java\\MtgVisualList\\src\\com\\jnizer\\mtgvisuallist\\images\\ex.png";
    File file = new File(path);
    
    public static void GetCardImage() throws IOException {
        var scryfallcard = MTGCardQuery.search("!Negate");
        //Card iocard = CardAPI.;
        var uri = scryfallcard.get(0).getImageURIs();
        String url = uri.get(1);
        
        String imageUrl = "https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=1&type=card";
        String destinationFile = "images-api\\image.jpg";
        saveImage(imageUrl, destinationFile);
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
