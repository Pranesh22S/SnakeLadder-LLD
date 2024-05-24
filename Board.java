package snakeLadder;
import java.util.*;
public class Board {
	 private static final int END = 100;
	 private static final Random random = new Random();
	 private boolean run;
	 private Player p1;
	 private Player p2;
	 private HashMap<Integer, Integer> snakes;
	 private HashMap<Integer, Integer> ladders;
	 public Board(Player p1, Player p2) {
	     this.p1 = p1;
	     this.p2 = p2;
	     this.run = true;
	     this.snakes = new HashMap<>();
	     this.ladders = new HashMap<>();
	     snakes.put(37, 3);
	     snakes.put(48, 16);
	     snakes.put(75, 32);
	     snakes.put(94, 71);
	     ladders.put(4, 54);
	     ladders.put(22, 58);
	     ladders.put(41, 79);
	     ladders.put(54, 88);
	 }
	 public void start() {
	        while (run) {
	            playTurn(p1);
	            if (p1.getPosition() == END) {
	                System.out.println("\u001B[32m"+"Player " + p1.getName() + " wins!");
	                run = false;
	                break;
	            }
	            playTurn(p2);
	            if (p2.getPosition() == END) {
	                System.out.println("\u001B[37m"+"Player " + p2.getName() + " wins!");
	                run = false;
	                break;
	            }
	        }
	    }

	    private void playTurn(Player player) {
	        int diceRoll = rollDice();
	        int newPosition = player.getPosition() + diceRoll;
	        if (snakes.containsKey(newPosition)) {
	            player.setPosition(snakes.get(newPosition));
	            System.out.println("Snake! " + player.getName() + " moves to " + player.getPosition());
	        } else if (ladders.containsKey(newPosition)) {
	            player.setPosition(ladders.get(newPosition));
	            System.out.println("Ladder! " + player.getName() + " moves to " + player.getPosition());
	        } else {
	            player.setPosition(Math.min(newPosition, END));
	        }

	        System.out.println(player);
	    }

	    private int rollDice() {
	        return random.nextInt(6) + 1;
	    }
}
