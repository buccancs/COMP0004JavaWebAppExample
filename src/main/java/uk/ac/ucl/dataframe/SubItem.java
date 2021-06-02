package uk.ac.ucl.dataframe;

public class SubItem {
    private int dataId;
    private int parentItemId;
    private int parentDataframeId;
    private String dataType;
    private String data;

    public static SubItem create(int dataId, int parentItemId, int parentDataframeId, String dataType, String data) {
        SubItem subItem = new SubItem();
        subItem.setDataId(dataId);
        subItem.setParentItemId(parentItemId);
        subItem.setParentDataframeId(parentDataframeId);
        subItem.setDataType(dataType);
        subItem.setData(data);

        return subItem;
    }

    public void update(String data) {
        this.data = data;
    }

    public int getDataId() {
        return this.dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public int getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(int parentItemId) {
        this.parentItemId = parentItemId;
    }

    public int getParentDataframeId() {
        return parentDataframeId;
    }

    public void setParentDataframeId(int parentDataframeId) {
        this.parentDataframeId = parentDataframeId;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return dataId + "," + parentItemId + "," + parentDataframeId + "," + dataType + "," + data + "\n";
    }
}
