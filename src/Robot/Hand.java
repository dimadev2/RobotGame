package Robot;

public class Hand extends BodyPart implements BodyPartInterface{
    {
        Level = 5;     // Bonus damage
    }

    @Override
    public int CalculateValue(int value) {
        return value * (Level / 100 + 1);
    }

    @Override
    public void Upgrade(int levels) {
        Level += 5 * levels;
    }

    @Override
    public void PrintLevel() {
        System.out.println("Hand bonus damage level: " + Level);
    }
}
