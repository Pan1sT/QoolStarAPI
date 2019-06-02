package me.pan.qoolstarapi.utils;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import lombok.Setter;
import me.pan.qoolstarapi.PlayerManager;
import me.pan.qoolstarapi.QoolStarAPI;
import org.bson.Document;
import java.util.UUID;

@Getter
@Setter
public class MongoDB {

    @Getter
    public static MongoDB instance;
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> coll;


    public MongoDB () {
        try {
            instance = this;
            mongoClient = MongoClients.create();
            database = mongoClient.getDatabase("QoolStarAPI");
            coll = database.getCollection("QoolStarAPI");

            System.out.println("成功連線至數據庫!");
        } catch (Exception e) {
            //When you end up here, the server the db is running on could not be found!
            System.out.println("無法連線至數據庫!");
            e.printStackTrace();
        }
    }

    /*
    public void firstInsert(UUID uuid){
        Document doc = new Document("UUID", uuid.toString())
                .append("Atk_Multiplier", 0)
                .append("Def_Multiplier", 0)
                .append("Crit_Probit", 0)
                .append("Crit_Multiplier", 0);
        coll.insertOne(doc);
        QoolStarAPI..put(uuid, new PlayerManager(uuid.toString(), 0.0, 0.0, 0.0, 0.0));
    }

    public void storePlayer(UUID uuid){
        Document playerdoc = new Document("UUID", uuid.toString());
        Document found = (Document) coll.find(playerdoc).first();
        if (found == null){
            firstInsert(uuid);
        }else{
            Double Atk_Multiplier = found.getDouble("Atk_Multiplier");
            Double Def_Multiplier = found.getDouble("Def_Multiplier");
            Double Crit_Probit = found.getDouble("Crit_Probit");
            Double Crit_Multiplier = found.getDouble("Crit_Multiplier");
            QoolStarAPI.getInstance().getPlayerDataHashMap().put(uuid, new PlayerManager(uuid.toString(), Atk_Multiplier, Def_Multiplier, Crit_Probit, Crit_Multiplier));

        }


    } */
}
