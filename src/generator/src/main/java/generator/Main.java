package generator;

import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        
       //number of threads
       //mongodb uri
       //
       String host = "localhost";
       String dbname = "dvla1";
       String colname = "gendrivers";
       MongoClient mc;
       DBCollection collection= null;
    try {
        mc = new MongoClient(host);
        collection = mc.getDB(dbname).getCollection(colname);
    } catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       
       DocumentFactory factory = new DVLADriversFactory();
       
       int idSeed = 10000;
       
       BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(2);
       ThreadPoolExecutor tpe = new ThreadPoolExecutor(10, 20, 1, TimeUnit.MILLISECONDS,queue);        
       
       queue.add(new Loader(collection, factory, idSeed));
       queue.add(new Loader(collection, factory, idSeed+9999999));
//       queue.add(new Loader(collection, factory, idSeed+19999999));
       tpe.prestartAllCoreThreads();
       tpe.execute( new MonitorThread(tpe, 1) );
       
//       while(true){
//           
//       }

    }

}
