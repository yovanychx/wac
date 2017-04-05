/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uesocc.casos.tpi.beans;

import java.util.List;

/**
 *
 * @author yovany
 */
public interface AbstractInterface<T> {

    public void create(T t);

    public void edit(T t);

    public void remove(T t);

    public T find(Object o);

    public List<T> findAll();

    public List<T> findRange(int desde, int hasta);

    public int count();
}
