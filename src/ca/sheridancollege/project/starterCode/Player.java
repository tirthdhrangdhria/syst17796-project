/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project.starterCode;

import ca.sheridancollege.project.BlackJack.Cards;
import java.util.ArrayList;

public abstract class Player {

    private String name; // the unique name for this player
    private ArrayList<Cards> hand;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a card to the player's hand.
     * 
     * @param dealCard the card to add
     */
    public void addCardToHand(Cards dealCard) {
        this.hand.add(dealCard);
    }

    /**
     * @return the player's current hand as a list of cards
     */
    public ArrayList<Cards> getHand() {
        return this.hand;
    }

    /**
     * Calculates the total value of the player's hand, considering the value of
     * Aces (11 or 1) to avoid busting if possible.
     * 
     * @return the total hand value
     */
    public int calculateHandValue() {
        int totalValue = 0;
        int aceCount = 0;

        // Calculate initial hand value
        for (Cards card : hand) {
            switch (card.getValue()) {
                case TWO:
                    totalValue += 2;
                    break;
                case THREE:
                    totalValue += 3;
                    break;
                case FOUR:
                    totalValue += 4;
                    break;
                case FIVE:
                    totalValue += 5;
                    break;
                case SIX:
                    totalValue += 6;
                    break;
                case SEVEN:
                    totalValue += 7;
                    break;
                case EIGHT:
                    totalValue += 8;
                    break;
                case NINE:
                    totalValue += 9;
                    break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING:
                    totalValue += 10;
                    break;
                case ACE:
                    totalValue += 11; // Count Ace as 11 initially
                    aceCount++;
                    break;
            }
        }

        // Adjust for Aces if total value exceeds 21
        while (totalValue > 21 && aceCount > 0) {
            totalValue -= 10; // Treat an Ace as 1 instead of 11
            aceCount--;
        }

        return totalValue;
    }

    /**
     * Abstract method to be overridden in subclasses for specific player logic.
     */
    public abstract void play();
}
