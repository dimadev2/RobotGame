package org.example.Game.Enemies;

public class Enemy {
    public int Damage = 10;
    public int Health = 20;

    public Enemy(int damage, int health) {
        Damage = damage;
        Health = health;
    }

    public int GetDamage(int damage) {
        Health -= damage;
        if (Health <= 0)
            return 1;
        return 0;
    }

    public String PrintInfo() {
        String answer = "";
        answer += "Health: " + Health + "\n";
        answer += "Damage: " + Damage + "\n";

        return answer;
    }
}
