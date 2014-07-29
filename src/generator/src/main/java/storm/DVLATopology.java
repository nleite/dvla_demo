package storm;

import generator.DVLADriversFactory;
import backtype.storm.topology.TopologyBuilder;

public class DVLATopology {

    
    public TopologyBuilder run(final int bolts, final int spouts){
        TopologyBuilder tbuilder = new TopologyBuilder();
        DVLADriversFactory factory = new DVLADriversFactory();
        tbuilder.setSpout("factory", new DVLADriverSpout(factory), spouts);
        tbuilder.setBolt("loader", new DVLABolt(), bolts).shuffleGrouping("factory");
        return tbuilder;
    }
    
}
