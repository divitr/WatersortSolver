import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class State {
    static ArrayList<String> ssteps = new ArrayList<String>();
    ArrayList<String> steps;
    ArrayList<State> states;
    static int Id =1;
    String IdPath;
    int id;
    private State prevState;
    //private String prevStep;
    private Step pStep;
    //private static int counter = 1;
    private int depth =0;
    private String stringId;
    //private static boolean isRecursive = false;
    private ArrayList<Integer> id2;
    StringBuilder s;
    

    final int FULL = -1;
    static boolean DONE = false;
    public ArrayList<Tube> allTubes = new ArrayList<Tube>();
    private static ArrayList<State> wip_states = new ArrayList<State>(100000);
    //private static ArrayList<State> discardPile = new ArrayList<State>(100000);
    private static HashSet<String> SetStates = new HashSet<String>();

    public State(ArrayList<Tube> allTubes)
    {
        this.allTubes = allTubes;
        steps = new ArrayList<String>();
        states = new ArrayList<State>();
        this.id=Id++;
        this.prevState = null;
        //this.prevStep = null;
        this.IdPath = "" + this.id;
        this.depth = 0;
        this.id2 = new ArrayList<Integer>(15);
        this.s = new StringBuilder(720);
        this.makeStringId();
        this.pStep = null;
    }
    
    public State(State prevState)
    {
        steps = new ArrayList<String>();
        states = new ArrayList<State>();
        ArrayList<Tube> allTubesLocal = prevState.getTubes();
        for (int i=0;i<allTubesLocal.size();i++)
        {
            Tube tempTube = Tube.deepClone(allTubesLocal.get(i));
            this.allTubes.add(tempTube);
        }
        this.id=Id++;
        this.prevState = prevState;
        this.IdPath = prevState.IdPath + "-" + this.id;
        this.depth = prevState.depth+1;
        this.id2 = new ArrayList<Integer>(15);
        this.s = new StringBuilder(720);
        this.makeStringId();
        this.pStep = null;
    }

    private void makeStringId()
    {
        id2.clear();
        //String deb = "";
        for (int i=0;i<this.allTubes.size();i++)
        {
            //id2.add(this.allTubes.get(i).stringId);
            id2.add(this.allTubes.get(i).intId);
            //deb += this.allTubes.get(i).stringId;
        }
        java.util.Collections.sort(id2);

        this.s.setLength(0);
        for (int i=0;i<id2.size();i++)
        {
            //s.concat(id2.get(i)+"-");
            s.append(id2.get(i).toString());

        }
        this.stringId=s.toString();

        //System.out.println(deb);
        //System.out.println(s);
        //System.out.println();
    }

    boolean IsEssentiallySameAs(State second)
    {
        //if (second == null)
        //    return false;

        return (this.stringId.equals(second.stringId));
        //    return true;
/*
        for (int i=id2.size()-1;i>=0;++i)
        {
            if (this.id2.get(i) != second.id2.get(i))
                return false;
        }
        return true;
*/
        //return false;
        
        /*
        int size = this.allTubes.size();
        if (size != second.allTubes.size())
            return false;
        
        for (int i=0;i<size;i++)
        {
            if (!this.allTubes.get(i).IsEssentiallySameAs(second.allTubes.get(i)))
                return false;
        }
        return true;
        */
    }

    boolean IsEssentiallySameAsPredecessors()
    {
        State prev = this.prevState;
        while (prev != null)
        {
            if (this.IsEssentiallySameAs(prev))
                return true;
            
            prev = prev.prevState;
        }

        return false;
    }

    boolean AmIDone() 
    {
        for (int idx=0; idx<allTubes.size(); idx++)
        {
            if (allTubes.get(idx).tubeDone() == false)
            {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Tube> getTubes()
    {
        return this.allTubes;
    }

    public void draw_v1()
    {
        System.out.println("** StateId = "+this.id + " (" + this.IdPath + ")");
        for (int i=0; i<allTubes.size(); i++)
        {
            allTubes.get(i).draw2();
        }
    }

    public void draw(State nextState)
    {        
        if (nextState != null)
        {
            for (int i=0; i<nextState.allTubes.size(); i++)
            {
                String s = nextState.allTubes.get(i).Name;
                if (nextState.pStep != null)
                {
                    if (nextState.allTubes.get(i) == nextState.pStep.FromTube())
                    {
                        //s=Colors.OUT_RED.ansiColor()+s+"(OUT)"+Colors.RESET.ansiColor();
                        s+="(OUT)";
                    }
                    else if (nextState.allTubes.get(i) == nextState.pStep.ToTube())
                    {
                        //s=Colors.IN_GREEN.ansiColor()+s+"(IN)"+Colors.RESET.ansiColor();;
                        s+="(IN)";
                    }
                }

                System.out.printf("%-14s", s);
            }
        }
        else
        {
            for (int i=0; i<this.allTubes.size(); i++)
            {
                System.out.printf("%-14s", allTubes.get(i).Name);
            }
        }

        System.out.println();
        for (int i=this.allTubes.get(0).tubeContents.size()-1; i>=0; i--)
        {
            for (int j=0; j<this.allTubes.size(); j++)
            {
                System.out.printf("%-10s           ", this.allTubes.get(j).drawQuart(i));
            }
            System.out.println();
        }

        System.out.println();
    }

    boolean canTransfer(Tube fromTube, Tube toTube)
    {
        if (fromTube == toTube)
            return false;
        if (toTube.firstEmptySlot() == FULL)
            return false;

        Colors poppedColor = fromTube.pop(true);

        if (poppedColor == Colors.EMPTY)
            return false;
        if (!toTube.push(poppedColor, true))
            return false;
        return true;
    }

    State Transfer(int from, int to)
    {
        if (from==to)
            return this;

        State newState;
        Colors color = Colors.INVALID;
        int quartsTransferred = 0;
        Tube fromTube = this.allTubes.get(from);
        Tube toTube = this.allTubes.get(to);
        boolean toTubeEmptyBefore = (toTube.pop(true)==Colors.EMPTY);

        if (this.canTransfer(fromTube, toTube))
        {
            newState = new State(this);
            fromTube = newState.allTubes.get(from);
            toTube = newState.allTubes.get(to);

            // do one transfer here
            color = fromTube.pop(false);
            toTube.push(color, false);
            //this.makeStringId();
            quartsTransferred++;
        }
        else
        {
            return this;
        }

        // if more transfers possibble
        while (newState.canTransfer(fromTube, toTube))
        {
            color = fromTube.pop(false);
            toTube.push(color, false);
            //this.makeStringId();
            quartsTransferred++;
        }



        if (quartsTransferred>0)
        {
            boolean fromTubeEmptyAfter = (fromTube.pop(true)==Colors.EMPTY);

            if (toTubeEmptyBefore && fromTubeEmptyAfter)
            {
                return this;
            }

            //if (quartsTransferred==4)
            //{
            //    return this;
            //}

            if (color == fromTube.pop(true))
            {
                return this;
            }

            newState.makeStringId();
            /*
            //if newstate exists or has been seen before, discard
            for (int i=0; i<discardPile.size();++i)
            {
                if (newState.IsEssentiallySameAs(discardPile.get(i)))
                    return this;
            }

            for (int i=0; i<wip_states.size();++i)
            {
                if (newState.IsEssentiallySameAs(wip_states.get(i)))
                    return this;
            }
            

            // only needed for recursive solition
            if (isRecursive && newState.IsEssentiallySameAsPredecessors())
                return this;
            */

            // check for duplicates
            Boolean success = SetStates.add(newState.stringId);
            if (!success)
                return this;

            //State newState = new State();
            newState.pStep = new Step(fromTube, toTube, color, quartsTransferred);
            //String s = newState.pStep.ToStr();
            //newState.steps.add(s);
            //newState.prevStep = s;
            //newState.draw();
            //System.out.println(s);
            //newState.states.add(newState);
            return newState;
        }
        return this;
    }

    void solutionSteps()
    {
        this.draw(this);
        for (int i=0;i<this.steps.size();i++)
        {
            System.out.println();
            System.out.print("**  STEP."+(i+1)+"  ***************************");
            System.out.println(this.steps.get(i));
            this.states.get(i).draw(this);
        }
    }

    int printsolutionSteps(boolean detailed, State nextState)
    {
        int counter = 1;

        if (this.prevState != null)
        {
            counter = this.prevState.printsolutionSteps(detailed, this);
        }
        if (nextState != null)
        {
            System.out.println();
            System.out.print("**  STEP."+ counter ++ + "  *************************** ");            
            System.out.println(nextState.pStep.ToStr());            
        }
        else
        {
            System.out.println("Final State");    
        }
        System.out.println("Path = " + this.IdPath);

        if (detailed)
            this.draw(nextState);
        return counter++;
    }

    boolean isValid()
    {
        HashMap<Colors, Integer> ourHashmap = new HashMap<Colors, Integer>();
        for (int i=0;i<this.allTubes.size();++i)
        {
            for (int j=0;j<this.allTubes.get(i).tubeContents.size();++j)
            {
                Colors col = this.allTubes.get(i).tubeContents.get(j);
                if (col == Colors.EMPTY)
                    continue;
                
                if (!ourHashmap.containsKey(col))
                    ourHashmap.put(col, 0);

                ourHashmap.put(col, ourHashmap.get(col)+1);
            }
        }

        for (HashMap.Entry<Colors,Integer> entry : ourHashmap.entrySet())
        {
            if (entry.getValue() != 4)
            {
                System.out.println("Key = " + entry.getKey().toString() + ", Value = " + entry.getValue());
                return false;
            }
       

        }
     
        return true;

    }

    State solve_nonrecursive()
    {
        wip_states.clear();
        //discardPile.clear();
        wip_states.add(this);
        SetStates.add(this.stringId);

        //int localdepth = 0;
        int added =0;
        //int pointer =0;

        //while (pointer < wip_states.size())
        while (wip_states.size()>0)        
        {

            added = 0;
            //localdepth++;
            //State s = wip_states.get(pointer++);
            State s = wip_states.get(0);

            
            if (s.AmIDone())
            {
                 return s;
            }
            

            //discardPile.add(wip_states.get(0));
            
            // removed this in favor of pointer
            wip_states.remove(0);
            


            //State newState = new State(this);
            for (int i = 0; i<s.allTubes.size() ; i++)
            {
                for (int j = 0; j<s.allTubes.size() ; j++)
                {
                    if (i!=j)
                    {
                        State newState = s.Transfer(i, j);

                        if (newState != s)
                        {
                            wip_states.add(newState);
                            added++;
                        }
                    }
                }
            }
            
            
            //System.out.println("At depth = " + s.depth + " for StateId= "+ s.IdPath + " added " + added + " states *************");
            //System.out.println("current size = " + wip_states.size());

            
            if (added >7 && s.depth>766)
            {
                System.out.println("At depth = " + s.depth + " for StateId= "+ s.IdPath + " added " + added + " states *************");
                System.out.println("current size = " + wip_states.size());
                s.draw(this);
                System.out.println();
            }

            
        }
        return null;
    }


    

    State solve_recursive()
    {
        //isRecursive = true;

        if (this.AmIDone())
        {
             return this;
        }

        SetStates.add(this.stringId);

        //State newState = new State(this);
        for (int i = 0; i<this.allTubes.size() ; i++)
        {
            for (int j = 0; j<this.allTubes.size() ; j++)
            {
                if (i!=j)
                {
                    State newState = this.Transfer(i, j);

                    if (newState != this)
                    {
                        State sol = newState.solve_recursive();
                        if (sol != null)
                            return sol;
                    }
                }
            }
        }
    
        return null;
    }

}
