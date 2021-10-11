package de.mueglich;

import java.util.Random;

public class Player extends Creature {

    private int numOfPotions;
    private final int healthPotionHealAmount;

    public Player() {
        this.hp = 100;
        this.armor = 5;
        this.maxAttackDamage = 50;
        this.numOfPotions = 5;
        this.healthPotionHealAmount = 30;
    }

    public void drinkPotion() {
        if (numOfPotions > 0) {
            numOfPotions--;
            this.increaseHP(healthPotionHealAmount);

            System.out.println("\tYou drink a health potion, healing yourself for " + this.healthPotionHealAmount + ".");
            System.out.println("\tYou now have " + this.hp + " HP.");
            System.out.println("\tYou have " + this.numOfPotions + " health potions");
        } else {
            System.out.println("\tYou have no potions left!");
        }
    }

    public int getNumOfPotions() {
        return numOfPotions;
    }

    public void addPotion() {
        this.numOfPotions++;
    }

}
