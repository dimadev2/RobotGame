package org.example.Game;

import org.example.Game.Enemies.Enemy;
import org.example.Game.Robot.Body;
import org.example.Main;


import java.util.Scanner;

public class Game {
    private Body Robot = new Body();
    private Enemy e = new Enemy(10, 20);
    private int EnemyCounter = 1;
    private boolean IsBoss = false;
    private int Coins = 0;
    private Scanner in = new Scanner(System.in);
    public boolean IsEnd = false;

//    public void Start() {
//        int dead = 0;
//        while (dead != 0) {
//            ;
//        }
//    }

    public String Update(int choice) {
//        for (int i = 0; i < 28; i++) {
//            System.out.println();
//        }

        String answer = "";

        if (choice == 1) {
            if (e.GetDamage(Robot.GiveDamage()) == 1) {
                answer += "Enemy defeated! Gain 1 coin\n";
                EnemyCounter++;

                if (IsBoss) {
                    Coins += 10;
                }
                else {
                    Coins += 2;
                }

                if (EnemyCounter % 20 == 0) {
                    int health = (int)(Math.random() * 20) + 80;
                    int damage = (int)(Math.random() * 20) + 50;
                    e = new Enemy(damage * (EnemyCounter / 20 + 1), health * (EnemyCounter / 20 + 1));
                    IsBoss = true;
                }
                else {
                    int health = (int)(Math.random() * 15) + 10;
                    int damage = (int)(Math.random() * 10) + 5;
                    e = new Enemy(damage * (EnemyCounter / 20 + 1), health * (EnemyCounter / 20 + 1));
                    IsBoss = false;
                }
            }
        }
        else if (choice == 2) {
            Robot.Healing();
        }
        else if (choice == 3) {
            if (Coins >= 3) {
                if (Robot.AddHead() == 1) {
                    answer += "Max Head limit!\n";
                }
                else {
                    answer += "New Head gain!\n";
                    Coins -= 3;
                }
            }
            else {
                answer += "Not enough Coins!\n";
            }
        }
        else if (choice == 4) {
            if (Coins >= 2) {
                if (Robot.AddHand() == 1) {
                    answer += "Max Hand limit!\n";
                }
                else {
                    answer += "New Hand gain!\n";
                    Coins -= 2;
                }
            }
            else {
                answer += "Not enough Coins!\n";
            }
        }
        else if (choice == 5) {
            if (Coins >= 5) {
                if (Robot.AddLeg() == 1) {
                    answer += "Max Leg limit!\n";
                }
                else {
                    answer += "New Leg gain!\n";
                    Coins -= 5;
                }
            }
            else {
                answer += "Not enough Coins!\n";
            }
        }
        else if (choice == 6) {
            if (Coins >= 10) {
                Robot.UpgradeHeads();
                Coins -= 10;
                answer += "Heads Upgraded!\n";
            }
        }
        else if (choice == 7) {
            if (Coins >= 10) {
                Robot.UpgradeHands();
                Coins -= 10;
                answer += "Hands Upgraded!\n";
            }
        }
        else if (choice == 8) {
            if (Coins >= 10) {
                Robot.UpgradeLegs();
                Coins -= 10;
                answer += "Legs Upgraded!\n";
            }
        }

        if (Robot.GetDamage(e.Damage) == 1) {
            answer += "You are dead!\n";
            IsEnd = true;
        }

        return answer;
    }

    public String Preambula() {
        String answer = "";

        if (IsBoss)
            answer += "You meet the Boss:\n";
        else
            answer += "You meet the Enemy:\n";

        answer += e.PrintInfo();
        answer += "\n";
        answer += "Your robot:\n";
        answer += Robot.PrintInfo();
        answer += "\n";

        answer += ("Coins: " + Coins + "\n");

        answer += "\n";
        answer += "What would you do?\n";
        answer += "1 - Attack\n";
        answer += "2 - Heal\n";
        answer += "3 - Get new Head (3 coins)\n";
        answer += "4 - Get new Hand (2 coins)\n";
        answer += "5 - Get new Leg (5 coins)\n";
        answer += "6 - Upgrade Heads (10 coins)\n";
        answer += "7 - Upgrade Hands (10 coins)\n";
        answer += "8 - Upgrade Legs (10 coins)\n";

        return answer;
    }
}
