package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the amount of money that you start with: ");
		int startAmount = in.nextInt();
		System.out.println("Enter the probability that you win a single play (between 0 and 1): ");
		double winChance = in.nextDouble();
		System.out.println("Enter your winning limit for the day: ");
		int winLimit = in.nextInt();
		int totalSimulations = 0;
		double losses = 0;
		double alpha = (1 - winChance) / winChance;
		double expRate;
		if (winChance == 0.5)
		{
			expRate = 1 -(startAmount / winLimit);
		}
		else
		{
			expRate = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow(alpha, winLimit));
		}
		if (startAmount < winLimit)
		{
			while (startAmount > 0 && startAmount < winLimit)
			{
				double roundChance = Math.random();
				if (roundChance <= winChance)
				{
					startAmount++;
					totalSimulations++;
					System.out.println("Simulation " + totalSimulations + ": WIN, now have " + startAmount);
				}
				else
				{
					startAmount--;
					totalSimulations++;
					losses++;
					System.out.println("Simulation " + totalSimulations + ": LOSE, now have " + startAmount);
				}
			}
		}

		if (startAmount == winLimit)
		{
			System.out.println("Done gambling, you win!");
			double ruinRate = losses / totalSimulations;
			System.out.println("Losses: " + losses + " Simulations: " + totalSimulations);
			System.out.println("Ruin Rate from Simulation: " + ruinRate);
			System.out.println("Expected Ruin Rate: " + expRate);
		}
		else
		{
			System.out.println("Ruin!");
			double ruinRate = losses / totalSimulations;
			System.out.println("Losses: " + losses + " Simulations: " + totalSimulations);
			System.out.println("Ruin Rate from Simulation: " + ruinRate);
			System.out.println("Expected Ruin Rate: " + expRate);
		}
	}

}
