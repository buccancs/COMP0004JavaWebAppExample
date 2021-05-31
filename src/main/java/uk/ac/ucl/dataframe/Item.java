package uk.ac.ucl.dataframe;

import java.util.*;

public class Item {
    private int itemId;
    private int parentId;
    private String label;
    private String description;
    private String group;
    private List<String> tags;
    private List<DataElement> dataElements;

    public static Item createAsItem(int itemId, int parentId, String label, String description, String group) {
        Item item = new Item();
        item.setItemId(itemId);
        item.setParentId(parentId);
        item.setLabel(label);
        item.setDescription(description);
        item.setGroup(group);
        item.setDataElements(new ArrayList<DataElement>());

        return item;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addTag(String tag) {
        if (!tags.contains(tag)) {
            tags.add(tag);
        }
    }

    public void removeTag(String tag) {
        tags.remove(tag);
    }

    public void setDataElements(List<DataElement> dataElements) {
        this.dataElements = dataElements;
    }

    public void addDataElement(DataElement dataElement) {
        this.dataElements.add(dataElement);
    }

    public void addDataElement(int dataId, int parentItemId, int parentDataframeId, String dataLabel, String data) {
        this.dataElements.add(DataElement.create(dataId, parentItemId, parentDataframeId, dataLabel, data));
    }

    public List<DataElement> getDataElements() {
        if (this.dataElements == null) {
            setDataElements(new ArrayList<DataElement>());
        }
        return dataElements;
    }

    public DataElement getDataElementById(int dataId) throws Exception {
        if (this.dataElements == null){
            throw new Exception("List of data elements is empty.");
        }
        else {
            for (DataElement dataElement : this.dataElements){
                if (dataElement.getDataId() == dataId){
                    return dataElement;
                }
            }
            throw new Exception("DataElement with this ID does not exist.");
        }
    }

    public void removeDataElement(int dataId) {
        getDataElements().removeIf(dataElement -> dataElement.getDataId() == dataId);
    }


//    public List<DataElement> getDataElements() {
//        if (this.dataElement == null) {
//            setDataElement(new ArrayList<DataElement>());
//        }
//        return dataElement;
//    }
//
//    public void addDataElement(int dataId, String dataLabel, String data){
//        DataElement dataElement = DataElement.create(dataId, dataLabel, data);
//
//    }

//    @Override
//    public String toString() {
//        final StringBuilder itemString = new StringBuilder("Item{");
//        itemString.append("itemId=").append(itemId);
//        itemString.append(", label='").append(label);
//        itemString.append(", description=").append(description);
//        itemString.append(", group=").append(group);
//        itemString.append(", tags=");
//        tags.forEach((tag) -> itemString.append(tag).append(" ,"));
//        itemString.append(dataElement.toString());
//        itemString.append('}');
//
//        return itemString.toString();
//    }

}
