package org.sergei.repository;

import org.sergei.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sergei on 11/12/15.
 */
@Service("dataRepository")
public class DataRepositoryImpl implements DataRepository<Data> {

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Override
    public void persist(Data object) {

        Object[] params = new Object[] { object.getId(), object.getDescription() };
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };

        jdbcOperations.update("INSERT INTO authout(\n" +
                "            data_id, data_description)\n" +
                "    VALUES (cast(? as UUID), ?);", params, types);
    }

    @Override
    public void delete(Data object) {
        jdbcOperations.update("DELETE FROM authout\n" +
                " WHERE data_id = '" + object.getId().toString() + "';");
    }

    @Override
    public Set<String> getRandomData() {
        Set<String> result = new HashSet<>();
        SqlRowSet rowSet = jdbcOperations.queryForRowSet("SELECT data_description FROM authout p ORDER BY RANDOM() LIMIT 50;");
        while (rowSet.next()) {
            result.add(rowSet.getString("data_description"));
        }
        return result;
    }
}
