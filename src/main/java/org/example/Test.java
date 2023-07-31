package org.example;

import org.bson.Document;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        MongoManager manager = new MongoManager("mongodb://localhost:27017", "company", "employees");

        // Insert a document
//        Document newDocument = new Document("name", "karim")
//                .append("age", 51)
//                .append("email", "kar46@gmail.com");
//        manager.insertDocument(newDocument);

        // Find a document
        Document foundDocument = manager.findDocument("name", "karim");
        System.out.println("Found document: " + foundDocument);

        // Find all document
        List<Document> allDocuments = manager.findAllDocuments();
        for (Document doc: allDocuments) {
            System.out.println(doc);
        }


        // Update a document
        //manager.updateDocument("name", "Mounir", "name", "samir");

        // Delete a document
        //manager.deleteDocument("name", "Mounir");

        // Delete all documents from the collection
//        long deletedCount = manager.deleteAllDocuments();
//        System.out.println("Deleted " + deletedCount + " documents from the collection.");


        manager.closeConnection();
    }
}
