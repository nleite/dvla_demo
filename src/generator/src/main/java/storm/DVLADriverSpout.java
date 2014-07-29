package storm;

import generator.DocumentFactory;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

public class DVLADriverSpout extends BaseRichSpout {

    /**
     * 
     */
    private static final long serialVersionUID = -9153643858726218092L;
    DocumentFactory factory;
    SpoutOutputCollector _collector;

    public DVLADriverSpout(DocumentFactory factory) {
        super();
        this.factory = factory;
    }

    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        _collector = collector;

    }

    public void nextTuple() {
//        Utils.sleep(100);
        WorkPackage wp = new WorkPackage();
        
        wp.addDocument(factory.produce());
        
        _collector.emit(new Values(wp));
        
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("loader"));

    }

}
