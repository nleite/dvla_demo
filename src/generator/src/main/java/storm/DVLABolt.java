package storm;

import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

import com.mongodb.BulkWriteOperation;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

public class DVLABolt extends BaseRichBolt{

    DBCollection collection;
    OutputCollector _collector;
    BulkWriteOperation bulk;
    int counter;
    int limit;

    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        _collector = collector;
        MongoClient mc=null;
        
        try {
            mc = new MongoClient();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        collection = mc.getDB((String) stormConf.get("database")).getCollection((String) stormConf.get("collection"));
        limit = 1000;
//        bulk = collection.initializeUnorderedBulkOperation();
    }

    public void execute(Tuple input) {
        for ( Object o :  input.getValues()){
            for ( Object a : ((WorkPackage)o).getValues()){
                collection.insert((DBObject)a, WriteConcern.UNACKNOWLEDGED );
//                bulk.insert((DBObject)a);
            }
        }
//        counter++;
//        if (counter > limit){
//            bulk.execute();
//            counter=0;
//            bulk = collection.initializeUnorderedBulkOperation();
//        }
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("loader"));
        
    }

}
