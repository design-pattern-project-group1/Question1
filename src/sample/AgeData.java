package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class AgeData extends SwimmerData
{

    private SwimmerData swimmer_data;

    public AgeData(SwimmerData swimmer_data) throws CloneNotSupportedException
    {
        this.swimmer_data = (SwimmerData) swimmer_data.clone();
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
                if (temp_list[i].getAge() > temp_list[j].getAge())
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
