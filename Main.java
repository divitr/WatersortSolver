import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;

public class Main 
{
    //private ArrayList<String> steps = new ArrayList<String>();
    static int FULL = -1;
    static ArrayList<Tube> allTubes = new ArrayList<Tube>();
    

    static void test()
    {
        Tube tube1 = new Tube("tube1", Colors.YELLOW, Colors.EMPTY, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube1);
        Tube tube2 = new Tube("tube2", Colors.YELLOW, Colors.YELLOW, Colors.YELLOW, Colors.EMPTY);
        allTubes.add(tube2);
        allTubes.get(0).draw2();
        allTubes.get(1).draw2();
        //Transfer(allTubes.get(1), allTubes.get(0));
        allTubes.get(0).draw2();
        allTubes.get(1).draw2();
        //System.out.println(AmIDone());

    }

    static void baseline_Papa()
    {
        Tube tube1 = new Tube("tube1", Colors.PURPLE, Colors.INDIGO, Colors.YELLOW, Colors.GREY);
        allTubes.add(tube1);
        Tube tube2 = new Tube("tube2", Colors.ORANGE, Colors.YELLOW, Colors.DARK_GREEN, Colors.RED);
        allTubes.add(tube2);
        Tube tube3 = new Tube("tube3", Colors.GREEN, Colors.LIGHT_BLUE, Colors.ORANGE, Colors.YELLOW);
        allTubes.add(tube3);
        Tube tube4 = new Tube("tube4", Colors.GREEN, Colors.ORANGE, Colors.DARK_BLUE, Colors.ORANGE);
        allTubes.add(tube4);
        Tube tube5 = new Tube("tube5", Colors.RED, Colors.DARK_GREEN, Colors.INDIGO, Colors.PINK);
        allTubes.add(tube5);
        Tube tube6 = new Tube("tube6", Colors.LIGHT_BLUE, Colors.LIGHT_GREEN, Colors.PURPLE, Colors.DARK_GREEN);
        allTubes.add(tube6);
        Tube tube7 = new Tube("tube7", Colors.PURPLE, Colors.DARK_GREEN, Colors.GREEN, Colors.PURPLE);
        allTubes.add(tube7);
        Tube tube8 = new Tube("tube8", Colors.DARK_BLUE, Colors.DARK_BLUE, Colors.LIGHT_BLUE, Colors.DARK_BLUE);
        allTubes.add(tube8);
        Tube tube9 = new Tube("tube9", Colors.LIGHT_GREEN, Colors.RED, Colors.PINK, Colors.YELLOW);
        allTubes.add(tube9);
        Tube tube10 = new Tube("tube10", Colors.PINK, Colors.PINK, Colors.INDIGO, Colors.INDIGO);
        allTubes.add(tube10);
        Tube tube11 = new Tube("tube11", Colors.GREY, Colors.GREY, Colors.LIGHT_BLUE, Colors.LIGHT_GREEN);
        allTubes.add(tube11);
        Tube tube12 = new Tube("tube12", Colors.GREY, Colors.RED, Colors.GREEN, Colors.LIGHT_GREEN);
        allTubes.add(tube12);
        Tube tube13 = new Tube("tube13", Colors.EMPTY, Colors.EMPTY, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube13);
        Tube tube14 = new Tube("tube14", Colors.EMPTY, Colors.EMPTY, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube14);
    }

    
    static void testing1()
    {
        Tube tube1 = new Tube("tube1", Colors.GREY, Colors.GREY, Colors.ORANGE, Colors.PINK);
        allTubes.add(tube1);
        Tube tube2 = new Tube("tube2", Colors.PINK, Colors.PINK, Colors.GREEN, Colors.RED);
        allTubes.add(tube2);
        Tube tube3 = new Tube("tube3", Colors.INDIGO, Colors.DARK_GREEN, Colors.YELLOW, Colors.PURPLE);
        allTubes.add(tube3);
        Tube tube4 = new Tube("tube4", Colors.LIGHT_BLUE, Colors.DARK_BLUE, Colors.DARK_GREEN, Colors.EMPTY);
        allTubes.add(tube4);
        Tube tube5 = new Tube("tube5", Colors.PURPLE, Colors.GREEN, Colors.ORANGE, Colors.DARK_BLUE);
        allTubes.add(tube5);
        Tube tube6 = new Tube("tube6", Colors.LIGHT_GREEN, Colors.YELLOW, Colors.RED, Colors.LIGHT_BLUE);
        allTubes.add(tube6);
        Tube tube7 = new Tube("tube7", Colors.YELLOW, Colors.LIGHT_GREEN, Colors.YELLOW, Colors.EMPTY);
        allTubes.add(tube7);
        Tube tube8 = new Tube("tube8", Colors.PINK, Colors.RED, Colors.GREEN, Colors.GREEN);
        allTubes.add(tube8);
        Tube tube9 = new Tube("tube9", Colors.RED, Colors.LIGHT_BLUE, Colors.PURPLE, Colors.GREY);
        allTubes.add(tube9);
        Tube tube10 = new Tube("tube10", Colors.GREY, Colors.DARK_GREEN, Colors.DARK_BLUE, Colors.PURPLE);
        allTubes.add(tube10);
        Tube tube11 = new Tube("tube11", Colors.ORANGE, Colors.LIGHT_GREEN, Colors.DARK_GREEN, Colors.EMPTY);
        allTubes.add(tube11);
        Tube tube12 = new Tube("tube12", Colors.ORANGE, Colors.LIGHT_GREEN, Colors.DARK_BLUE, Colors.LIGHT_BLUE);
        allTubes.add(tube12);
        Tube tube13 = new Tube("tube13", Colors.INDIGO, Colors.INDIGO, Colors.INDIGO, Colors.EMPTY);
        allTubes.add(tube13);
        Tube tube14 = new Tube("tube14", Colors.EMPTY, Colors.EMPTY, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube14);
    }

    
    static void puzzle508()
    {
        Tube tube1 = new Tube("tube1", Colors.LIGHT_GREEN, Colors.LIGHT_GREEN, Colors.GREEN, Colors.DARK_BLUE);
        allTubes.add(tube1);
        Tube tube2 = new Tube("tube2", Colors.ORANGE, Colors.LIGHT_GREEN, Colors.RED, Colors.ORANGE);
        allTubes.add(tube2);
        Tube tube3 = new Tube("tube3", Colors.GREEN, Colors.DARK_GREEN, Colors.RED, Colors.INDIGO);
        allTubes.add(tube3);
        Tube tube4 = new Tube("tube4", Colors.PURPLE, Colors.ORANGE, Colors.LIGHT_GREEN, Colors.PURPLE);
        allTubes.add(tube4);
        Tube tube5 = new Tube("tube5", Colors.GREY, Colors.INDIGO, Colors.LIGHT_BLUE, Colors.PINK);
        allTubes.add(tube5);
        Tube tube6 = new Tube("tube6", Colors.DARK_GREEN, Colors.GREY, Colors.RED, Colors.ORANGE);
        allTubes.add(tube6);
        Tube tube7 = new Tube("tube7", Colors.LIGHT_BLUE, Colors.DARK_GREEN, Colors.PURPLE, Colors.YELLOW);
        allTubes.add(tube7);
        Tube tube8 = new Tube("tube8", Colors.DARK_BLUE, Colors.PINK, Colors.DARK_GREEN, Colors.GREEN);
        allTubes.add(tube8);
        Tube tube9 = new Tube("tube9", Colors.LIGHT_BLUE, Colors.GREY, Colors.YELLOW, Colors.GREEN);
        allTubes.add(tube9);
        Tube tube10 = new Tube("tube10", Colors.PINK, Colors.INDIGO, Colors.LIGHT_BLUE, Colors.PURPLE);
        allTubes.add(tube10);
        Tube tube11 = new Tube("tube11", Colors.DARK_BLUE, Colors.YELLOW, Colors.RED, Colors.INDIGO);
        allTubes.add(tube11);
        Tube tube12 = new Tube("tube12", Colors.PINK, Colors.GREY, Colors.YELLOW, Colors.DARK_BLUE);
        allTubes.add(tube12);
        Tube tube13 = new Tube("tube13", Colors.EMPTY, Colors.EMPTY, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube13);
        Tube tube14 = new Tube("tube14", Colors.EMPTY, Colors.EMPTY, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube14);
    }

    
    static void puzzle605()
    {
        Tube tube1 = new Tube("tube1", Colors.GREEN, Colors.LIGHT_BLUE, Colors.GREY, Colors.INDIGO);
        allTubes.add(tube1);
        Tube tube2 = new Tube("tube2", Colors.LIGHT_BLUE, Colors.PINK, Colors.LIGHT_GREEN, Colors.YELLOW);
        allTubes.add(tube2);
        Tube tube3 = new Tube("tube3", Colors.YELLOW, Colors.DARK_GREEN, Colors.INDIGO, Colors.GREEN);
        allTubes.add(tube3);
        Tube tube4 = new Tube("tube4", Colors.RED, Colors.PURPLE, Colors.ORANGE, Colors.LIGHT_GREEN);
        allTubes.add(tube4);
        Tube tube5 = new Tube("tube5", Colors.INDIGO, Colors.DARK_GREEN, Colors.BLUE, Colors.BLUE);
        allTubes.add(tube5);
        Tube tube6 = new Tube("tube6", Colors.YELLOW, Colors.GREY, Colors.GREEN, Colors.GREEN);
        allTubes.add(tube6);
        Tube tube7 = new Tube("tube7", Colors.RED, Colors.DARK_GREEN, Colors.INDIGO, Colors.ORANGE);
        allTubes.add(tube7);
        Tube tube8 = new Tube("tube8", Colors.LIGHT_GREEN, Colors.RED, Colors.DARK_GREEN, Colors.PINK);
        allTubes.add(tube8);
        Tube tube9 = new Tube("tube9", Colors.PINK, Colors.PURPLE, Colors.RED, Colors.PURPLE);
        allTubes.add(tube9);
        Tube tube10 = new Tube("tube10", Colors.PINK, Colors.YELLOW, Colors.BLUE, Colors.ORANGE);
        allTubes.add(tube10);
        Tube tube11 = new Tube("tube11", Colors.LIGHT_BLUE, Colors.LIGHT_BLUE, Colors.BLUE, Colors.LIGHT_GREEN);
        allTubes.add(tube11);
        Tube tube12 = new Tube("tube12", Colors.GREY, Colors.ORANGE, Colors.PURPLE, Colors.GREY);
        allTubes.add(tube12);
        Tube tube13 = new Tube("tube13", Colors.EMPTY, Colors.EMPTY, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube13);
        Tube tube14 = new Tube("tube14", Colors.EMPTY, Colors.EMPTY, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube14);
    }

    static void unsolvable2()
    {
        Tube tube1 = new Tube("tube1", Colors.PURPLE, Colors.INDIGO, Colors.YELLOW, Colors.GREY);
        allTubes.add(tube1);
        Tube tube2 = new Tube("tube2", Colors.ORANGE, Colors.YELLOW, Colors.DARK_GREEN, Colors.RED);
        allTubes.add(tube2);
        Tube tube3 = new Tube("tube3", Colors.GREEN, Colors.LIGHT_BLUE, Colors.ORANGE, Colors.YELLOW);
        allTubes.add(tube3);
        Tube tube4 = new Tube("tube4", Colors.GREEN, Colors.ORANGE, Colors.DARK_BLUE, Colors.ORANGE);
        allTubes.add(tube4);
        Tube tube5 = new Tube("tube5", Colors.RED, Colors.DARK_GREEN, Colors.INDIGO, Colors.PINK);
        allTubes.add(tube5);
        Tube tube6 = new Tube("tube6", Colors.LIGHT_BLUE, Colors.LIGHT_GREEN, Colors.PURPLE, Colors.DARK_GREEN);
        allTubes.add(tube6);
        Tube tube7 = new Tube("tube7", Colors.PURPLE, Colors.DARK_GREEN, Colors.GREEN, Colors.PURPLE);
        allTubes.add(tube7);
        Tube tube8 = new Tube("tube8", Colors.DARK_BLUE, Colors.DARK_BLUE, Colors.LIGHT_BLUE, Colors.DARK_BLUE);
        allTubes.add(tube8);
        Tube tube9 = new Tube("tube9", Colors.LIGHT_GREEN, Colors.RED, Colors.PINK, Colors.YELLOW);
        allTubes.add(tube9);
        Tube tube10 = new Tube("tube10", Colors.PINK, Colors.PINK, Colors.INDIGO, Colors.INDIGO);
        allTubes.add(tube10);
        Tube tube11 = new Tube("tube11", Colors.GREY, Colors.GREY, Colors.LIGHT_BLUE, Colors.LIGHT_GREEN);
        allTubes.add(tube11);
        Tube tube12 = new Tube("tube12", Colors.GREY, Colors.RED, Colors.GREEN, Colors.LIGHT_GREEN);
        allTubes.add(tube12);
        Tube tube13 = new Tube("tube13", Colors.EMPTY, Colors.EMPTY, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube13);
        Tube tube14 = new Tube("tube14", Colors.INVALID, Colors.INVALID, Colors.INVALID, Colors.INVALID);
        allTubes.add(tube14);
    }

    static void unsolvable()
    {
        Tube tube1 = new Tube("tube1",Colors.DARK_BLUE, Colors.GREEN, Colors.LIGHT_BLUE, Colors.GREY);
        allTubes.add(tube1);
        Tube tube2 = new Tube("tube2", Colors.YELLOW, Colors.PURPLE, Colors.LIGHT_GREEN, Colors.RED);
        allTubes.add(tube2);
        Tube tube3 = new Tube("tube3", Colors.GREY, Colors.DARK_GREEN, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube3);
        Tube tube4 = new Tube("tube4", Colors.RED, Colors.RED, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube4);
        Tube tube5 = new Tube("tube5", Colors.GREY, Colors.DARK_GREEN, Colors.DARK_BLUE, Colors.INDIGO);
        allTubes.add(tube5);
        Tube tube6 = new Tube("tube6", Colors.INDIGO, Colors.DARK_GREEN, Colors.ORANGE, Colors.YELLOW);
        allTubes.add(tube6);
        Tube tube7 = new Tube("tube7", Colors.INDIGO, Colors.INDIGO, Colors.LIGHT_GREEN, Colors.LIGHT_GREEN);
        allTubes.add(tube7);
        Tube tube8 = new Tube("tube8", Colors.GREY, Colors.ORANGE, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube8);
        Tube tube9 = new Tube("tube9", Colors.RED, Colors.LIGHT_GREEN, Colors.YELLOW, Colors.YELLOW);
        allTubes.add(tube9);
        Tube tube10 = new Tube("tube10", Colors.DARK_GREEN, Colors.DARK_BLUE, Colors.GREEN, Colors.GREEN);
        allTubes.add(tube10);
        Tube tube11 = new Tube("tube11", Colors.LIGHT_BLUE, Colors.PURPLE, Colors.ORANGE, Colors.GREEN);
        allTubes.add(tube11);
        Tube tube12 = new Tube("tube12", Colors.ORANGE, Colors.DARK_BLUE, Colors.LIGHT_BLUE, Colors.LIGHT_BLUE);
        allTubes.add(tube12);
        Tube tube13 = new Tube("tube13", Colors.PURPLE, Colors.PURPLE, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube13);
        Tube tube14 = new Tube("tube14", Colors.PINK, Colors.PINK, Colors.PINK, Colors.PINK);
        allTubes.add(tube14);
    }

    
    public static void test2_doesnotwork() 
    {
        Tube tube1 = new Tube("tube1", Colors.GREEN, Colors.YELLOW, Colors.GREEN, Colors.RED);
        allTubes.add(tube1);
        Tube tube2 = new Tube("tube2", Colors.YELLOW, Colors.RED, Colors.GREEN, Colors.GREEN);
        allTubes.add(tube2);
        Tube tube3 = new Tube("tube3", Colors.RED, Colors.YELLOW, Colors.YELLOW, Colors.RED);
        allTubes.add(tube3);
        Tube tube4 = new Tube("tube4", Colors.EMPTY, Colors.EMPTY, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube4);
    }

    

    public static void testcase3_works() 
    {
    Tube tube1 = new Tube("tube1", Colors.GREEN, Colors.GREEN, Colors.RED, Colors.RED);
        allTubes.add(tube1);
        Tube tube2 = new Tube("tube2",  Colors.EMPTY, Colors.EMPTY, Colors.EMPTY, Colors.EMPTY);
        allTubes.add(tube2);
        Tube tube3 = new Tube("tube3", Colors.RED, Colors.RED, Colors.GREEN, Colors.GREEN);
        allTubes.add(tube3);
        
    }

    static void TestColors()
    {
        for (int i=0;i<16;++i)
        {
            for (int j=0;j<16;++j)
            {
                String code = Integer.toString(i * 16 + j);
                System.out.print("\u001b[48;5;" + code + "m " + String.format("%-4s", code));                
            }
            System.out.print("\u001b[0m");
        }

        
        /*
            for i in range(0, 16):
                for j in range(0, 16):
                    code = str(i * 16 + j)
                    sys.stdout.write(u"\u001b[48;5;" + code + "m " + code.ljust(4))
                print u"\u001b[0m"
            */
    }

    static void SolvePuzzle()
    {
        Instant starts = Instant.now();
        
        
        //ArrayList<Tube> allTubes = new ArrayList<Tube>();
        //test();
        //testcase3_works(); //works
        //test2_doesnotwork(); // also works now
        //baseline_Papa(); //works now
        //unsolvable();
        //unsolvable2();
        //puzzle508();
        puzzle605();

        //testing1();
      
        State s = new State(allTubes);

        if (!s.isValid())
            return;

        State s2 = s.solve_nonrecursive();

        //State s2 = s.solve_recursive();

        Instant ends = Instant.now();
        

        if (s2 == null)
        {
            System.out.println("Unsolvable??");            
        }
        else
        {        
            s2.printsolutionSteps(true, null);
        }

        System.out.println("Time taken = " + Duration.between(starts, ends).toMillis() + " ms");

        //public static final String TEXT_WHITE = "\u001B[37m";

        //System.out.println("\u001B[31m█\u001B[36m█ This text is red! \u001B[37m█ \u001B[0m░∏∏");
        //System.out.println("\u001B[36m██| |This text is cyan! \u001B[44m  \u001B[44m 28 \u001B[0m");
    }

    public static void main(String[] args) 
    {
        SolvePuzzle();
        //TestColors();
    }
}