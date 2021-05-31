package dao;

import  entity.Souvenirs;

import java.util.Date;

public interface IDAO {
    Souvenirs getAll();
    void addItem(int item_id, String name, int requisites, Date dateOfIssues, int price, int producer_id);
    void addProducer(int producer_id, String name, String country);
    void deleteItem(int producer_id,int item_id);
    void deleteProducer(int producer_id);
    void updateItem(int producer_id, int item_id,  String newname, int newrequisites, Date newdateOfIssues, int newprice);
    void updateProducer(int producer_id,String newname, String newcountry);



}
