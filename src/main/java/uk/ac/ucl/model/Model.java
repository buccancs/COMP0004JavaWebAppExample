package uk.ac.ucl.model;

import org.apache.tomcat.util.log.UserDataHelper;
import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.dataframe.Item;

import java.io.File;
import java.util.*;

public class Model {
    // The example code in this class should be replaced by your Model class code.
    // The data should be stored in a DataFrame.
    // private DataFrame frame = ...


    private List<Dataframe> dataframes;

    public Model(){
        this.setListDataframe(new ArrayList<Dataframe>());
        createDummyModel();
    }


    public Model create(){
        Model model = new Model();
        this.setListDataframe(new ArrayList<Dataframe>());

        return model;
    }

    public Model create(List<Dataframe> listDataframe){
        Model model = new Model();
        model.setListDataframe(listDataframe);

        return model;
    }

    public void setListDataframe(List<Dataframe> listDataframe){
        this.dataframes = listDataframe;
    }

    public void addDataframe(Dataframe dataframe) {
        this.dataframes.add(dataframe);
    }

    public void addListDataframe(List<Dataframe> dataframes){
        this.dataframes = dataframes;
    }

//    public void setListDataframe() {
//        this.listDataframe = ReadFromFile();
//    }

    public List<Dataframe> getListDataframe() {
        return dataframes;
    }

    public Dataframe getDataframeById(int dataframeId) throws Exception {
        if (this.dataframes == null){
            throw new Exception("List of dataframes is empty.");
        }
        else {
            for (Dataframe dataframe : this.dataframes){
                if (dataframe.getDataFrameId() == dataframeId){
                    return dataframe;
                }
            }
            throw new Exception("Item with this ID does not exist.");
        }
    }

    public List<Integer> getDataframeIds() throws Exception {
        List<Integer> iDList = new ArrayList<Integer>();

        if (this.dataframes == null){
            throw new Exception("List of dataframes is empty.");
        }
        else {
            for (Dataframe dataframe : this.dataframes) {
                iDList.add(dataframe.getDataFrameId());
            }
            return iDList;
        }
    }

    public List<String> getDataframeLabels() throws Exception {
        List<String> labelList = new ArrayList<String>();

        if (this.dataframes == null){
            throw new Exception("List of dataframes is empty.");
        }
        else {
            for (Dataframe dataframe : this.dataframes) {
                labelList.add(dataframe.getLabel());
            }
            return labelList;
        }
    }

    public void createDummyModel() {
        Item dummyItem = Item.createAsItem(690, 6900, "dummy item", "description of dummy item", "dummy group");
        dummyItem.addDataElement(69, "URL", "www.google.hu");
        Dataframe dummyDataframe = Dataframe.create(6901, "dummy dataframe", "description dummy dataframe");
        dummyDataframe.addItem(dummyItem);
        this.dataframes.add(dummyDataframe);
    }

    public List<String> getPatientNames() throws Exception {
        return List.of(String.valueOf(getDataframeById(6900).getItemById(690).getDataElementById(69).getDataType()));
    }

//    public List<String> getPatientNames() {
//        return List.of("Name1", "Name2", "Name3"); // This is just dummy data
//    }

    public void readFile(File file) {
        // Read a patient .csv data file and create the DataFrame.
    }

    // This also returns dummy data. The real version should use the keyword parameter to search
    // the patient data and return a list of matching items.
    public List<String> searchFor(String keyword) {
        return List.of("Search keyword is: " + keyword, "result1", "result2", "result3");
    }
}