package per.kky.common.dto;


import cn.hutool.core.convert.Convert;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Kv extends LinkedCaseInsensitiveMap<Object> {
    private Kv() {
    }

    public static Kv create() {
        return new Kv();
    }

    public static <K, V> HashMap<K, V> newMap() {
        return new HashMap(16);
    }

    public Kv set(String attr, Object value) {
        this.put(attr, value);
        return this;
    }

    public Kv setAll(Map<? extends String, ?> map) {
        if (map != null) {
            this.putAll(map);
        }

        return this;
    }

    public Kv setIgnoreNull(String attr, Object value) {
        if (attr != null && value != null) {
            this.set(attr, value);
        }

        return this;
    }

    public Object getObj(String key) {
        return super.get(key);
    }

    public <T> T get(String attr, T defaultValue) {
        Object result = this.get(attr);
        return result != null ? (T) result : defaultValue;
    }

    public String getStr(String attr) {
        return Convert.toStr(this.get(attr), (String)null);
    }

    public Integer getInt(String attr) {
        return Convert.toInt(this.get(attr), -1);
    }

    public Long getLong(String attr) {
        return Convert.toLong(this.get(attr), -1L);
    }

    public Float getFloat(String attr) {
        return Convert.toFloat(this.get(attr), null);
    }

    public Double getDouble(String attr) {
        return Convert.toDouble(this.get(attr), (Double)null);
    }

    public Boolean getBool(String attr) {
        return Convert.toBool(this.get(attr), (Boolean)null);
    }

    public byte[] getBytes(String attr) {
        return (byte[])this.get(attr, (Object)null);
    }

    public Date getDate(String attr) {
        return (Date)this.get(attr, (Object)null);
    }

    public Time getTime(String attr) {
        return (Time)this.get(attr, (Object)null);
    }

    public Timestamp getTimestamp(String attr) {
        return (Timestamp)this.get(attr, (Object)null);
    }

    public Number getNumber(String attr) {
        return (Number)this.get(attr, (Object)null);
    }

    public Kv clone() {
        Kv clone = new Kv();
        clone.putAll(this);
        return clone;
    }
}

