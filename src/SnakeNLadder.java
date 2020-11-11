import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SnakeNLadder {

	private static final int WINPOINT = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeNLadder s = new SnakeNLadder();
		s.startGame();
		}

	static class SnakeNLadder1 {
		
		final static int WINPOINT = 100;
		
		
		static Map<Integer,Integer> snake = new HashMap<Integer,Integer>();
		static Map<Integer,Integer> ladder = new HashMap<Integer,Integer>();
		
		{
			snake.put(99,54);
			snake.put(70,55);
			snake.put(52,42);
			snake.put(25,2);
			snake.put(95,72);
			
			ladder.put(6,25);
			ladder.put(11,40);
			ladder.put(60,85);
			ladder.put(46,90);
			ladder.put(17,69);
		}
	}
	private Map<Integer, Integer> snake;
	private Map<Integer, Integer> ladder;
	private void startGame() {
		// TODO Auto-generated method stub
		
	}
	public int rollDice()
	{
		int n = 0;
		Random r = new Random();
		n=r.nextInt(7);
		return (n==0?1:n);
	}
	public void startGame1()
	{
		int player1 =0, player2=0;
		int currentPlayer=-1;
		Scanner s = new Scanner(System.in);
		String str;
		int diceValue =0;
		do
		{
			System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER TURN":"\n\nSECOND PLAYER TURN");
			System.out.println("Press r to roll Dice");
			str = s.next();
			diceValue = rollDice();
			
			
			if(currentPlayer == -1)
			{
				player1 = calculatePlayerValue1(player1,diceValue);
				System.out.println("First Player :: " + player1);
				System.out.println("Second Player :: " + player2);
				System.out.println("------------------");
				if(isWin(player1))
				{
					System.out.println("First player wins");
					return;
				}
			}
			else
			{
				player2 = calculatePlayerValue1(player2,diceValue);
				System.out.println("First Player :: " + player1);
				System.out.println("Second Player :: " + player2);
				System.out.println("------------------");
				if(isWin(player2))
				{
					System.out.println("Second player wins");
					return;
				}
			}
			
			currentPlayer= -currentPlayer;
			
			
			
		}while("r".equals(str));
		
	}
	public int calculatePlayerValue1(int player, int diceValue)
	{
		player = player + diceValue;
		
		if(player > WINPOINT)
		{
			player = player - diceValue;
			return player;
		}
		
		if(null!=snake.get(player))
		{
			System.out.println("swallowed by snake");
			player= snake.get(player);
		}
		
		if(null!=ladder.get(player))
		{
			System.out.println("climb up the ladder");
			player= ladder.get(player);
		}
		return player;
	}
	private boolean isWin(int player1) {
		// TODO Auto-generated method stub
		return false;
	}
	private int calculatePlayerValue(int player1, int diceValue) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
