package socket;

import dao.DAO;
import entity.Souvenirs;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.sql.SQLException;

public class ServerSocketTask5 {

    private ServerSocket server = null;
    private Socket socket = null;
    private DataOutputStream out = null;
    private DataInputStream in = null;
    ObjectOutputStream objectOutputStream;
    OutputStream outputStream;
    DAO dao;
    public ServerSocketTask5(){

    }
    public void start(int port) throws IOException, SQLException, ClassNotFoundException {
        dao = new DAO();
        server = new ServerSocket(port);
        socket = server.accept();
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        outputStream = socket.getOutputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);
        System.out.println("running...");
        while (true) {
            int code = in.readInt();
            switch(code){
                case 0:{
                    getAll();
                    break;
                }
                case 1:{
                    updateProducer();
                    break;
                }
                case 2:{
                    updateItem();
                    break;
                }
                case 3:{
                    addProducer();
                    break;
                }
                case 4:{
                    addItem();
                    break;
                }
                case 5:{
                    deleteProducer();
                    break;
                }
                case 6:{
                    deleteItem();
                    break;
                }
            }
        }
    }
    public void getAll() throws IOException {
        Souvenirs souvenirs = dao.getAll();
        objectOutputStream.writeObject(souvenirs);
    }
    public void updateProducer() throws IOException {
        int producer_id = in.readInt();
        String newname = in.readUTF();
        String newcountry = in.readUTF();
        dao.updateProducer(producer_id, newname, newcountry);
    }
    public void updateItem() throws IOException {
        int producer_id = in.readInt();
        int item_id = in.readInt();
        int newprice = in.readInt();
        int newrequisites = in.readInt();
        String newname = in.readUTF();
        Date newdateOfIssues = in.read();
        dao.updateItem(producer_id, item_id, newname, newrequisites, newdateOfIssues,newprice);

    }
    public void addProducer() throws IOException {
        int producer_id = in.readInt();
        String name = in.readUTF();
        String country = in.readUTF();
        dao.updateProducer(producer_id, name, country);
    }
    public void addItem() throws IOException {
        int producer_id = in.readInt();
        int item_id = in.readInt();
        int price = in.readInt();
        int requisites = in.readInt();
        String name = in.readUTF();
        Date dateOfIssues = in.read();
        dao.addItem( producer_id, item_id, name, requisites, dateOfIssues, price);
    }
    public void deleteProducer() throws IOException {
        int producer_id = in.readInt();
        dao.deleteProducer(producer_id);
    }

    public void deleteItem() throws IOException {
        int producer_id = in.readInt();
        int item_id = in.readInt();
        dao.deleteItem(producer_id, item_id);
    }
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        ServerSocketTask5 server = new ServerSocketTask5();
        server.start(65000);
    }


}
