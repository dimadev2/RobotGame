package Robot;

public class Head extends BodyPart implements BodyPartInterface{
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
    public void PrintLevel() {
        System.out.println("Head Accuracy level: " + Level);
    }
}
