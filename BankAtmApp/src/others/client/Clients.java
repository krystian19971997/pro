package others.client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Clients {
    Integer idKlienta;
    Integer userId;
    String userName;
    Float balance;

    public Clients(Integer idKlienta) throws SQLException {
        QuerySelect query = new QuerySelect();
        this.idKlienta = idKlienta;
        ResultSet resultClient = query.getClientData(this.idKlienta);
        resultClient.first();
        this.userId = resultClient.getInt("idKlient");
        this.userName = resultClient.getString("imie");
        //wynik zapytania dla konta
        ResultSet resultServer = query.getAccountData(this.idKlienta);
        resultServer.first();
        this.balance = resultServer.getFloat("stanKonta");
    }


}
