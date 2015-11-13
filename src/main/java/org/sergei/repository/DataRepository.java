package org.sergei.repository;

import org.sergei.entity.DomainObject;

import java.util.Set;

/**
 * Created by sergei on 11/12/15.
 */
public interface DataRepository<V extends DomainObject> {
    void persist(V object);

    void delete(V object);

    Set<String> getRandomData();
}
