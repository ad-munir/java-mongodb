package org.example;

import org.bson.Document;

public class Test {

    public static void main(String[] args) {
        // Example usage:
        MongoManager manager = new MongoManager("mongodb://localhost:27017", "company", "employees");

        // Insert a document
        Document newDocument = new Document("name", "Mounir")
                .append("age", 30)
                .append("email", "mon54@gmail.com");
        manager.insertDocument(newDocument);

        // Find a document
        Document foundDocument = manager.findDocument("name", "reda");
        System.out.println("Found document: " + foundDocument);

        // Update a document
        manager.updateDocument("name", "Karim", "age", 31);

        // Delete a document
        manager.deleteDocument("name", "Karim");

        manager.closeConnection();
    }
}
