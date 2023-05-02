import Enemies.Boss;
import Enemies.Enemy;
import Robot.Body;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Runtime.getRuntime;

class Game {
    private Body Robot = new Body();
    private Enemy e = new Enemy(10, 20);
    private int EnemyCounter = 1;
    private int Coins = 0;
    private Scanner in = new Scanner(System.in);

    void Start() {
        while (Update() != 1) {}
    }

    private int Update() {
        if (e instanceof Boss)
            System.out.println("You meet the Boss:");
        else
            System.out.println("You meet the Enemy:");

        e.PrintInfo();
        System.out.println();
        System.out.println("Your robot:");
        Robot.PrintInfo();
        System.out.println();

        System.out.println("Coins: " + Coins);

        System.out.println();
        System.out.println("What would you do?");
        System.out.println("1 - Attack");
        System.out.println("2 - Heal");
        System.out.println("3 - Get new Head (3 coins)");
        System.out.println("4 - Get new Hand (2 coins)");
        System.out.println("5 - Get new Leg (5 coins)");
        System.out.println("6 - Upgrade Heads (10 coins)");
        System.out.println("7 - Upgrade Hands (10 coins)");
        System.out.println("8 - Upgrade Legs (10 coins)");

        int choice = in.nextInt();

        for (int i = 0; i < 28; i++) {
            System.out.println();
        }

        if (choice == 1) {
            if (e.GetDamage(Robot.GiveDamage()) == 1) {
                System.out.println("Enemy defeated! Gain 1 coin");
                EnemyCounter++;

                if (e instanceof Boss) {
                    Coins += 10;
                }
                else {
                    Coins += 2;
                }

                if (EnemyCounter % 20 == 0)
                    e = new Boss(60 * (EnemyCounter / 20 + 1), 100 * (EnemyCounter / 20 + 1));
                else
                    e = new Enemy(10 * (EnemyCounter / 20 + 1), 20 * (EnemyCounter / 20 + 1));
            }
        }
        else if (choice == 2) {
            Robot.Healing();
        }
        else if (choice == 3) {
            if (Coins >= 3) {
                if (Robot.AddHead() == 1) {
                    System.out.println("Max Head limit!");
                }
                else {
                    System.out.println("New Head gain!");
                    Coins -= 3;
                }
            }
            else {
                System.out.println("Not enough Coins!");
            }
        }
        else if (choice == 4) {
            if (Coins >= 2) {
                if (Robot.AddHand() == 1) {
                    System.out.println("Max Hand limit!");
                }
                else {
                    System.out.println("New Hand gain!");
                    Coins -= 2;
                }
            }
            else {
                System.out.println("Not enough Coins!");
            }
        }
        else if (choice == 5) {
            if (Coins >= 5) {
                if (Robot.AddLeg() == 1) {
                    System.out.println("Max Leg limit!");
                }
                else {
                    System.out.println("New Leg gain!");
                    Coins -= 5;
                }
            }
            else {
                System.out.println("Not enough Coins!");
            }
        }
        else if (choice == 6) {
            if (Coins >= 10) {
                Robot.UpgradeHeads();
                Coins -= 10;
                System.out.println("Heads Upgraded!");
            }
        }
        else if (choice == 7) {
            if (Coins >= 10) {
                Robot.UpgradeHands();
                Coins -= 10;
                System.out.println("Hands Upgraded!");
            }
        }
        else if (choice == 8) {
            if (Coins >= 10) {
                Robot.UpgradeLegs();
                Coins -= 10;
                System.out.println("Legs Upgraded!");
            }
        }

        if (Robot.GetDamage(e.Damage) == 1) {
            System.out.println("You are dead!");
            return 1;
        }

        return 0;
    }
}
