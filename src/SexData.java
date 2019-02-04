import java.util.ArrayList;
import java.util.Arrays;

public class SexData extends SwimmerData
{
    private SwimmerData swimmer_data;
    private int sex;

    public SexData(SwimmerData swimmer_data, int sex) throws CloneNotSupportedException
    {
        this.swimmer_data = (SwimmerData) swimmer_data.clone();
        this.sex = sex;
    }

    @Override
    ArrayList<Swimmer> filter()
    {
        int max = this.swimmer_data.swimmers.size();
        Swimmer[] temp_list = new Swimmer[max];

        for (int i = 0; i < max; i++)
        {
            temp_list[i] = this.swimmer_data.swimmers.get(i);
        }
        this.swimmer_data.swimmers.clear();

        if (this.sex == 0)
        {
            for (Swimmer sw: temp_list)
            {
                if (sw.getSex() == 0)
                {
                    this.swimmer_data.swimmers.add(sw);
                }
            }
        }
        else
            {
                for (Swimmer sw: temp_list)
                {
                    if (sw.getSex() == 1)
                    {
                        this.swimmer_data.swimmers.add(sw);
                    }
                }
            }

        return swimmer_data.swimmers;
    }
}
