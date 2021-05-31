package entity;

import java.util.ArrayList;
import java.util.Date;

public class Souvenirs {
    private ArrayList<Produсer> produсers = new ArrayList<>();

    public void addProducer(int producer_id, String name, String country){
        produсers.add(new Produсer(producer_id, name, country));
    }

    public  void  addProducer(Produсer produсer){produсers.add(produсer);}

    public Produсer getProducer(int producer_id){
        for(int i = 0;i  < produсers.size(); i++){
            if(produсers.get(i).producer_id == producer_id){
                return produсers.get(i);
            }
        }
        return null;
    }

public ArrayList<Produсer> getProduсers(){return produсers;}

    public void deleteProducer(int producer_id) throws Exception{
        Produсer produсerToDelete= getProducer(producer_id);
        if(produсerToDelete == null){
            throw new Exception("Producer doesnt exist");
        }
        produсers.remove(produсerToDelete);
    }
    public void addItem(int item_id, String name, int requisites, Date dateOfIssues, int price, int product_id) throws Exception{
        Produсer produсer=getProducer(product_id);
        if(produсer == null){
            throw new Exception("Producer doesnt exist");
        }
        ArrayList<Item> items= produсer.getItems();
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).item_id == item_id){
                throw new Exception("This item has already exist");
            }
        }
        Item item = new Item(item_id, name, requisites,  dateOfIssues,  price);
        produсer.addItem(item );
    }


}
