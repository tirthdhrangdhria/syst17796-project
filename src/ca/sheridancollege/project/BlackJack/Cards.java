/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project.BlackJack;

import ca.sheridancollege.project.starterCode.Card;

public class Cards extends Card {

    private SUITS suit;
    private VALUES value;
    
    
    public enum SUITS
    {
        HEARTS, DIAMONDS, SPADES, CLUBS
    }
    
    public enum VALUES
    {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, KING, QUEEN, ACE
    }
    
    public Cards(SUITS suit, VALUES value)
    {
        this.suit = suit;
        this.value = value;
    }
    
    public VALUES getValue()
    {
        return this.value;
    }
    
    public SUITS getSUIT()
    {
        return this.suit;
    }
    
    @Override
    public String toString() {
        return this.suit + " " + this.value;
    }
    
}
