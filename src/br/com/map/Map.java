package br.com.map;

import java.util.LinkedList;

public class Map<K, V> {
    
    private LinkedList<LinkedList<Association<K, V>>> elements;
    private int categories = 16;

    public Map() {
        this.elements = new LinkedList<LinkedList<Association<K, V>>>();
        for (int i = 0; i < this.categories; i++) {
            this.elements.add(new LinkedList<Association<K, V>>());
        }
    }

    public void add(K key, V value) {
        if(contains(key)) {
            remove(key);
        }
        LinkedList<Association<K,V>> category = getCategory(key);
        category.add(new Association<K,V>(key, value));
    }

    public V getValue(K key) {
        LinkedList<Association<K,V>> category = getCategory(key);
        for (int i = 0; i < category.size(); i++) {
            Association<K,V> association = category.get(i);
            if(association.getKey().equals(key)) {
                return association.getValue();
            }
        }
        throw new IllegalArgumentException("Key not found!");
    }

    public boolean contains(K key) {
        LinkedList<Association<K,V>> list = getCategory(key);
        for (int i = 0; i < list.size(); i++) {
            Association<K,V> association = list.get(i);
            if(association.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void remove(K key) {
        LinkedList<Association<K,V>> list = getCategory(key);
        for (int i = 0; i < list.size(); i++) {
            Association<K,V> association = list.get(i);
            if(association.getKey().equals(key)) {
                list.remove(association);
                return;
            }
        }
        throw new IllegalArgumentException("Key not found!");
    }

    private LinkedList<Association<K, V>> getCategory(K key) {
        int hash = hashGenerator(key);
        return this.elements.get(hash);
    }

    private int hashGenerator(K key) {
        return Math.abs(key.hashCode() % this.categories);
    }

    @Override
    public String toString() {
        return "Map [elements=" + elements + "]";
    }

}
