package Game.Robot;

import Game.Robot.BodyPart;
import Game.Robot.BodyPartInterface;

public class Head extends BodyPart implements BodyPartInterface {
    {
        Level = 1;     // Accuracy
    }

    @Override
    public int CalculateValue(int value) {
        return value * Level / 3;
    }

    @Override
    public void Upgrade(int levels) {
        Level += levels;
    }

    @Override
    public String PrintLevel() {
        return "Head Accuracy level: " + Level + "\n";
    }
}
