package org.example.Game.Robot;

import java.util.ArrayList;
import java.util.List;
import org.example.Game.Robot.*;

public class Body {
    private int HeadsCapacity = 3;
    private int HandsCapacity = 3;
    private int LegsCapacity = 3;
    List<Game.Robot.Head> Heads = new ArrayList<>();
    List<Game.Robot.Hand> Hands = new ArrayList<>();
    List<Game.Robot.Leg> Legs = new ArrayList<>();


    private int Health = 100;
    private int HealingValue = 25;

    private int BasicDamage = 10;

    public Body() {
        Heads.add(new Game.Robot.Head());
        Hands.add(new Game.Robot.Hand());
        Legs.add(new Game.Robot.Leg());
    }

    public int AddHead() {
        if (Heads.size() < HeadsCapacity) {
            Heads.add(new Game.Robot.Head());
            return 0;
        }
        return 1;
    }

    public int AddHand() {
        if (Hands.size() < HandsCapacity) {
            Hands.add(new Game.Robot.Hand());
            return 0;
        }
        return 1;
    }

    public int AddLeg() {
        if (Legs.size() < LegsCapacity) {
            Legs.add(new Game.Robot.Leg());
            return 0;
        }
        return 1;
    }

    public int GetDamage(int damage) {
        Health -= damage;
        if (Health <= 0)
            return 1;
        return 0;
    }

    public int GiveDamage() {
        int copy = BasicDamage;
        for (Game.Robot.Head bp: Heads) {
            copy = bp.CalculateValue(copy);
        }
        for (Game.Robot.Hand bp: Hands) {
            copy = bp.CalculateValue(copy);
        }

        return copy;
    }

    public void Healing() {
        int k = 1;
        for (Game.Robot.Leg l: Legs) {
            k = l.CalculateValue(k);
        }

        Health += HealingValue * k;
        if (Health > 100) {
            Health = 100;
        }
    }

    public void UpgradeHeads() {
        for (Game.Robot.Head h: Heads) {
            h.Upgrade(1);
        }
    }

    public void UpgradeHands() {
        for (Game.Robot.Hand h: Hands) {
            h.Upgrade(1);
        }
    }

    public void UpgradeLegs() {
        for (Game.Robot.Leg h: Legs) {
            h.Upgrade(1);
        }
    }

    public String PrintInfo() {
        String answer = "";

        for (Game.Robot.Head h: Heads) {
            answer += h.PrintLevel();
        }
        for (Game.Robot.Hand h: Hands) {
            answer += h.PrintLevel();
        }
        for (Game.Robot.Leg l: Legs) {
            answer += l.PrintLevel();
        }
        answer += "Health: " + Health;

        return answer;
    }
}
