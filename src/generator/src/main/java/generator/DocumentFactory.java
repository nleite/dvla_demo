package generator;

import com.mongodb.DBObject;

public interface DocumentFactory {

    
    public DBObject produce();
    
}
