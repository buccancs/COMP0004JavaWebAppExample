package uk.ac.ucl.model;

import uk.ac.ucl.dataframe.Dataframe;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Dataframe> dataframes;

    public Model() {
        this.setListDataframe(new ArrayList<Dataframe>());
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
}