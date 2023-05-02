package Robot;

public class Hand extends BodyPart implements BodyPartInterface{
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
    public void PrintLevel() {
        System.out.println("Hand bonus damage level: " + Level);
    }
}
