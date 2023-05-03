package org.example.Game.Robot;

import Game.Robot.BodyPart;
import Game.Robot.BodyPartInterface;

public class Leg extends BodyPart implements BodyPartInterface {
    {
        Level = 1;      // Healing
    }

    @Override
    public int CalculateValue(int value) {
        return (int)(Level * value * 1.2);
    }

    @Override
    public void Upgrade(int levels) {
        Level += levels;
    }

    @Override
    public String PrintLevel() {
        return "Leg Healing level: " + Level + "\n";
    }
}
