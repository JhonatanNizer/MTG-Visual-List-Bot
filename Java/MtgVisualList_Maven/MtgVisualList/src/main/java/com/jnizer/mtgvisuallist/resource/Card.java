package com.jnizer.mtgvisuallist.resource;

import java.awt.Image;
import java.util.List;

public class Card {

    private int quantity;
    private String name;
    private String block;
    private int code;
    private Image image;
    private String type;
    private List<ManaCost> manacost;
    private Card flip;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
