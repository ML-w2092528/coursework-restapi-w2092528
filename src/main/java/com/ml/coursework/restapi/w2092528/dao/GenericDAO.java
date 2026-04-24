package com.ml.coursework.restapi.w2092528.dao;

import com.ml.coursework.restapi.w2092528.BaseModel;
import java.util.List;

public class GenericDAO<T extends BaseModel> {
    
    private final List<T> items;

    public GenericDAO(List<T> items) {
        this.items = items;
    }

    public List<T> getAll() {
        return items;
    }

    public T getById(String id) {
        for (T item : items) {
            if (id.equals(item.getId())) {
                return item;
            }
        }
        return null;
    }

    public void add(T item) {
        items.add(item);
    }

    public void update(T updatedItem) {
        for (int i = 0; i < items.size(); i++) {
            T item = items.get(i);
            if (item.getId() == updatedItem.getId()) {
                items.set(i, updatedItem);
                return;
            }
        }
    }

    public void delete(String id) {
        items.removeIf(item -> item.getId().equals(id));
    }
}
