package Robot;

public class Leg extends BodyPart implements BodyPartInterface {
    {
        Level = 5;      // Healing
    }

    @Override
    public int CalculateValue(int value) {
        return Level * value / 2;
    }

    @Override
    public void Upgrade(int levels) {
        Level += levels;
    }

    @Override
    public void PrintLevel() {
        System.out.println("Leg Healing level: " + Level);
    }
}
