package org.example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Iterator;

public class MongoManipulation {

    public final String HOST;
    public final int PORT;

    public MongoManipulation(String HOST, int PORT) {
        this.HOST = HOST;
        this.PORT = PORT;
    }

    public MongoClient connect(){
        MongoClient client = new MongoClient(HOST, PORT);
        System.out.println("Created Mongo Connection successfully");
        return client;

    }

    public static void getDatabase(String database){

        // Creating/Getting database
//        MongoDatabase db = client.getDatabase(database);
//        System.out.println("Get database is successful");
//
//        MongoClient client = new MongoClient(host, port);
//        System.out.println("Created Mongo Connection successfully");

    }

    //Listing All Mongo Documents in Collection
    public void showAllDocs(MongoCollection<Document> collection){

        FindIterable<Document> iterDoc = collection.find();
        int i = 1;

        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
    }
}
