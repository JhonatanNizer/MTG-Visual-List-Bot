package com.jnizer.mtgvisuallist.app;

import java.util.List;

public class Deck {

    private Card companion;
    private Card commander;
    private List<Card> mainDeck;
    private List<Card> sideBoard;

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
