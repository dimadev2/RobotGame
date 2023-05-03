package Game.Robot;

import Game.Robot.BodyPart;
import Game.Robot.BodyPartInterface;

public class Hand extends BodyPart implements BodyPartInterface {
    {
        Level = 1;     // Bonus damage
    }

    @Override
    public int CalculateValue(int value) {
        return value * (Level / 10 + 1);
    }

    @Override
    public void Upgrade(int levels) {
        Level += levels;
    }

    @Override
    public String PrintLevel() {
        return "Hand bonus damage level: " + Level + "\n";
    }
}
