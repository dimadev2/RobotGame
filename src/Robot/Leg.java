package Robot;

public class Leg extends BodyPart implements BodyPartInterface {
    {
        Level = 1;      // Healing
    }

    @Override
    public int CalculateValue(int value) {
        return Level * value;
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
