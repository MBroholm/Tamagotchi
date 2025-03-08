import java.util.Scanner;

public class Game {
    private final Scanner input;
    private Tamagotchi pet;

    public Game(){
        this.input = new Scanner(System.in);
        this.pet = createTamagotchi();
    }

    public Tamagotchi createTamagotchi(){
        //Prompt pet choice
        System.out.println("Hello, what type of pet would you like to create? " +
                "Press [1] for dog, [2] for cat, or [3]...?");

        int petChoice = getIntInRange(1,3);

        //Prompt name choice
        System.out.println("What would you like to name it?");
        String name=input.nextLine();

        //returns corresponding Tamagotchi-object
        return switch(petChoice){
            case 1 -> new Dog(name);
            case 2 -> new Cat(name);
            case 3 -> new Pikachu(name);
            default -> null;
        };
    }

    //Action menu
    public void takeAction(){
        System.out.println("What would you like to do?");
        System.out.println("[1] - play");
        System.out.println("[2] - feed");
        System.out.println("[3] - sleep");
        System.out.println("[4] - options");
        System.out.println("[5] - exit");

        int action = getIntInRange(1,5);

        switch (action){
            case 1 -> pet.play();
            case 2 -> pet.feed();
            case 3 -> pet.sleep();
            case 4 -> options();
            case 5 -> {
                System.out.println("Exiting...");
                input.close();
                pet.setAlive(false);
            }
        }
    }

    //option menu
    public void options(){
        System.out.println("Options:");
        System.out.println("[1] - rename");
        System.out.println("[2] - reset pet");
        int action = getIntInRange(1,2);

        switch (action){
            case 1 -> rename();
            case 2 -> pet = createTamagotchi();
        }
    }

    public void rename(){
        System.out.println("Type new name:");
        String name = input.nextLine();
        pet.setName(name);
        System.out.println("Your pet is now named "+pet.getName()+"!");
    }

    //Helper method, scans for input and validates that input is int and in range
    public int getIntInRange(int min, int max){
        int result;

        while (true) {
            if (input.hasNextInt()) { // Checks if user entered a valid int
                result = input.nextInt(); // Reads the int
                if (result >= min && result <= max) break; // Validates pet selection
            }

            System.out.println("Invalid input. Press number between "+min+" and "+max+".");
            input.nextLine(); // Consume invalid input
        }
        input.nextLine(); // Consume newline

        return result;
    }

    public void playGame() {
        while(pet.getAlive()){ //repeat while pet is alive
            pet.displayState();
            takeAction();
            pet.controlState();
        }
    }

}
