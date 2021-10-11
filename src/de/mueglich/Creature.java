package de.mueglich;

import java.util.Random;

public abstract class Creature {
    int hp;
    int armor;
    int maxAttackDamage;
    static Random rand = new Random();

    public int getHP() {
        return this.hp;
    }

    public void decreaseHP(int amount) {
        this.hp -= amount;
    }

    public void increaseHP(int amount) {
        this.hp += amount;
    }

    public int calcDamageDealt() {
        return rand.nextInt(this.maxAttackDamage);
    }

    public int calcDamageTaken(int damage) {
        if (damage - armor > 0) {
            return damage - armor;
        } else {
            return 0;
        }
    }

}
