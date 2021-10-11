package archive;

import java.util.Random;
import java.util.Scanner;

public class GameLoop {

    // System Objects
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {

        // Game Variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin"};
        int enemyHealth;
        String enemy;
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;
        int damageDealt;
        int damageTaken;

        String input;
        String seperator = "--------------------------------------";

        // Player Variables
        int playerHealth = 100;
        int playerAttackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 10; //Percentage


        boolean running = true;

        System.out.println("Welcome to Dungeon Fighter!");

        GAME:
        while (running) {
            System.out.println(seperator);
            enemyHealth = rand.nextInt(maxEnemyHealth);
            enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP: " + playerHealth);
                System.out.println("\t" + enemy + "´s HP: " + enemyHealth);
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink health potion");
                System.out.println("\t3. Run!");

                input = in.nextLine();

                if (input.equals("1")) {            // ATTACK
                    damageDealt = rand.nextInt(playerAttackDamage);
                    damageTaken = rand.nextInt(enemyAttackDamage);
                    enemyHealth -= damageDealt;
                    playerHealth -= damageTaken;

                    System.out.println("\tYou strike the " + enemy + " for " + damageDealt + " damage!");
                    System.out.println("\tYou receive " + damageTaken + " in retaliation!");

                    if (playerHealth < 1) {
                        System.out.println("\tYou have taken too much damage, you are too weak to go on!");
                        break;
                    }
                } else if (input.equals("2")) {     // POTION
                    if (numHealthPotions > 0) {
                        numHealthPotions--;
                        playerHealth += healthPotionHealAmount;

                        System.out.println("\tYou drink a health potion, healing yourself for " + healthPotionHealAmount + ".");
                        System.out.println("\tYou now have " + playerHealth + " HP.");
                        System.out.println("\tYou have " + numHealthPotions + " health potions");
                    } else {
                        System.out.println("\tYou have no potions left!");
                    }
                } else if (input.equals("3")) {     // RUN
                    System.out.println("\tYou run away from the " + enemy + "!");
                    continue GAME;
                } else {
                    System.out.println("\tInvalid Input.");
                }

                if (playerHealth < 1) {
                    System.out.println("You limp out of the dungeon, weak from the battle.");
                    break;
                }


                if (rand.nextInt(100) < healthPotionDropChance) {
                    numHealthPotions++;
                    System.out.println(" # The " + enemy + " dropped a health potion! # ");
                    System.out.println(" # You now have " + numHealthPotions + " health potion(s).");
                }
            }
            System.out.println(seperator);
            System.out.println(" # " + enemy + " was defeated! # ");
            System.out.println(" # You have " + playerHealth + " HP left. # ");

            System.out.println(seperator);
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit dungeon");

            input = in.nextLine();
            while (!input.equals("1") && !(input.equals("2"))) {
                System.out.println("Invalid Command!");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("You continue your adventure!");
            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventure!");
                break;
            }
        }
        System.out.println("#######################################");
        System.out.println("# Thanks for playing Dungeon Fighter! #");
        System.out.println("#######################################");
    }
}
