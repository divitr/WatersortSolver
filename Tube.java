import java.util.ArrayList;




class Tube 
{
    public String Name;
    final int FULL = -1;
    public ArrayList<Colors> tubeContents = new ArrayList<Colors>();
    public String stringId;
    public Integer intId;
    
    Tube(String name, Colors color1, Colors color2, Colors color3, Colors color4)  //assigns colors to positions
    {
        tubeContents.add(color1);
        tubeContents.add(color2);
        tubeContents.add(color3);
        tubeContents.add(color4);
        this.Name = name;
        //this.makeStringId();
        this.makeIntId();
    } //Tube constructor

    public boolean tubeDone()
    {
        Integer firstColor = this.tubeContents.get(0).getValue();
        for (int idx=1; idx<tubeContents.size(); idx++)
        {
            if (tubeContents.get(idx).getValue()!=firstColor)
            {
                return false;
            }
        }
        return true;
    }

    public void makeStringId()
    {
        //String s = "";
        StringBuilder s = new StringBuilder(30);
        for (int i =0;i<tubeContents.size();++i)
        {
            //s = s+"-"+tubeContents.get(i);
            s.append(tubeContents.get(i) + "-");
        }
        this.stringId = s.toString();
    }

    public void makeIntId()
    {
        //String s = "";
        StringBuilder s = new StringBuilder(30);
            //s = s+"-"+tubeContents.get(i);
        s.append(tubeContents.get(0).getStrValue());
        s.append(tubeContents.get(1).getStrValue());
        s.append(tubeContents.get(2).getStrValue());
        s.append(tubeContents.get(3).getStrValue());

        this.intId = Integer.parseInt(s.toString());
    }

    void draw2()
    {
        System.out.print(this.Name + "-------");
        for (int i = 0; i<tubeContents.size(); i++ )
        {
            System.out.print(" |  " + tubeContents.get(i));
        }
        System.out.println();
    }

    public String drawQuart(int quartNumber)
    {
        return (this.tubeContents.get(quartNumber).ansiColor() + "___" + Colors.RESET.ansiColor());
    }

    void draw()
    {
        System.out.println(this.Name);
        for (int i = tubeContents.size()-1; i>=0; i-- )
        {
            System.out.println("|  " + tubeContents.get(i));
        }
        System.out.println();
    }

    boolean push(Colors newColor, boolean mock)
    {
        int slot = this.firstEmptySlot();
        if (slot==FULL)
            return false;
        if (slot !=0 && tubeContents.get(slot-1)!=newColor)
            return false;
        if (!mock)
        {
            tubeContents.set(slot, newColor);
            //this.makeStringId();
            this.makeIntId();
        }
        return true;
    }

    Colors pop(boolean mock)
    {
        Colors popColor;
        int slot = this.firstEmptySlot();
        if (slot != 0)
        {
            if (slot != FULL)
                popColor = tubeContents.get(slot-1);
            else 
                popColor = tubeContents.get(tubeContents.size()-1);


            if (!mock)
            {
                if (slot != FULL)
                    tubeContents.set(slot-1, Colors.EMPTY);
                if (slot == FULL)
                    tubeContents.set(tubeContents.size()-1, Colors.EMPTY);
                //this.makeStringId();
                this.makeIntId();
            }
            return popColor;
        }
        return Colors.EMPTY;
    }

    //returns FULL if tube is full, otherwise returns index of first empty slot
    int firstEmptySlot()
    {
        for (int idx=0; idx<tubeContents.size(); idx++)
        {
            if (tubeContents.get(idx) == Colors.EMPTY)
            {
                return idx;
            }
        }
        return FULL;
    }

    boolean IsEssentiallySameAs(Tube second)
    {
        int size = this.tubeContents.size();
        if (size != second.tubeContents.size())
            return false;
        
        for (int i=0;i<size;i++)
        {
            if (this.tubeContents.get(i).name() != second.tubeContents.get(i).name())
                return false;
        }
        return true;
    }

    public static Tube deepClone(Tube oldTube)
    {
        Tube newTube = new Tube(oldTube.Name, oldTube.tubeContents.get(0), oldTube.tubeContents.get(1),
                                oldTube.tubeContents.get(2), oldTube.tubeContents.get(3));
        return newTube;
    }
}
