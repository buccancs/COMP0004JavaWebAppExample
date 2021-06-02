package uk.ac.ucl.model;

import uk.ac.ucl.dataframe.SubItem;
import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.dataframe.Item;
import uk.ac.ucl.utilities.ReadModel;
import uk.ac.ucl.utilities.SaveModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    // The example code in this class should be replaced by your Model class code.
    // The data should be stored in a DataFrame.
    // private DataFrame frame = ...


    private List<Dataframe> dataframes;

    public Model() {
        this.setListDataframe(new ArrayList<Dataframe>());
//        createDummyModel();
    }


    public Model create() {
        Model model = new Model();
        this.setListDataframe(new ArrayList<Dataframe>());

        return model;
    }

    public Model create(List<Dataframe> listDataframe) {
        Model model = new Model();
        model.setListDataframe(listDataframe);

        return model;
    }

    public void addDataframe(Dataframe dataframe) {
        this.dataframes.add(dataframe);
    }

    public void addListDataframe(List<Dataframe> dataframes) {
        this.dataframes = dataframes;
    }

    public List<Dataframe> getListDataframe() {
        return dataframes;
    }

//    public void setListDataframe() {
//        this.listDataframe = ReadFromFile();
//    }

    public void setListDataframe(List<Dataframe> listDataframe) {
        this.dataframes = listDataframe;
    }

    public Dataframe getDataframeById(int dataframeId) throws Exception {
        if (this.dataframes == null) {
            throw new Exception("List of dataframes is empty.");
        } else {
            for (Dataframe dataframe : this.dataframes) {
                if (dataframe.getDataframeId() == dataframeId) {
                    return dataframe;
                }
            }
            throw new Exception("Item with this ID does not exist.");
        }
    }

    public List<Integer> getDataframeIds() throws Exception {
        List<Integer> idList = new ArrayList<Integer>();

        if (this.dataframes == null) {
            throw new Exception("List of dataframes is empty.");
        } else {
            for (Dataframe dataframe : this.dataframes) {
                idList.add(dataframe.getDataframeId());
            }
            return idList;
        }
    }

    public List<String> getDataframeLabels() throws Exception {
        List<String> labelList = new ArrayList<String>();

        if (this.dataframes == null) {
            throw new Exception("List of dataframes is empty.");
        } else {
            for (Dataframe dataframe : this.dataframes) {
                labelList.add(dataframe.getLabel());
            }
            return labelList;
        }
    }

    public void removeDataframeById(int dataframeId) {
        this.getListDataframe().removeIf(dataframe -> dataframe.getDataframeId() == dataframeId);
    }

    public void createDummyModel() {
        Item dummyItem1 = Item.createAsItem(690, 6901, "dummy item1", "description of dummy item1", "dummy group1");
        Item dummyItem2 = Item.createAsItem(700, 7001, "dummy item2", "description of dummy item2", "dummy group2");
        dummyItem1.addSubItem(69, 690, 6901, "URL", "www.google.hu");
        dummyItem2.addSubItem(70, 700, 7001, "URL", "www.google.com");
        Dataframe dummyDataframe1 = Dataframe.create(6901, "dummy dataframe1", "description dummy dataframe1");
        Dataframe dummyDataframe2 = Dataframe.create(7001, "dummy dataframe2", "description dummy dataframe2");
        dummyDataframe1.addItem(dummyItem1);
        dummyDataframe2.addItem(dummyItem2);
        this.dataframes.add(dummyDataframe1);
        this.dataframes.add(dummyDataframe2);
    }

    public void readFile() throws IOException {
        // Read a patient .csv data file and create the DataFrame.
    }

}