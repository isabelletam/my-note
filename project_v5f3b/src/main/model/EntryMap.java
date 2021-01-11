package model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntryMap implements Map<EntryType, model.Entry> {

    private Map<EntryType, model.Entry> entryMap;

    public EntryMap() {
        entryMap = new HashMap<>();
    }

    @Override
    public int size() {
        return entryMap.size();
    }

    @Override
    public boolean isEmpty() {
        return entryMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return entryMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return entryMap.containsValue(value);
    }

    @Override
    public model.Entry get(Object key) {
        return (model.Entry) entryMap.get(key);
    }

    @Override
    public model.Entry put(EntryType key, model.Entry value) {
        return entryMap.put(key, value);
    }

    @Override
    public model.Entry remove(Object key) {
        return entryMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends EntryType, ? extends model.Entry> m) {
        entryMap.putAll(m);
    }

    @Override
    public void clear() {
        entryMap.clear();
    }

    @Override
    public Set<EntryType> keySet() {
        return entryMap.keySet();
    }

    @Override
    public Collection<model.Entry> values() {
        return entryMap.values();
    }

    @Override
    public Set<Entry<EntryType, model.Entry>> entrySet() {
        return entryMap.entrySet();
    }

}
