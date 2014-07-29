package storm;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.utils.Utils;

public class Main {

    public static void main(String[] args) {
        Options options = new Options();
        Option hostOp = new Option("h", "host", true, "MongoDB host name");
        Option boltsOp = new Option("b", "bolts", true, "number bolts");
        Option spoutsOp = new Option("s", "spouts", true, "number of spouts");
        Option databaseOp = new Option("d", "database", true, "Database name");
        Option collectionOp = new Option("c", "collection", true, "Collection name");
        options.addOption(hostOp);
        options.addOption(boltsOp);
        options.addOption(spoutsOp);
        options.addOption(databaseOp);
        options.addOption(collectionOp);
        
        String host = "localhost";
        String dbname = "dvla1";
        String colname = "gendrivers";
        CommandLineParser parser = new BasicParser();
        int boltNumber = 1;
        int spoutNumber = 1;
        try {
            CommandLine cmdLine = parser.parse(options, args);
            if (cmdLine.hasOption('b'))
                boltNumber = Integer.valueOf(cmdLine.getOptionValue('b'));
            if (cmdLine.hasOption('s'))
                spoutNumber = Integer.valueOf(cmdLine.getOptionValue('s'));
            if (cmdLine.hasOption('d'))
                dbname = cmdLine.getOptionValue('d');
            if (cmdLine.hasOption('c'))
                colname = cmdLine.getOptionValue('c');
            if (cmdLine.hasOption('h'))
                host = cmdLine.getOptionValue('h');

        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        Config conf = new Config();
        conf.put("database", dbname);
        conf.put("collection", colname);
        LocalCluster cluster = new LocalCluster();
        DVLATopology topology = new  DVLATopology();
        cluster.submitTopology("test", conf, topology.run(boltNumber, spoutNumber).createTopology());
        Utils.sleep(100);
        
    }

}
