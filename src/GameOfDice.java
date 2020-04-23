import java.util.Random;
import java.util.Scanner;

public class GameOfDice {
    public static void main(String[] args){
        //Starting by importing Scanner and Random class to access
        //during various sections of the game.
        Scanner scn = new Scanner(System.in);
        Random r = new Random();
        /*
        Pre game setup.
        Prompt user for the number of players. Max 4
        Prompt the user for the name of each player. Assign to
        player variables.
        if statements to separate games based on number of players.
         */
        String player_1;
        String roll_q = "";
        System.out.println("Initiate Game of Dice? y/n ");
        String initiate_GoD = scn.nextLine();
        while((initiate_GoD.equalsIgnoreCase("y"))&&(!roll_q.equalsIgnoreCase("q"))) {
            System.out.println("Welcome to Game of Dice ");
            System.out.println("Enter 'r' to view the rules or 's' to skip: ");
            String rules = scn.nextLine();
            while (rules.equalsIgnoreCase("r"))
            {
                System.out.println("Game of Dice: ");
                System.out.println("The order of the players is randomly selected.");
                System.out.println("Then each player takes their turn throwing the dice.");
                System.out.println("The totals of each dice roll are added to the players score.");
                System.out.println("If a player rolls a '1' on each die (also known as SNAKE EYES) \nthat players gets 25pts instead of 2.");
                System.out.println("If a player rolls a '1' on either die but doesn't roll a SNAKE EYES, \nthey lose their turn and gain 0pts");
                System.out.println("The first player to 100 wins!");
                System.out.println();
                System.out.println("Okay! So are you ready to play? y/n or 'r' to view rules again.");
                rules = scn.nextLine();
            }
            /*
            After all the players names have been recorded and the rules explained it's time to start the game
            depending on how many players were entered. player_1 starts and player_4 is last.
            */
            int dice_roll_1;        //Variables to hold values of both 'dice'
            int dice_roll_2;
            int player_1_score = 0; //Variables to store the score of each player.
/*
            Prompt user for player name to use in output messages.
            Prompt user to roll or quit.
 */
            System.out.println("Enter the name for ");
            System.out.print("player_1: ");
            player_1 = scn.nextLine();
            System.out.println("Alright "+player_1+" let's get started! You can quit at any time by entering 'q'");
            System.out.println("Enter 'roll' to roll the dice: ");
            roll_q = scn.nextLine();
            /*
            if condition to begin or ignore if user quit.
            do while loop to check for win conditions that would end the game after every iteration.
             */
            if(!roll_q.equalsIgnoreCase( "q")) {
                do {
                    /*
                    dice go from 1-6. r.nextInt(6) starts at 0  and ends at 5 so add 1 to result to get 1-6.
                     */
                    dice_roll_1 = 1 + r.nextInt(6);
                    dice_roll_2 = 1 + r.nextInt(6);
                    System.out.println(dice_roll_1);
                    System.out.println(dice_roll_2);
                    /*
                    Snake Eyes (1,1) Condition first to avoid repetition.
                    If else to check (1,x!=1) and (x!=1,1).
                    Else add the sum of the dice to the player score.
                     */
                    if ((dice_roll_1 == 1)&&(dice_roll_2 == 1)) {
                        System.out.println("SNAKE EYES!");
                        player_1_score += 25;
                        System.out.println(player_1 + " Score: " + player_1_score);
                       }
                    else if ((dice_roll_1 == 1)||(dice_roll_2 == 1))
                       {
                           System.out.println("Sorry! You gained no points this turn!");
                       }
                    else
                       {
                           player_1_score += dice_roll_1+dice_roll_2;
                           System.out.println(player_1+"Score: "+player_1_score);
                       }
                    /*
                    Conditions for end of game or continuation of game messages and prompts.
                     */
                       if (player_1_score < 100) {
                           System.out.println("Enter 'roll' to roll again: ");
                           roll_q = scn.nextLine();
                       }
                       else{
                           System.out.println("You did it! You got to 100!");
                           System.out.println("Would you like to play again?");
                           initiate_GoD = scn.nextLine();
                       }
                   } while ((!roll_q.equalsIgnoreCase("q"))&&(player_1_score < 100));
               }

        }
    }
}
