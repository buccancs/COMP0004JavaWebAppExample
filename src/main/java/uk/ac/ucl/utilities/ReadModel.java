package uk.ac.ucl.utilities;

import uk.ac.ucl.dataframe.Dataframe;
import uk.ac.ucl.dataframe.Item;
import uk.ac.ucl.dataframe.SubItem;
import uk.ac.ucl.model.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadModel {

    public static List<List<String>> readFile(String dataPath) {
        List<List<String>> allLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dataPath))) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                allLines.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allLines;
    }

    public static void readDataframes(Model model, String dataPath) {

        List<List<String>> allDataframes = readFile(dataPath + "/dataframeData.csv");

        for (List<String> line : allDataframes) {
            Dataframe dataframe = Dataframe.create(Integer.parseInt(line.get(0)), line.get(1), line.get(2));
            model.addDataframe(dataframe);
        }

    }

    public static void readItems(Model model, String dataPath) throws Exception {
        List<List<String>> allItems = readFile(dataPath + "/itemData.csv");

        for (List<String> line : allItems) {
            Item item = Item.createAsItem(Integer.parseInt(line.get(0)), Integer.parseInt(line.get(1)), line.get(2), line.get(3), line.get(4));
            model.getDataframeById(Integer.parseInt(line.get(1))).addItem(item);
        }
    }

    public static void readSubItems(Model model, String dataPath) throws Exception {
        List<List<String>> allSubItems = readFile(dataPath + "/subItemData.csv");

        for (List<String> line : allSubItems) {
            SubItem subItem = SubItem.create(Integer.parseInt(line.get(0)), Integer.parseInt(line.get(1)), Integer.parseInt(line.get(2)), line.get(3), line.get(4));
            model.getDataframeById(Integer.parseInt(line.get(2))).getItemById(Integer.parseInt(line.get(1))).addSubItem(subItem);
        }
    }

    public static void readAllElements(Model model) throws Exception {
        String dataPath = System.getProperty("user.dir") + "/data";

        readDataframes(model, dataPath);
        readItems(model, dataPath);
        readSubItems(model, dataPath);
    }
}
