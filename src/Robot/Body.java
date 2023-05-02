package Robot;

import java.util.ArrayList;
import java.util.List;

public class Body {
    private int HeadsCapacity = 3;
    private int HandsCapacity = 3;
    private int LegsCapacity = 3;
    List<Head> Heads = new ArrayList<>();
    List<Hand> Hands = new ArrayList<>();
    List<Leg> Legs = new ArrayList<>();


    private int Health = 100;
    private int HealingValue = 25;

    private int BasicDamage = 10;

    public Body() {
        Heads.add(new Head());
        Hands.add(new Hand());
        Legs.add(new Leg());
    }

    public int AddHead() {
        if (Heads.size() < HeadsCapacity) {
            Heads.add(new Head());
            return 0;
        }
        return 1;
    }

    public int AddHand() {
        if (Hands.size() < HandsCapacity) {
            Hands.add(new Hand());
            return 0;
        }
        return 1;
    }

    public int AddLeg() {
        if (Legs.size() < LegsCapacity) {
            Legs.add(new Leg());
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
        for (Head bp: Heads) {
            copy = bp.CalculateValue(copy);
        }
        for (Hand bp: Hands) {
            copy = bp.CalculateValue(copy);
        }

        return copy;
    }

    public void Healing() {
        int k = 1;
        for (Leg l: Legs) {
            k = l.CalculateValue(k);
        }

        Health += HealingValue * k;
        if (Health > 100) {
            Health = 100;
        }
    }

    public void UpgradeHeads() {
        for (Head h: Heads) {
            h.Upgrade(1);
        }
    }

    public void UpgradeHands() {
        for (Hand h: Hands) {
            h.Upgrade(1);
        }
    }

    public void UpgradeLegs() {
        for (Leg h: Legs) {
            h.Upgrade(1);
        }
    }

    public void PrintInfo() {
        for (Head h: Heads) {
            h.PrintLevel();
        }
        for (Hand h: Hands) {
            h.PrintLevel();
        }
        for (Leg l: Legs) {
            l.PrintLevel();
        }
        System.out.println("Health: " + Health);
    }
}
