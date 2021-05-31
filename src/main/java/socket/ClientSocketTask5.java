package socket;

import entity.Souvenirs;

import java.io.*;
import java.net.Socket;
import java.util.Date;

import static entity.OperationCodes.*;

public class ClientSocketTask5 {
    private Socket socket = null;
    private DataOutputStream out = null;
    private DataInputStream in = null;
    ObjectInputStream objectInputStream;
    public ClientSocketTask5(String ip, int port) throws IOException
    {
        socket = new Socket(ip, port);
        in = new DataInputStream(socket.getInputStream( ));
        out = new DataOutputStream(socket.getOutputStream());
        InputStream inputStream = socket.getInputStream();
        objectInputStream = new ObjectInputStream(inputStream);
    }

    public Souvenirs getAll() throws IOException, ClassNotFoundException {
        out.writeInt(GET_ALL);
        return(Souvenirs) objectInputStream.readObject();
    }

    public void updateProducer(int producer_id,String newname, String newcountry) throws IOException {
        out.writeInt(UPDATE_PRODUCER);
        out.writeInt(producer_id);
        out.writeUTF(newname);
        out.writeUTF(newcountry);
    }
    public void updateItem(int producer_id, int item_id, String newname, int newrequisites, Date newdateOfIssues, int newprice) throws IOException {
        out.writeInt(UPDATE_ITEM);
        out.writeInt(producer_id);
        out.writeInt(item_id);
        out.writeInt(newrequisites);
        out.writeInt(newprice);
        out.writeUTF(newname);
        out.writeUTF(newdateOfIssues);
    }
    public void addProducer(int producer_id, String name, String country) throws IOException {
        out.writeInt(ADD_PRODUCER);
        out.writeInt(producer_id);
        out.writeUTF(name);
        out.writeUTF(country);
    }

    public void addItem(int item_id, String name, int requisites, Date dateOfIssues, int price, int producer_id) throws IOException {
        out.writeInt(ADD_ITEM);
        out.writeInt(producer_id);
        out.writeInt(item_id);
        out.writeInt(requisites);
        out.writeInt(price);
        out.writeUTF(name);
        out.writeUTF(dateOfIssues);
    }
    public void deleteProducer(int producer_id) throws IOException {
        out.writeInt(DELETE_PRODUCER);
        out.writeInt(producer_id);
    }
    public void deleteItem(int producer_id,int item_id) throws IOException {
        out.writeInt(DELETE_ITEM);
        out.writeInt(producer_id);
        out.writeInt(item_id);
    }





}
