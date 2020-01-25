package others.client;

import connection.QueryExecutor;

import java.sql.ResultSet;

public class QuerySelect {
    public ResultSet getClientData(Integer klientId) {
        return QueryExecutor.executeSelect("Select * from klient WHERE idKlient =" + klientId);
    }
    public ResultSet getAccountData(Integer klientId) {
        return QueryExecutor.executeSelect("Select * from konto WHERE idKlient =" + klientId);
    }
}
