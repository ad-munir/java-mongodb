package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

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

    public List<Document> findAllDocuments() {
        List<Document> documentsList = new ArrayList<>();
        FindIterable<Document> documents = collection.find();
        MongoCursor<Document> cursor = documents.iterator();

        while (cursor.hasNext()) {
            Document document = cursor.next();
            documentsList.add(document);
        }

        return documentsList;
    }

    public void deleteDocument(String key, Object value) {
        collection.deleteOne(Filters.eq(key, value));
    }

    public long deleteAllDocuments() {
        DeleteResult result = collection.deleteMany(new Document());
        return result.getDeletedCount();
    }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
