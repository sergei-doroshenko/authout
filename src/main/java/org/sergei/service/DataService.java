package org.sergei.service;

import java.util.Set;

/**
 * Created by sergei on 11/12/15.
 */
public interface DataService {

    boolean persist(String problem);

    Set<String> getRandomData();

}
