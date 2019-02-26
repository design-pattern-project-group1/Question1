package sample;

import java.util.ArrayList;

public abstract class SwimmerData implements Cloneable
{
    ArrayList<Swimmer> swimmers = new ArrayList<>();

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    abstract ArrayList<Swimmer> filter();
}
