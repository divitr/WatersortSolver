
public enum Colors {
    EMPTY(10,"10", "\u001b[48;5;231m"), 
    PURPLE(11,"11", "\u001b[48;5;13m"), 
    GREY(12,"12", "\u001b[48;5;245m"), 
    GREEN(13,"13","\u001b[48;5;10m"), 
    LIGHT_GREEN(14,"14","\u001b[48;5;84m"), 
    DARK_GREEN(15,"15","\u001b[48;5;28m"), //lets do black as dark-green
    BLUE(16,"16","\u001b[48;5;14m"),
    DARK_BLUE(17,"17","\u001b[48;5;20m"), 
    LIGHT_BLUE(18,"18","\u001b[48;5;87m"), 
    RED(19,"19","\u001b[48;5;1m"), 
    INDIGO(20,"20","\u001b[48;5;56m"), 
    YELLOW(21,"21","\u001b[48;5;226m"), 
    ORANGE(22,"22","\u001b[48;5;202m"), 
    PINK(23,"23","\u001b[48;5;219m"),
    INVALID(24,"24",""),
    RESET(25,"25","\u001B[0m"),
    IN_GREEN2(26,"26","\u001b[48;5;77m"),
    OUT_RED2(27,"27","\u001b[48;5;129m"),
    IN_GREEN(28,"28",""),
    OUT_RED(29,"29","");
    

    //\u001B[107m - grey??

    private final int value;
    private final String strValue;
    private final String ANSI_color;

    private Colors(int value, String strValue1, String strColor) {
        this.value = value;
        this.strValue = strValue1;
        this.ANSI_color = strColor;
    }

    public int getValue() {
        return value;
    }
    public String getStrValue() {
        return strValue;
    }

    public String ansiColor() {
        return ANSI_color;
    }
}