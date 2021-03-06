package me.hailu.mongo;

import org.bson.types.ObjectId;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: liming_liu
 * Date: 14-9-13
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */
public class ObjectIdAdaptor extends XmlAdapter<String, ObjectId> {

    @Override
    public String marshal(ObjectId v) throws Exception {
        return v.toString();
    }

    @Override
    public ObjectId unmarshal(String v) throws Exception {
        return new ObjectId(v);
    }
}
