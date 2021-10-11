package de.mueglich;

public abstract class Enemy extends Creature {
    String name;
    int potionDropChance;

    public int getPotionDropChance() {
        return this.potionDropChance;
    }

    public String getName() {
        return name;
    }
}
