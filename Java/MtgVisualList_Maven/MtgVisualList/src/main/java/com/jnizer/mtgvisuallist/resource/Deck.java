package com.jnizer.mtgvisuallist.resource;

import java.util.List;

public class Deck {

    private Card companion;
    private Card commander;
    private List<Card> mainDeck;
    private List<Card> sideBoard;
    private boolean hasCompanion;
    private boolean hasSideBoard;
    private boolean hasCommander;
    
    public boolean HasCompanion() {
        return hasCompanion;
    }

    public void setHasCompanion(boolean hasCompanion) {
        this.hasCompanion = hasCompanion;
    }

    public boolean HasSideBoard() {
        return hasSideBoard;
    }

    public void setHasSideBoard(boolean hasSideBoard) {
        this.hasSideBoard = hasSideBoard;
    }

    public boolean HasCommander() {
        return hasCommander;
    }

    public void setHasCommander(boolean hasCommander) {
        this.hasCommander = hasCommander;
    }
    

    public Card getCompanion() {
        return companion;
    }

    public void setCompanion(Card companion) {
        this.companion = companion;
    }

    public Card getCommander() {
        return commander;
    }

    public void setCommander(Card commander) {
        this.commander = commander;
    }

    public List<Card> getMainDeck() {
        return mainDeck;
    }

    public void setMainDeck(List<Card> mainDeck) {
        this.mainDeck = mainDeck;
    }

    public List<Card> getSideBoard() {
        return sideBoard;
    }

    public void setSideBoard(List<Card> sideBoard) {
        this.sideBoard = sideBoard;
    }

}
