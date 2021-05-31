package entity;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
    public int item_id;
    public String name;
    public int requisites;
    public Date dateOfIssues;
    public int price;

    public Item(int item_id, String name, int requisites, Date dateOfIssues, int price) {
        this.item_id = item_id;
        this.name = name;
        this.requisites = requisites;
        this.dateOfIssues = dateOfIssues;
        this.price = price;
    }


}
