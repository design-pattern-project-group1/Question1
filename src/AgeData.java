import java.util.ArrayList;

public class AgeData extends SwimmerData
{

    private SwimmerData swimmer_data;

    public AgeData(SwimmerData swimmer_data)
    {
        this.swimmer_data = swimmer_data;
    }

    @Override
    ArrayList<Swimmer> filter()
    {
        return swimmer_data.swimmers;
    }
}
