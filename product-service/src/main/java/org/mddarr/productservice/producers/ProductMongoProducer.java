package org.mddarr.productservice.producers;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class ProductMongoProducer {
    public static void main(String... args) throws Exception {
        Document document;
        Document inner;
        String row;
        String[] columns;
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("test");

//        db.createCollection("products");
        MongoCollection<Document> dbCollection = db.getCollection("products");
        List<String> sizes = new ArrayList<>(Arrays.asList("6","6.5","7","7.5","8","8.5","9","9.5","10"));
        List<String> colors = new ArrayList<>(Arrays.asList("Red","Blue","Orange"));

        UUID uuid;
        try {
            BufferedReader br = new BufferedReader(new FileReader("stack/db/prods.csv"));
            while((row = br .readLine()) != null) {
                uuid = UUID.randomUUID();
                columns = row.split(",");
                System.out.println(columns[1]);
                inner = new Document();
                for(int i =0; i < colors.size(); i++){
                            inner
                            .append("AttributeName", "Color")
                            .append("AttributeId", i)
                            .append("AttributeValue", colors.get(i))
                            .append("productID",uuid);
                }
                document = new Document()
                        .append("id", uuid)
                        .append("name", columns[0])
                        .append("brand", columns[1])
                        .append("imageurl",columns[3])
                        .append("sizes",sizes)
                        .append("colors",colors)
                        .append("price", columns[4])
                        .append("description", columns[5])
                        .append("Color", inner);
                dbCollection.insertOne (document);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }


    }
}
