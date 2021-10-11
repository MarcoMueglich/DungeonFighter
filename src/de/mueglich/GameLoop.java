package de.mueglich;

import java.util.Random;
import java.util.Scanner;

public class GameLoop {

    // System Objects
    static Scanner in = new Scanner(System.in);
    static Random rand = new Random();

    // Entity Variables
    static Player player;
    static Enemy enemy;

    public static void main(String[] args) {

        // Game Variables
        int damageDealt;
        int damageTaken;

        String input;
        String separator = "--------------------------------------";

        // Player Variable
        player = new Player();
        boolean running = true;

        System.out.println("###############################");
        System.out.println("# Welcome to Dungeon Fighter! #");
        System.out.println("###############################");

        // Game Loop
        GAME:
        while (running) {
            System.out.println(separator);
            enemy = getRandomEnemy();
            System.out.println("\t# " + enemy.getName() + " has appeared! #\n");

            // Fight Loop
            while (enemy.getHP() > 0) {
                printStatus();

                input = in.nextLine();

                //Attack Option
                if ("1".equals(input)) {
                    damageDealt = enemy.calcDamageTaken(player.calcDamageDealt());
                    damageTaken = player.calcDamageTaken(enemy.calcDamageDealt());
                    enemy.decreaseHP(damageDealt);
                    player.decreaseHP(damageTaken);

                    System.out.println("\tYou strike the " + enemy.getName() + " for " + damageDealt + " damage!");
                    System.out.println("\tYou receive " + damageTaken + " in retaliation!");

                    if (player.getHP() < 1) {
                        System.out.println("\tYou have taken too much damage, you are too weak to go on!");
                        break GAME;
                    }
                } else if ("2".equals(input)) {      // Potion Option
                    player.drinkPotion();
                } else if ("3".equals(input)) {      // Run Option
                    System.out.println("\tYou run away from the " + enemy.getName() + "!");
                    continue GAME;
                } else {
                    System.out.println("\tInvalid Input.");
                }
            }

            if (rand.nextInt(100) < enemy.getPotionDropChance()) {
                player.addPotion();
                System.out.println(" # The " + enemy.getName() + " dropped a health potion! # ");
                System.out.println(" # You now have " + player.getNumOfPotions() + " health potion(s).");
            }

            System.out.println(separator);
            System.out.println(" # " + enemy.getName() + " was defeated! # ");
            System.out.println(" # You have " + player.getHP() + " HP left. # ");

            System.out.println(separator);
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
            } else {
                System.out.println("You exit the dungeon, successful from your adventure!");
                running = false;
            }
        }
        System.out.println("#######################################");
        System.out.println("# Thanks for playing Dungeon Fighter! #");
        System.out.println("#######################################");
    }

    private static void printStatus() {
        System.out.println("\tYour HP: " + player.getHP());
        System.out.println("\t" + enemy.getName() + "´s HP: " + enemy.getHP());
        System.out.println("\t1. Attack");
        System.out.println("\t2. Drink health potion");
        System.out.println("\t3. Run!");
    }

    private static Enemy getRandomEnemy() {
        int n = rand.nextInt(4);

        if (n == 0) {
            return new Skeleton();
        } else if (n == 1) {
            return new Zombie();
        } else if (n == 2) {
            return new Assassin();
        } else {
            return new Warrior();
        }
    }
}
