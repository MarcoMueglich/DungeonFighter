package de.mueglich;

public class Zombie extends Enemy {
    public Zombie() {
        this.name = "Zombie";
        this.hp = 80;
        this.armor = 5;
        this.maxAttackDamage = 10;
        this.potionDropChance = 20;
    }
}
