/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author janja
 */
public interface Repository <T>{
    List<T> getAll(T param, String cond) throws Exception; 
    List<T> getAll();
    void add(T param) throws Exception;
    void update(T param) throws Exception;
    void delete(T param) throws Exception;
}
