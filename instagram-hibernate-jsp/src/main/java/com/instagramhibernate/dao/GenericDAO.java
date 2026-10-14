package com.instagramhibernate.dao; // Declares the DAO package.
import java.util.List; // Imports list result support.
public interface GenericDAO<T> { // Defines common persistence operations as an interface.
    T findById(Long id); // Reads one entity by primary key.
    List<T> findAll(); // Reads all entities of this type.
    T save(T entity); // Inserts or updates an entity.
    void delete(Long id); // Deletes an entity by primary key.
} // Ends GenericDAO.
