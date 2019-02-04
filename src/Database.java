import java.util.ArrayList;
import java.util.Random;

public class Database {
    private ArrayList<Swimmer> swimmers = new ArrayList<>();

    public Database()
    {
        Random rand = new Random();
        String salt = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder   name_builder;
        String          name;
        int             age;
        int             sex;
        double          time;
        int             index;


        for (int i = 0; i < 100; i++)
        {
            name_builder = new StringBuilder();
            while (name_builder.length() < 8)
            {
                index = rand.nextInt(salt.length());;
                name_builder.append(salt.charAt(index));
            }
            name = name_builder.substring(0, 1).toUpperCase() + name_builder.substring(1);

            age = rand.nextInt(40) + 12;
            sex = rand.nextInt(1);
            time = 25 + rand.nextDouble() * 10;  // 25 + 0.5 * 10 = 30

            swimmers.add(new Swimmer(name, age, sex, time));
        }
    }

    ArrayList<Swimmer> fetch(String age_group)
    {
        ArrayList<Swimmer> group_of_swimmers = new ArrayList<>();

        switch (age_group) {
            case "Under 15":
                for (Swimmer i : swimmers) if (i.getAge() < 15) group_of_swimmers.add(i);
                break;
            case "15 - 17":
                for (Swimmer i : swimmers) if (i.getAge() > 15 && i.getAge() < 17) group_of_swimmers.add(i);
                break;
            case "17 - 19":
                for (Swimmer i : swimmers) if (i.getAge() > 17 && i.getAge() < 19) group_of_swimmers.add(i);
                break;
            case "Adult":
                for (Swimmer i : swimmers) if (i.getAge() > 19) group_of_swimmers.add(i);
                break;
            case "All Swimmers":
                group_of_swimmers.addAll(swimmers);
                break;
        }
        return group_of_swimmers;
    }
}
