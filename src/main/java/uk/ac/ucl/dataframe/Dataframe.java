package uk.ac.ucl.dataframe;

import java.util.ArrayList;
import java.util.List;

public class Dataframe {
    private int dataframeId;
    private String label;
    private String description;
//    private List<String> tags;
    private List<Item> items;

    public static Dataframe create(int dataFrameId, String label, String description) {
        Dataframe dataframe = new Dataframe();
        dataframe.setDataframeId(dataFrameId);
        dataframe.setLabel(label);
        dataframe.setDescription(description);
//        dataframe.setTags(new ArrayList<String>());
        dataframe.setItems(new ArrayList<Item>());

        return dataframe;
    }

    public int getDataframeId() {
        return dataframeId;
    }

    public void setDataframeId(int dataframeId) {
        this.dataframeId = dataframeId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public void setTags(List<String> tags) {
//        this.tags = tags;
//    }
//
//    public void addTag(String tag) {
//        if (!tags.contains(tag)) {
//            tags.add(tag);
//        }
//    }
//
//    public void removeTag(String tag) {
//        tags.remove(tag);
//    }
//
    public void addItem(int itemId, int parentId, String label, String description, String group) {
        Item newItem = Item.createAsItem(itemId, parentId, label, description, group);
        this.items.add(newItem);
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        if (this.items == null) {
            setItems(new ArrayList<Item>());
        }
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItemById(int itemId) throws Exception {
        if (this.items == null) {
            throw new Exception("List of items is empty.");
        } else {
            for (Item item : this.items) {
                if (item.getItemId() == itemId) {
                    return item;
                }
            }
            throw new Exception("Item with this ID does not exist. Id:" + itemId);
        }
    }

    public List<Integer> getItemIds() throws Exception {
        List<Integer> getItemIdList = new ArrayList<Integer>();

        if (this.getItems() == null) {
            throw new Exception("List of items is empty.");
        }
        else{
                for (Item item : this.getItems()) {
                    getItemIdList.add(item.getItemId());
                }
                return getItemIdList;
            }
    }

    public void removeItem(int itemId) {
        getItems().removeIf(subItem -> subItem.getItemId() == itemId);
    }

    @Override
    public String toString() {
        return dataframeId + "," + label + "," + description + "\n";
    }

}
