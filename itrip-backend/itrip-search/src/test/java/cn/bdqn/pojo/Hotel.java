package cn.bdqn.pojo;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * Created by shang-pc on 2017/7/3.
 */
public class Hotel implements Serializable {

    //@Field
    //private Integer id;

    @Field
    private String id;

    @Field
    private String hotelName;

    @Field
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
