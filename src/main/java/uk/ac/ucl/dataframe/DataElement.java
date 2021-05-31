package uk.ac.ucl.dataframe;

public class DataElement {
    private int dataId;
    private int parentItemId;
    private int parentDataframeId;
    private String dataType;
    private String data;

    public static DataElement create(int dataId, int parentItemId, int parentDataframeId, String dataType, String data){
        DataElement dataElement = new DataElement();
        dataElement.setDataId(dataId);
        dataElement.setParentItemId(parentItemId);
        dataElement.setParentDataframeId(parentDataframeId);
        dataElement.setDataType(dataType);
        dataElement.setData(data);

        return dataElement;
    }

    public void update(String data){
        this.data = data;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public int getDataId(){
        return this.dataId;
    }

    public void setParentItemId(int parentItemId) {
        this.parentItemId = parentItemId;
    }

    public int getParentItemId() {
        return parentItemId;
    }

    public void setParentDataframeId(int parentDataframeId) {
        this.parentDataframeId = parentDataframeId;
    }

    public int getParentDataframeId() {
        return parentDataframeId;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType(){
        return this.dataType;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData(){
        return this.data;
    }

//    @Override
//    public String toString() {
//        final StringBuilder dataElementString = new StringBuilder("DataElement{");
//        dataElementString.append("dataId=").append(dataId);
//        dataElementString.append(", dataType='").append(dataType);
//        dataElementString.append(", data=").append(data);
//        dataElementString.append('}');
//        return dataElementString.toString();
//    }
}
