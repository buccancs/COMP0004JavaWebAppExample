package uk.ac.ucl.dataframe;

import java.util.*;

public class Dataframe {
    private int dataFrameId;
    private String label;
    private String description;
    private List<String> tags;
    private List<Item> items;

    public static Dataframe create(int dataFrameId, String label, String description){
        Dataframe dataFrame = new Dataframe();
        dataFrame.setDataFrameId(dataFrameId);
        dataFrame.setLabel(label);
        dataFrame.setDescription(description);
        dataFrame.setTags(new ArrayList<String>());
        dataFrame.setItems(new ArrayList<Item>());

        return dataFrame;
    }

    public void setDataFrameId(int dataFrameId) {
        this.dataFrameId = dataFrameId;
    }

    public int getDataFrameId() {
        return dataFrameId;
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

    public void addItem(int itemId, int parentId, String label, String description, String group) {
        Item newItem = Item.createAsItem(itemId, parentId, label, description, group);
        this.items.add(newItem);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        if (this.items == null) {
            setItems(new ArrayList<Item>());
        }
        return items;
    }

    public Item getItemById(int itemId) throws Exception{
        if (this.items == null){
            throw new Exception("List of items is empty.");
        }
        else {
            for (Item item : this.items){
                if (item.getItemId() == itemId){
                    return item;
                }
            }
            throw new Exception("Item with this ID does not exist.");
        }
    }


    public void removeSubItem(int subItemId) {
        getItems().removeIf(subItem -> subItem.getItemId() == subItemId);
    }
//
//    @Override
//    public String toString() {
//        StringBuilder itemString = new StringBuilder("Dataframe{");
//        itemString.append("dataFrameId=").append(dataFrameId);
//        itemString.append(", label='").append(label);
//        itemString.append(", description=").append(description);
//        itemString.append(", tags=");
//        tags.forEach((tag) -> itemString.append(tag).append(" ,"));
//        itemString.append(", items=");
//        items.forEach((item) -> itemString.append(item.toString()).append(" ,"));
//        itemString.append('}');
//
//        return itemString.toString();
//    }

}
