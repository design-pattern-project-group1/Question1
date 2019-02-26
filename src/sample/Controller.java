package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    private Model model;

    @FXML
    private ComboBox<String> age_group_combo_box;
    private ObservableList<String> options = FXCollections.observableArrayList("Under 15", "15 - 17", "17 - 19", "Adult", "All Swimmers");

    @FXML
    private ListView<String> left_list;

    @FXML
    private ListView<String> right_list;

    SwimmerData ageGroupData;
    SwimmerData clonedData;


    Controller(Model model)
    {
        this.model = model;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        age_group_combo_box.setItems(options);
    }

    @FXML
    private void onSearch()
    {
        String s = age_group_combo_box.getValue();
        ageGroupData = new AgeGroupData(String.valueOf(s));
        left_list.setItems(getList(ageGroupData.swimmers));
    }

    @FXML
    private void onBestTime() throws CloneNotSupportedException
    {
        clonedData = new TimeData(ageGroupData);
        right_list.setItems(getList(clonedData.filter()));
    }

    @FXML
    private void onMale() throws CloneNotSupportedException
    {
        clonedData = new SexData(ageGroupData, 0);
        right_list.setItems(getList(clonedData.filter()));
    }

    @FXML
    private void onFemale() throws CloneNotSupportedException
    {
        clonedData = new SexData(ageGroupData, 1);
        right_list.setItems(getList(clonedData.filter()));
    }

    @FXML
    private void onAge() throws CloneNotSupportedException
    {
        clonedData = new AgeData(ageGroupData);
        right_list.setItems(getList(clonedData.filter()));
    }

    @FXML
    private void onQuit()
    {

    }

    private ObservableList<String> getList(ArrayList<Swimmer> swimmers)
    {
        ArrayList<String> strings = new ArrayList<>();

        int i = 0;
        for (Swimmer sw : swimmers)
        {
            strings.add(String.format(" %-12s  %.2f", sw.getName(), sw.getTime()));
            i++;
        }

        return FXCollections.observableArrayList(strings);
    }
}
