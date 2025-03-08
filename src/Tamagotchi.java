import java.util.Random;

public class Tamagotchi {
    private static final String ASCII_TOMBSTONE = """
                        .--'''--.
                      .'         `.
                      |  R  I  P  |
                      |           |
                      |           |
                    \\\\|           |//""";

    private static final int MAX_STAT = 10;
    private static final int MIN_STAT = 0;

    private String asciiState;
    private String asciiDefault;
    private String asciiPlaying;
    private String asciiFeeding;
    private String asciiSleeping;

    private String name;
    private int mood;
    private int energy;
    private int hunger;
    private boolean isAlive;

    //Constructor
    public Tamagotchi(String name){
        this.name = name;
        Random random = new Random();
        this.mood = random.nextInt(MAX_STAT)+1;
        this.energy = random.nextInt(MAX_STAT)+1;
        this.hunger = random.nextInt(MAX_STAT-2)+1; //max 8 so pet doesn't die instantly
        this.isAlive = true;
    }

    //Getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setAsciiState(String ascii){
        this.asciiState = ascii;
    }

    public void setAsciiDefault(String ascii) {
        this.asciiDefault = ascii;
    }

    public void setAsciiPlaying(String ascii) {
        this.asciiPlaying = ascii;
    }

    public void setAsciiFeeding(String ascii) {
        this.asciiFeeding = ascii;
    }
    public void setAsciiSleeping(String ascii) {
        this.asciiSleeping = ascii;
    }

    //Method for displaying stats
    public void displayState(){
        System.out.println(asciiState);
        asciiState=asciiDefault;
        System.out.print("Mood:"+statBar(mood)+" ");
        System.out.print("Energy:"+statBar(energy)+" ");
        System.out.println("Hunger:"+statBar(hunger)+" ");
        System.out.println();
    }

    //Method returning String stat bar
    public String statBar(int stat){
        StringBuilder str = new StringBuilder("[");
        for(int i=MIN_STAT; i<MAX_STAT; i++){
            str.append((i < stat) ? '*' : ' ');
        }
        str.append(']');

        return str.toString();
    }

    //Method invoking consequences of stat-values
    public void controlState(){
        if(hunger > MAX_STAT){ //If hunger goes above max, pet will die.
            this.isAlive=false;
            System.out.println(ASCII_TOMBSTONE);
            System.out.println(name+" died of starvation...");
        } else if (hunger>MAX_STAT-2) { //Warn when hunger gets close to max
            makeSound();
            System.out.println("When did you last feed them?");
        }
    }

    //Actions
    public void play(){
        if(energy<=MIN_STAT+1){
            System.out.println(name+" is too tired...");
            mood = Math.max(mood-2,MIN_STAT);
            sleep();
        }else{
            asciiState = asciiPlaying;
            System.out.println(name+" is playing!");
            mood = Math.min(mood+2,MAX_STAT);
            energy = Math.max(energy-2,MIN_STAT);
            hunger++;
        }
    }

    public void feed(){
        if(energy<=MIN_STAT){
            System.out.println(name+" is too tired...");
            mood = Math.max(mood-2,MIN_STAT);
            sleep();
        }else if(hunger<=MIN_STAT){
            asciiState = asciiDefault;
            System.out.println(name+" is not hungry...");
            mood = Math.max(mood-1,MIN_STAT);
        }else{
            asciiState = asciiFeeding;
            System.out.println(name+" is eating...");
            hunger = Math.max(hunger-1, MIN_STAT);
            energy = Math.max(energy-1, MIN_STAT);
        }
    }

    public void sleep(){
        if(energy>=MAX_STAT-1){
            asciiState = asciiDefault;
            System.out.println(name+" has too much energy, and can't go to sleep!");
        }else{
            asciiState = asciiSleeping;
            System.out.println("Zzz... "+name+" is sleeping...");
            energy=MAX_STAT;
            hunger+=2;
        }
    }

    void makeSound() {

    }
}
