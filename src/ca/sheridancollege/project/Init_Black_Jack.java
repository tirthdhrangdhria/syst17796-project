/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.BlackJack.BlackJackPlayer;
import ca.sheridancollege.project.BlackJack.BlackJackGame;
import ca.sheridancollege.project.starterCode.Player;
import java.util.ArrayList;

public class Init_Black_Jack 
{
    public static void main(String[] args)
    {
        BlackJackGame game = new BlackJackGame("Blackjack");
        ArrayList<Player> gamePlayers = new ArrayList<>();
    
        gamePlayers.add(new BlackJackPlayer("Player 1"));
        gamePlayers.add(new BlackJackPlayer("Player 2"));
    
        game.setPlayers(gamePlayers);
        game.play();
    }
}
