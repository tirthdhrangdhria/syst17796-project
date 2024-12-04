package ca.sheridancollege.project.BlackJack;

import ca.sheridancollege.project.starterCode.Game;
import ca.sheridancollege.project.starterCode.Player;

public class BlackJackGame extends Game {
    private DeckOfCards deck;
    private static BlackJackPlayer dealer = new BlackJackPlayer("Dealer");

    public BlackJackGame(String name) {
        super(name);
        deck = new DeckOfCards();
    }

    @Override
    public void play() {
        System.out.println("***********************************");
        System.out.println("         WELCOME TO BLACKJACK       ");
        System.out.println("***********************************\n");

        System.out.println("Shuffling deck...");
        deck.shuffle();

        try {
            // Adding a 2-second delay
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("Deck Shuffled!\n");

        System.out.println("Dealing cards to each player...");
        for (Player player : getPlayers()) {
            player.addCardToHand(deck.dealCard());
            player.addCardToHand(deck.dealCard());
        }
        dealer.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());

        System.out.println("\nCards Dealt!");
        System.out.println("-----------------------------------");
        System.out.println("Dealer's first card: " + dealer.getHand().get(0));
        System.out.println("-----------------------------------\n");

        for (Player player : getPlayers()) {
            System.out.println(player.getName() + "'s Initial Hand: " + player.getHand());
        }
        System.out.println();

        // Player Turns
        for (Player player : getPlayers()) {
            System.out.println("===================================");
            System.out.println("       " + player.getName() + "'s TURN        ");
            System.out.println("===================================");

            while (((BlackJackPlayer) player).wantsToHit()) {
                player.addCardToHand(deck.dealCard());
                System.out.println("Card Dealt: " + player.getHand().get(player.getHand().size() - 1));
                System.out.println(player.getName() + "'s Updated Hand: " + player.getHand());

                // Bust Check
                int handValue = player.calculateHandValue();
                System.out.println(player.getName() + "'s Current Hand Value: " + handValue);

                if (handValue > 21) {
                    System.out.println("Oops! " + player.getName() + " busts!\n");
                    break; // End turn for this player
                }
            }
        }

        // Dealer Turn
        System.out.println("\n===================================");
        System.out.println("         DEALER'S TURN             ");
        System.out.println("===================================");

        while (dealer.calculateHandValue() < 17) {
            dealer.addCardToHand(deck.dealCard());
            System.out.println("Dealer draws: " + dealer.getHand().get(dealer.getHand().size() - 1));
        }

        int dealerValue = dealer.calculateHandValue();
        if (dealerValue > 21) {
            System.out.println("Dealer busts with a hand value of " + dealerValue + "!\n");
        } else {
            System.out.println("Dealer stands with a hand value of " + dealerValue + ".\n");
        }

        // Declare Winner
        declareWinner();
    }

    @Override
    public void declareWinner() {
        int dealerValue = dealer.calculateHandValue();

        System.out.println("\n***********************************");
        System.out.println("          FINAL RESULTS            ");
        System.out.println("***********************************\n");

        for (Player player : getPlayers()) {
            int playerValue = player.calculateHandValue();

            System.out.println(player.getName() + "'s Hand: " + player.getHand() + " - Value: " + playerValue);
            System.out.println("Dealer's Hand: " + dealer.getHand() + " - Value: " + dealerValue);

            if (playerValue > 21) {
                System.out.println(player.getName() + " busts. Dealer wins!\n");
            } else if (dealerValue > 21) {
                System.out.println("Dealer busts. " + player.getName() + " wins!\n");
            } else if (playerValue > dealerValue) {
                System.out.println(player.getName() + " wins!\n");
            } else if (playerValue < dealerValue) {
                System.out.println("Dealer wins!\n");
            } else {
                System.out.println("It's a tie!\n");
            }
        }

        System.out.println("***********************************");
        System.out.println("      THANK YOU FOR PLAYING!       ");
        System.out.println("***********************************");
    }
}