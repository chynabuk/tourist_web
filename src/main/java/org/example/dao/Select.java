package org.example.dao;

import java.util.List;

public interface Select <G> {
    G getBy(Integer id);
    List<G> getAll();
}