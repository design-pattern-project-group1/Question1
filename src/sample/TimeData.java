package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class TimeData extends SwimmerData
{
    private SwimmerData swimmer_data;
    public TimeData(SwimmerData sd) throws CloneNotSupportedException
    {
        this.swimmer_data = (SwimmerData) sd.clone();
    }

    @Override
    ArrayList<Swimmer> filter()
    {
        Swimmer sw;
        int max = this.swimmer_data.swimmers.size();
        Swimmer[] temp_list = new Swimmer[max];

        int i;
        int j;

        for (i = 0; i < max; i++)
        {
            temp_list[i] = this.swimmer_data.swimmers.get(i);
        }
        this.swimmer_data.swimmers.clear();

        for (i = 0; i < max; i++)
        {
            for (j = i; j < max; j++)
            {
                if (temp_list[i].getTime() > temp_list[j].getTime())
                {
                    sw = temp_list[i];
                    temp_list[i] = temp_list[j];
                    temp_list[j] = sw;
                }
            }
        }

        this.swimmer_data.swimmers.addAll(Arrays.asList(temp_list));

        return swimmer_data.swimmers;
    }
}
