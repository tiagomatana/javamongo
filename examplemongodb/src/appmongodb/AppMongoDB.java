/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appmongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Oneide
 */
public class AppMongoDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        // TODO code application logic here

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        DB db = mongoClient.getDB("db");

        DBCollection doc = db.getCollection("pessoa");

        BasicDBObject document = new BasicDBObject();
        document.put("nome", "Tiago Matana");
        document.put("anos", 28);
        document.put("dataCadastro", new Date());
        doc.insert(document);

        Set<String> colls = db.getCollectionNames();
        for (String s : colls) {
            System.out.println(s);
        }
        
        DBObject pessoa = doc.findOne();
        System.out.println(pessoa);
    }
}
