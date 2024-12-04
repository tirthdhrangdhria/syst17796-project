/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project.BlackJack;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards 
{
    private ArrayList<Cards> deck;
    
    public DeckOfCards()
    {
        deck = new ArrayList<>();
        init_deck();
    }
    
    private void init_deck()
    {
        System.out.println("Initializing Deck...");
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e){}
        
        for(Cards.SUITS s: Cards.SUITS.values())
        {
            for (Cards.VALUES v: Cards.VALUES.values())
            {
                Cards c = new Cards(s, v);
                deck.add(c);
            }
        }
        System.out.println("Deck Initialized.");
        
    }
    
    
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
    
    public Cards dealCard()
    {
        if (deck.isEmpty())
        {
            return null;
        }
        else
        {
            return deck.remove(0);
        }
    }
    
    public int remainingCards()
    {
        return deck.size();
    }
}

