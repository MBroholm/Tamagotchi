public class Cat extends Tamagotchi{
    private static final String ASCII_DEFAULT = """
                     /\\_/\\
                    ( o.o )
                     > ^ <""";
    private static final String ASCII_PLAYING = """
                    \\    /\\
                     )  ( ')
                    (  /  )_, _
                     \\(__)   (_)""";
    private static final String ASCII_FEEDING = """
                    
                    \\    /\\
                     )  ( ')
                    (  /  )  ___
                     \\(__)| /___\\
                    """;
    private static final String ASCII_SLEEPING = """
                     /\\_/\\ ZzzZzz
                    ( -.- )
                     > ^ <""";

    public Cat(String name){
        super(name);
        setAsciiState(ASCII_DEFAULT);
        setAsciiDefault(ASCII_DEFAULT);
        setAsciiPlaying(ASCII_PLAYING);
        setAsciiFeeding(ASCII_FEEDING);
        setAsciiSleeping(ASCII_SLEEPING);
        System.out.println("Wonderful! you have created a cat named "+name+"!");
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+" says Meow!");
    }
}
