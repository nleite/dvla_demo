package generator;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class Loader implements Runnable {

    private DBCollection collection;
    
    private DocumentFactory factory;
    
    private int idSeed;
    
    public Loader(DBCollection collection, DocumentFactory factory, int idSeed) {
        super();
        this.collection = collection;
        this.factory = factory;
        this.idSeed = idSeed;
    }


    
    private void insertDocument(DBObject doc){
        try{
            collection.insert(doc);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void run() {
        while( !Thread.currentThread().isInterrupted()){
            DBObject obj = factory.produce();
            obj.put("_id", idSeed++);
            insertDocument(obj);
        }
        
    }
    
    
    
    
    
    
}
