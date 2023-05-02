package Enemies;

public class Enemy {
    public int Damage = 10;
    public int Health = 100;

    public int GetDamage(int damage) {
        Health -= damage;
        if (Health <= 0)
            return 1;
        return 0;
    }

    public void PrintInfo() {
        System.out.println("Health: " + Health);
        System.out.println("Damage: " + Damage);
    }
}
