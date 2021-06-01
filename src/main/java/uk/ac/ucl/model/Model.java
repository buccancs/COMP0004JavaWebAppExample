package uk.ac.ucl.model;

import uk.ac.ucl.dataframe.DataElement;
import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.dataframe.Item;

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
        createDummyModel();
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
        List<Integer> iDList = new ArrayList<Integer>();

        if (this.dataframes == null) {
            throw new Exception("List of dataframes is empty.");
        } else {
            for (Dataframe dataframe : this.dataframes) {
                iDList.add(dataframe.getDataframeId());
            }
            return iDList;
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
        dummyItem1.addDataElement(69, 690, 6901, "URL", "www.google.hu");
        dummyItem2.addDataElement(70, 700, 7001, "URL", "www.google.com");
        Dataframe dummyDataframe1 = Dataframe.create(6901, "dummy dataframe1", "description dummy dataframe1");
        Dataframe dummyDataframe2 = Dataframe.create(7001, "dummy dataframe2", "description dummy dataframe2");
        dummyDataframe1.addItem(dummyItem1);
        dummyDataframe2.addItem(dummyItem2);
        this.dataframes.add(dummyDataframe1);
        this.dataframes.add(dummyDataframe2);
    }

    public List<String> getPatientNames() throws Exception {
        return List.of(String.valueOf(getDataframeById(6900).getItemById(690).getDataElementById(69).getDataType()));
    }


    public void readFile() throws IOException {
        // Read a patient .csv data file and create the DataFrame.
    }

    public void saveFileDataframe(){
        try {
            String valueDataframe = "dataframeId, label, description\n";

            for (Dataframe dataframe : this.getListDataframe()){
                valueDataframe = valueDataframe.concat(dataframe.toString());
                }

            String cwd = System.getProperty("user.dir");

            FileOutputStream fos = new FileOutputStream(cwd + "/data/dataframeData.csv");
            DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
            outStream.writeUTF(valueDataframe);
            outStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOError.");
        }
    }

    public void saveFileItem(){
        try {
            String valueItem = "itemId, parentId,label, description, group\n";

            for (Dataframe dataframe : this.getListDataframe()){
                for (Item item : dataframe.getItems()){
                    valueItem = valueItem.concat(item.toString());
                }
            }

            String cwd = System.getProperty("user.dir");

            FileOutputStream fos1 = new FileOutputStream(cwd + "/data/itemData.csv");
            DataOutputStream outStream1 = new DataOutputStream(new BufferedOutputStream(fos1));
            outStream1.writeUTF(valueItem);
            outStream1.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOError.");
        }
    }

    public void saveFileDataElement(){
        try {

            String valueDataElement = "dataId, parentItemId, parentDataframeId, dataType, data\n";

            for (Dataframe dataframe : this.getListDataframe()){
                for (Item item : dataframe.getItems()){
                    for (DataElement dataElement : item.getDataElements()){
                        valueDataElement = valueDataElement.concat(dataElement.toString());
                    }
                }
            }

            String cwd = System.getProperty("user.dir");

            FileOutputStream fos2 = new FileOutputStream(cwd + "/data/dataElementData.csv");
            DataOutputStream outStream2 = new DataOutputStream(new BufferedOutputStream(fos2));
            outStream2.writeUTF(valueDataElement);
            outStream2.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOError.");
        }
    }
}