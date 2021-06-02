package uk.ac.ucl.dataframe;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private int itemId;
    private int parentId;
    private String label;
    private String description;
    private String group;
//    private List<String> tags;
    private List<SubItem> subItems;

    public static Item createAsItem(int itemId, int parentId, String label, String description, String group) {
        Item item = new Item();
        item.setItemId(itemId);
        item.setParentId(parentId);
        item.setLabel(label);
        item.setDescription(description);
        item.setGroup(group);
        item.setSubItems(new ArrayList<SubItem>());

        return item;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public void addSubItem(SubItem subItem) {
        this.subItems.add(subItem);
    }

    public void addSubItem(int dataId, int parentItemId, int parentDataframeId, String dataLabel, String data) {
        this.subItems.add(SubItem.create(dataId, parentItemId, parentDataframeId, dataLabel, data));
    }

    public List<SubItem> getSubItems() {
        if (this.subItems == null) {
            setSubItems(new ArrayList<SubItem>());
        }
        return subItems;
    }

    public void setSubItems(List<SubItem> subItems) {
        this.subItems = subItems;
    }

    public SubItem getSubItemById(int dataId) throws Exception {
        if (this.subItems == null) {
            throw new Exception("List of sub items is empty.");
        } else {
            for (SubItem subItem : this.subItems) {
                if (subItem.getDataId() == dataId) {
                    return subItem;
                }
            }
            throw new Exception("SubItem with this ID does not exist.");
        }
    }

    public List<Integer> getSubItemIds() throws Exception {
        List<Integer> getSubItemIdList = new ArrayList<Integer>();

        if (this.getSubItems() == null) {
            throw new Exception("List subItems is empty.");
        }
        else{
            for (SubItem subItem : this.getSubItems()) {
                getSubItemIdList.add(subItem.getDataId());
            }
            return getSubItemIdList;
        }
    }

    public void removeSubItem(int dataId) {
        getSubItems().removeIf(subItem -> subItem.getDataId() == dataId);
    }


//    public List<SubItem> getSubItems() {
//        if (this.subItem == null) {
//            setSubItem(new ArrayList<SubItem>());
//        }
//        return subItem;
//    }
//
//    public void addSubItem(int dataId, String dataLabel, String data){
//        SubItem subItem = SubItem.create(dataId, dataLabel, data);
//
//    }

    @Override
    public String toString() {
        return itemId + "," + parentId + "," + label + "," + description + "," + group + "\n";
    }
}
