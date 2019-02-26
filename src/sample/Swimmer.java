package sample;

class Swimmer
{
    private String name;
    private int age;
    private int sex;
    private double time;

    public Swimmer(String name, int age, int sex, double time)
    {
        this.name = name;
        this.age = age;
        this.time = time;
        this.sex = sex;
    }

    String getName()
    {
        return name;
    }
    int getAge()
    {
        return age;
    }
    double getTime()
    {
        return time;
    }
    int getSex()
    {
        return sex;
    }
}
