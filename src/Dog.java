public class Dog extends Tamagotchi{
    private static final String ASCII_DEFAULT = """
                      .-"-.
                     /|6 6|\\
                    {/(_0_)\\}
                     _/ ^ \\_
                    (/ /^\\ \\)-'
                     ""' '"\"""";
    private static final String ASCII_PLAYING = """
                                 .--~~,____ ,
                    :-....,-------`~~'.___.'
                     `-,,,  ,_      ;'~U'
                      _,-' ,'`-__; '--.
                     (_/'~~      ''''(;""";
    private static final String ASCII_FEEDING = """
                         __
                    (___()'`;
                    /,    /` ___
                    \\\\"--\\\\ /___\\""";
    private static final String ASCII_SLEEPING = """
                      .-"-.   Zzz
                     /|_ _|\\Zzz
                    {/(_0_)\\}
                     _/ ^ \\_
                    (/ /^\\ \\)-'
                     ""' '"\"""";


    public Dog(String name){
        super(name);
        setAsciiState(ASCII_DEFAULT);
        setAsciiDefault(ASCII_DEFAULT);
        setAsciiPlaying(ASCII_PLAYING);
        setAsciiFeeding(ASCII_FEEDING);
        setAsciiSleeping(ASCII_SLEEPING);

        System.out.println("Wonderful! you have created a dog named "+name+"!");
    }

    @Override
    public void makeSound() {
        System.out.println(getName()+" says Woof!");
    }
}
