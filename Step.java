public class Step {
    private Tube fromTube;
    private Tube toTube;
    private Colors col;
    private int quarts;

    public Step (Tube from, Tube to, Colors color, int q)
    {
        this.fromTube = from;
        this.toTube = to;
        this.col = color;
        this.quarts = q;
    }

    public int Quarts()
    {
        return this.quarts;
    }

    public Colors Color()
    {
        return this.col;
    }

    public Tube FromTube()
    {
        return this.fromTube;
    }

    public Tube ToTube()
    {
        return this.toTube;
    }

    public String ToStr()
    {
        String BOLD = "\033[1;97m";
        String UNDERLINE = "\033[4;30m";
        
        StringBuilder s = new StringBuilder();

        s.append(BOLD);
        s.append(UNDERLINE);
        s.append(this.quarts);
        s.append(" quart(s) of ");
        s.append(this.col.ansiColor());
        s.append("  ");
        s.append(Colors.RESET.ansiColor());
        s.append(BOLD);
        s.append(UNDERLINE);
        s.append("(");
        s.append(this.col);
        s.append(") from ");
        s.append(this.fromTube.Name);
        s.append(" to ");
        s.append(this.toTube.Name);
        s.append(Colors.RESET.ansiColor());
        return s.toString();
        

        
        //return "\033[1;97m\033[4;30m" +this.quarts + " quart(s) of " + this.col.ansiColor() + "    " +Colors.RESET.ansiColor() + "\033[1;97m\033[4;30m" +
        //"(" + this.col + ") from " + this.fromTube.Name + " to " + this.toTube.Name+Colors.RESET.ansiColor();
    }
}
