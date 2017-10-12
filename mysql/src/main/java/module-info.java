module com.mysql.jdbc.Driver {
    requires java.sql;
    requires slf4j.api;
    exports com.mysql.jdbc;
    provides java.sql.Driver with com.mysql.jdbc.Driver;
}