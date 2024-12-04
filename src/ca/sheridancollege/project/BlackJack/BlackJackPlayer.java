package ca.sheridancollege.project.BlackJack;

import ca.sheridancollege.project.starterCode.Player;
import java.util.Scanner;

public class BlackJackPlayer extends Player {
    private static final Scanner in = new Scanner(System.in); // Made Scanner static to avoid multiple instances
    private String inp; // Changed to String for better input handling

    public BlackJackPlayer(String name) {
        super(name);
    }

    public boolean wantsToHit() {
        System.out.print(this.getName() + ", do you want to hit? (y or n): ");
        while (true) { // Fixed infinite loop issue
            inp = in.next().toLowerCase();
            if (inp.equals("y") || inp.equals("yes")) {
                return true;
            } else if (inp.equals("n") || inp.equals("no")) {
                return false;
            } else {
                System.out.print("Invalid input. Please enter 'y' or 'n': ");
            }
        }
    }

    @Override
    public void play() {
        // Implementation handled in BlackJackGame
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
