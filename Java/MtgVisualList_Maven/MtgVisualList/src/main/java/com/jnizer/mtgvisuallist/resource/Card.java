package com.jnizer.mtgvisuallist.resource;

import java.io.File;
import java.util.List;
import org.json.simple.JSONObject;

public class Card {
    
    private int quantity;
    private String name;
    private String block;
    private int code;
    private String imageUri;    
    private File image;
    private String type;
    private List<ManaCost> manacost;
    private Card flip;
    private JSONObject json;

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }
    
    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ManaCost> getManacost() {
        return manacost;
    }

    public void setManacost(List<ManaCost> manacost) {
        this.manacost = manacost;
    }

    public Card getFlip() {
        return flip;
    }

    public void setFlip(Card flip) {
        this.flip = flip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

}
