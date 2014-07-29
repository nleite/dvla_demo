package storm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.DBObject;

import backtype.storm.generated.GlobalStreamId;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.MessageId;
import backtype.storm.tuple.Tuple;

public class WorkPackage implements Serializable, Tuple {

    /**
     * 
     */
    private static final long serialVersionUID = -2780457832044766576L;
    List<Object> os;
    
    public WorkPackage() {
        super();
        this.os = new ArrayList<Object>();
    }
    
    
    public void addDocument(DBObject doc){
        os.add(doc);
    }

    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int fieldIndex(String field) {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean contains(String field) {
        // TODO Auto-generated method stub
        return false;
    }

    public Object getValue(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    public String getString(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    public Integer getInteger(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getLong(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    public Boolean getBoolean(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    public Short getShort(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    public Byte getByte(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    public Double getDouble(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    public Float getFloat(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    public byte[] getBinary(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    public Object getValueByField(String field) {
        // TODO Auto-generated method stub
        return null;
    }

    public String getStringByField(String field) {
        // TODO Auto-generated method stub
        return null;
    }

    public Integer getIntegerByField(String field) {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getLongByField(String field) {
        // TODO Auto-generated method stub
        return null;
    }

    public Boolean getBooleanByField(String field) {
        // TODO Auto-generated method stub
        return null;
    }

    public Short getShortByField(String field) {
        // TODO Auto-generated method stub
        return null;
    }

    public Byte getByteByField(String field) {
        // TODO Auto-generated method stub
        return null;
    }

    public Double getDoubleByField(String field) {
        // TODO Auto-generated method stub
        return null;
    }

    public Float getFloatByField(String field) {
        // TODO Auto-generated method stub
        return null;
    }

    public byte[] getBinaryByField(String field) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Object> getValues() {
        return os;
    }

    public Fields getFields() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Object> select(Fields selector) {
        // TODO Auto-generated method stub
        return null;
    }

    public GlobalStreamId getSourceGlobalStreamid() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getSourceComponent() {
        // TODO Auto-generated method stub
        return null;
    }

    public int getSourceTask() {
        // TODO Auto-generated method stub
        return 0;
    }

    public String getSourceStreamId() {
        // TODO Auto-generated method stub
        return null;
    }

    public MessageId getMessageId() {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
