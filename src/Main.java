import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	Scanner sc = new Scanner(System.in);

	void displayMenu() {
		System.out.println("RAP BATTLE");
		System.out.println();
		System.out.println("1. Single Player");
		System.out.println("2. Multiplayer");
	}

	void setupRappers(Rapper[] rappers) {
		rappers[0] = new Rapper("Can't-ye East", 50);
		rappers[1] = new Rapper("Noop Dog", 60);
		rappers[2] = new Rapper("Lil' Dwayne", 65);
		rappers[3] = new Rapper("Dr. Andre", 70);
		rappers[4] = new Rapper("M and M", 80);
		rappers[5] = new Rapper("3 Pack", 85);
		rappers[6] = new Rapper("Supa Hot Fire", 90);
	}

	void yourMumDis(Rapper[] rappers, int rappersBeaten) {
		Random r = new Random();
		int hypeGained = r.nextInt(6);

		System.out.println("You rapped about his mum");
		System.out.println("You gained " + hypeGained + "% of the crowd hype");

		rappers[rappersBeaten].hypePoints -= hypeGained;

		AITurn(rappers, rappersBeaten);
	}

	void yourMumDisAI(Rapper[] rappers, int rappersBeaten) {
		Random r = new Random();
		int hypeGained = r.nextInt(6);

		System.out.println(rappers[rappersBeaten].name
				+ " rapped about your mum");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("He gained " + hypeGained + "% of the crowd hype");

		rappers[rappersBeaten].hypePoints += hypeGained;

	}

	void callName(Rapper[] rappers, int rappersBeaten) {
		Random r = new Random();
		String adjective;
		String noun;
		int count;
		count = r.nextInt(10);

		try {
			BufferedReader adj = new BufferedReader(new FileReader(
					"adjectives.txt"));
			BufferedReader nou = new BufferedReader(new FileReader("nouns.txt"));

			for (int i = 0; i < count; i++) {
				adjective = adj.readLine();

				if (i == count - 1) {
					System.out.print("You called him a " + adjective + " ");
				}

			}

			count = r.nextInt(10);

			for (int i = 0; i < count; i++) {
				noun = nou.readLine();

				if (i == count - 1) {
					System.out.println(noun);
				}

			}
			adj.close();
			nou.close();

			int hypeGained = r.nextInt(11);

			System.out.println("You gained " + hypeGained
					+ "% of the crowd hype");

			rappers[rappersBeaten].hypePoints -= hypeGained;

			AITurn(rappers, rappersBeaten);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void callNameAI(Rapper[] rappers, int rappersBeaten) {
		Random r = new Random();
		String adjective;
		String noun;
		int count;
		count = r.nextInt(10);

		try {
			BufferedReader adj = new BufferedReader(new FileReader(
					"adjectives.txt"));
			BufferedReader nou = new BufferedReader(new FileReader("nouns.txt"));

			for (int i = 0; i < count; i++) {
				adjective = adj.readLine();

				if (i == count - 1) {
					System.out.print("You got called a " + adjective + " ");
				}

			}

			count = r.nextInt(10);

			for (int i = 0; i < count; i++) {
				noun = nou.readLine();

				if (i == count - 1) {
					System.out.println(noun);
				}

			}
			adj.close();
			nou.close();
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			int hypeGained = r.nextInt(11);

			System.out.println(rappers[rappersBeaten].name + " gained "
					+ hypeGained + "% of the crowd hype");
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			rappers[rappersBeaten].hypePoints += hypeGained;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void teaseDis(Rapper[] rappers, int rappersBeaten) {

		String tease;
		Random r = new Random();
		int count;
		count = r.nextInt(4);

		try {
			BufferedReader teaseR = new BufferedReader(new FileReader(
					"teases.txt"));

			for (int i = 0; i < count; i++) {
				tease = teaseR.readLine();

				if (i == count - 1) {
					System.out.println("You told "
							+ rappers[rappersBeaten].name + " he " + tease);
				}
			}
			teaseR.close();

			int hypeGained = r.nextInt(21);

			System.out.println("You gained " + hypeGained
					+ "% of the crowd hype");

			rappers[rappersBeaten].hypePoints -= hypeGained;

			AITurn(rappers, rappersBeaten);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void teaseDisAI(Rapper[] rappers, int rappersBeaten) {

		String tease;
		Random r = new Random();
		int count;
		count = r.nextInt(4);

		try {
			BufferedReader teaseR = new BufferedReader(new FileReader(
					"teasesAI.txt"));

			for (int i = 0; i < count; i++) {
				tease = teaseR.readLine();

				if (i == count - 1) {
					System.out.println("He said to you that you " + tease);
				}
			}
			teaseR.close();
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			int hypeGained = r.nextInt(21);

			System.out.println("He gained " + hypeGained
					+ "% of the crowd hype");
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			rappers[rappersBeaten].hypePoints += hypeGained;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void giveUp(Rapper[] rappers, int rappersBeaten) {
		System.out.println("Are you sure you want to let " + rappers[rappersBeaten].name + " take the win?");
		System.out.println();
		System.out.println("1. What you chattin' fam? I'm not quitting");
		System.out.println("2. Yeah, I can't handle his hype");
	}
	
	void getMenuChoice(int choice, Rapper[] rappers) {
		int rappersBeaten = 0;
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			singleplayer(rappers, rappersBeaten);
			break;
		case 2:
			multiplayer();
			break;
		}
	}

	void singleplayer(Rapper[] rappers, int rappersBeaten) {
		boolean beaten = false;
		boolean won;

		System.out.println("You have been challenged by "
				+ rappers[rappersBeaten].name);
		System.out.println("He has " + rappers[rappersBeaten].hypePoints
				+ "% of the crowd's hype");
		System.out.println("Dis him up to get 100% of the hype");

		won = false;

		checkIfWon(rappers, rappersBeaten, won, beaten);

	}

	void checkIfWon(Rapper[] rappers, int rappersBeaten,
			boolean won, boolean beaten) {
		while (rappers[rappersBeaten].hypePoints > 0 && !won) {
			playGameSP(rappers, rappersBeaten);

			if (rappers[rappersBeaten].hypePoints <= 0) {
				System.out.println();
				System.out.print("You beat " + rappers[rappersBeaten].name
						+ "!");
				System.out.println();
				System.out.println();
				System.out.println();

				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				rappersBeaten++;
				won = true;
				singleplayer(rappers, rappersBeaten);
			}

			if (beaten) {
				System.out.println("GAME OVER");
			}

		}
	}

	void multiplayer() {

	}

	void playGameSP(Rapper[] rappers, int rappersBeaten) {
		int choice = 0;

		System.out.println("Your hype: "
				+ (100 - rappers[rappersBeaten].hypePoints) + "%");
		System.out.println(rappers[rappersBeaten].name + "'s hype: "
				+ rappers[rappersBeaten].hypePoints + "%");
		System.out.println();
		System.out.println("What would you like to dis your opponent with?");
		System.out.println();
		System.out.println("1. Your mum dis");
		System.out.println("2. Name calling dis");
		System.out.println("3. Teasing dis");
		System.out.println("4. Give up");

		if (sc.hasNextInt()) {
			choice = sc.nextInt();
		} else {
			System.out.println("Okay then..");
		}
		switch (choice) {
		case 1:
			yourMumDis(rappers,rappersBeaten);
			break;
		case 2:
			callName(rappers, rappersBeaten);
			break;
		case 3:
			teaseDis(rappers, rappersBeaten);
			break;
		case 4:
			
			break;
		}

	}

	void AITurn(Rapper[] rappers, int rappersBeaten) {
		Random r = new Random();
		int choice;
		
		choice = r.nextInt(3);
		
		System.out.println();
		System.out.println("Now it's " + rappers[rappersBeaten].name + "'s turn");
		System.out.println();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		switch (choice) {
		case 0:
			yourMumDisAI(rappers, rappersBeaten);
			break;
		case 1:
			callNameAI(rappers, rappersBeaten);
			break;
		case 2:
			teaseDisAI(rappers, rappersBeaten);
			break;
		}
	}

	public Main() {
		Rapper[] rappers = new Rapper[7];
		setupRappers(rappers);
		displayMenu();
		int choice = 0;
		getMenuChoice(choice, rappers);

	}

	public static void main(String[] args) {
		new Main();
	}

}
