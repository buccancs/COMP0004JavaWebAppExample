package uk.ac.ucl.dataframe;

public class DataElement {
    private int dataId;
    private String dataType;
    private String data;

    public static DataElement create(int dataId, String dataType, String data){
        DataElement dataElement = new DataElement();
        dataElement.setDataId(dataId);
        dataElement.setDataType(dataType);
        dataElement.setDataType(data);

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
