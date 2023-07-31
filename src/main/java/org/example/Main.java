package org.example;

import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {

        // Creating MongoDB Java Connection
        MongoManipulation mongo = new MongoManipulation("localhost", 27017);

        MongoClient client = mongo.connect();

        // Creating/Getting database
        MongoDatabase db = client.getDatabase("school");
        System.out.println("Get database is successful");

        // Creating collection or get collection if exists.
        MongoCollection<Document> collection= db.getCollection("students");
        System.out.println("collection created ");


        //Inserting sample records by creating documents.
        /*Document doc =new Document("name","khalid");
        doc.append("age",25);
        doc.append("class", "master-m2i");
        collection.insertOne(doc);
        System.out.println("Insert is completed");*/


        //Listing All Mongo Documents in Collection

        mongo.showAllDocs(collection);

        //specific document retrieving in a collection
        /*BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "SimplifyingTech");
        System.out.println("Retrieving specific Mongo Document");
        MongoCursor<Document> cursor = collection.find(searchQuery).iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }*/
    }
}