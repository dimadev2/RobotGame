package Robot;

public class Head extends BodyPart implements BodyPartInterface{
    {
        Level = 2;     // Accuracy
    }

    @Override
    public int CalculateValue(int value) {
        return value * Level;
    }

    @Override
    public void Upgrade(int levels) {
        Level += 3 * levels;
    }

    @Override
    public void PrintLevel() {
        System.out.println("Head Accuracy level: " + Level);
    }
}
