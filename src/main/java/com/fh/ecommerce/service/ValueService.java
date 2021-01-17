package com.fh.ecommerce.service;

import com.fh.ecommerce.model.Value;

import java.util.List;

public interface ValueService {

    List<Value> getData(Integer id);

    void add(Value value);

    void update(Value value);

    void delete(Integer id);
}
