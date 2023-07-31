package org.example;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class MongoManager {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public MongoManager(String connectionString, String databaseName, String collectionName) {
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase(databaseName);
        collection = database.getCollection(collectionName);
    }

    public void insertDocument(Document document) {
        collection.insertOne(document);
    }

    public Document findDocument(String key, Object value) {
        return collection.find(Filters.eq(key, value)).first();
    }

    public void updateDocument(String key, Object value, String updateKey, Object updateValue) {
        collection.updateOne(Filters.eq(key, value), Updates.set(updateKey, updateValue));
    }

    public void deleteDocument(String key, Object value) {
        collection.deleteOne(Filters.eq(key, value));
    }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
