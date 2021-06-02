package uk.ac.ucl.utilities;

import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.dataframe.Item;
import uk.ac.ucl.dataframe.SubItem;
import uk.ac.ucl.model.Model;

import java.io.*;


public class SaveModel {

    public static void saveDataframes(Model model){

        String currentWorkingDirectory = System.getProperty("user.dir");
        try {
            String valueDataframe = "dataframeId, label, description\n";

            for (Dataframe dataframe : model.getListDataframe()){
                valueDataframe = valueDataframe.concat(dataframe.toString());
            }

            FileOutputStream fileOutputStream = new FileOutputStream(currentWorkingDirectory + "/data/dataframeData.csv");
            DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
            try {
                outStream.writeUTF(valueDataframe);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            outStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOError.");
        }
    }

    public static void saveItems(Model model){

        String currentWorkingDirectory = System.getProperty("user.dir");
        try {
            String valueItem = "itemId, parentId, label, description, group\n";

            for (Dataframe dataframe : model.getListDataframe()){
                for (Item item : dataframe.getItems()){
                    valueItem = valueItem.concat(item.toString());
                }
            }

            FileOutputStream fileOutputStream = new FileOutputStream(currentWorkingDirectory + "/data/itemData.csv");
            DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
            try{
                outStream.writeUTF(valueItem);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            outStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOError.");
        }
    }

    public static void saveSubItems(Model model){

        String currentWorkingDirectory = System.getProperty("user.dir");
        try {

            String valueSubItem = "dataId, parentItemId, parentDataframeId, dataType, data\n";

            for (Dataframe dataframe : model.getListDataframe()){
                for (Item item : dataframe.getItems()){
                    for (SubItem subItem : item.getSubItems()){
                        valueSubItem = valueSubItem.concat(subItem.toString());
                    }
                }
            }

            FileOutputStream fileOutputStream = new FileOutputStream(currentWorkingDirectory + "/data/subItemData.csv");
            DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fileOutputStream));
            try {
                outStream.writeUTF(valueSubItem);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            outStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOError.");
        }
    }

    public static void saveAllElements(Model model){

        String currentWorkingDirectory = System.getProperty("user.dir");

        saveDataframes(model);
        saveItems(model);
        saveSubItems(model);
    }
}
