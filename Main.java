package snakeLadder;

public class Main {
	public static void main(String[] args) {
        Player p1 = new Player(1, "Arun", 0);
        Player p2 = new Player(2, "Akaay", 0);

        Board board = new Board(p1, p2);
        board.start();
    }
}
