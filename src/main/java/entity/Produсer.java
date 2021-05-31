package entity;

import entity.Item;

import java.io.Serializable;
import java.util.ArrayList;

public class Produсer implements Serializable {
  public  int producer_id;
  public  String name;
  public  String country;
  private  final ArrayList<Item> items = new ArrayList<>();

  public  ArrayList<Item> getItems(){return  items;};

    public void addItem(Item item){
        items.add(item);
    }

  public Produсer(int producer_id, String name, String country) {
    this.producer_id = producer_id;
    this.name = name;
    this.country = country;
  }

}
