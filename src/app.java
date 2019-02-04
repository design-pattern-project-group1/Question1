import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class app {
    JPanel panel1;
    JComboBox comboBox1;
    JButton searchButton;
    JButton timeButton;
    JButton maleButton;
    JButton femaleButton;
    JButton ageButton;
    JButton quitButton;

    JList main_list;
    JList second_list;
    DefaultListModel main_model = (DefaultListModel)main_list.getModel();
    DefaultListModel second_model = (DefaultListModel)second_list.getModel();

    SwimmerData main_data;
    SwimmerData second_data;

    public app()
    {
        comboBox1.addItem("Under 15");
        comboBox1.addItem("15 - 17");
        comboBox1.addItem("17 - 19");
        comboBox1.addItem("Adult");
        comboBox1.addItem("All Swimmers");

        searchButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                start_main();
            }
        });

        timeButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    start_second();
                }
                catch (CloneNotSupportedException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        maleButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    start_male();
                }
                catch (CloneNotSupportedException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        femaleButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    start_female();
                }
                catch (CloneNotSupportedException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        ageButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    start_age();
                }
                catch (CloneNotSupportedException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    void start_main()
    {
        main_model.clear();
        main_data = new AgeGroupData(String.valueOf(comboBox1.getSelectedItem()));

        int i = 0;
        for (Swimmer sw: main_data.swimmers)
        {
            main_model.addElement(String.format(" %-12s  %.2f",sw.getName(), sw.getTime()));
            i++;
        }
        try {
            main_list = new JList(main_model);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    void start_second() throws CloneNotSupportedException
    {
        second_data = new TimeData(main_data);
        update_second_list();
    }

    void start_male() throws CloneNotSupportedException
    {
        second_model.clear();
        second_data = new SexData(main_data, 1);
    }
    void start_age() throws CloneNotSupportedException
    {
        second_model.clear();
        second_data = new AgeData(main_data);
    }

    void start_female() throws CloneNotSupportedException
    {
        second_model.clear();
        second_data = new SexData(main_data, 0);
    }

    void update_second_list()
    {
        second_model.clear();

        int i = 0;
        for (Swimmer sw: second_data.filter())
        {
            second_model.addElement(String.format(" %-12s  %.2f",sw.getName(), sw.getTime()));
            i++;
        }
        second_list = new JList(second_model);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new app().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
