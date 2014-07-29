package generator;

import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.cli.*;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Main {

    public static void main(String[] args) {
        Options options = new Options();
        Option hostOp = new Option("h", "host", true, "MongoDB host name");
        Option threadsOp = new Option("t", "threads", true, "number of threads to be launched");
        Option databaseOp = new Option("d", "database", true, "Database name");
        Option collectionOp = new Option("c", "collection", true, "Collection name");
        options.addOption(hostOp);
        options.addOption(threadsOp);
        options.addOption(databaseOp);
        options.addOption(collectionOp);
        
        String host = "localhost";
        String dbname = "dvla1";
        String colname = "gendrivers";
        MongoClient mc;
        DBCollection collection = null;
        CommandLineParser parser = new BasicParser();
        int nthreads = 1;
        try {
            CommandLine cmdLine = parser.parse(options, args);
            if (cmdLine.hasOption('t'))
                nthreads = Integer.valueOf(cmdLine.getOptionValue('t'));
            if (cmdLine.hasOption('d'))
                dbname = cmdLine.getOptionValue('d');
            if (cmdLine.hasOption('c'))
                colname = cmdLine.getOptionValue('c');
            if (cmdLine.hasOption('h'))
                host = cmdLine.getOptionValue('h');
            
            mc = new MongoClient(host);
            collection = mc.getDB(dbname).getCollection(colname);

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        DocumentFactory factory = new DVLADriversFactory();

        int idSeed = 10000;

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(nthreads);
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(10, 20, 1, TimeUnit.MILLISECONDS, queue);

        for (int i = 0; i < nthreads; i++) {
            queue.add(new Loader(collection, factory, idSeed));
        }
        tpe.prestartAllCoreThreads();
        tpe.execute(new MonitorThread(tpe, 1));

    }

}
