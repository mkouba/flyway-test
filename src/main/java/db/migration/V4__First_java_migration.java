package db.migration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import org.flywaydb.core.api.migration.jdbc.JdbcMigration;

/**
 *
 * @author Martin Kouba
 */
public class V4__First_java_migration implements JdbcMigration {

    public void migrate(Connection connection) throws Exception {

        PreparedStatement statement = connection
                .prepareStatement("insert into \"user\" (id,name,password_hash) values (?,?,?)");

        try {
            for (int i = 0; i < 100; i++) {
                statement.setInt(1, i);
                statement.setString(2, "user" + i);
                statement.setString(3, UUID.nameUUIDFromBytes((""+i).getBytes()).toString());
                statement.execute();
            }
        } finally {
            statement.close();
        }
    }

}
