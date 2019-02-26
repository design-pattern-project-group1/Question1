package sample;

import java.util.ArrayList;

public class AgeGroupData extends SwimmerData implements Cloneable
{
    public AgeGroupData(String age_group)
    {
        Database db = new Database();
        swimmers = db.fetch(age_group);
    }

    @Override
    ArrayList<Swimmer> filter()
    {
        // I don't need to filter
        return null;
    }
}
