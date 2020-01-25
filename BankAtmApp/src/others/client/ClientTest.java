package others.client;
import others.model.Account;
import others.worker.AccountHolder;

import java.sql.SQLException;

public class ClientTest {

    public static void main(String[] args) throws SQLException {
        //Tworze klientów
        Clients client1 = new Clients(1);
        Clients client2 = new Clients(2);

        //przekazania do konta, nazwy,id i stanu konta
        Account account = new Account(client1.userName, client1.userId, client1.balance);
        Account account2 = new Account(client2.userName, client2.userId, client2.balance);

        ScannerProvider sc1 = new ScannerProvider(account);
        ScannerProvider sc2 = new ScannerProvider(account2);


        //Stworzenie nowego obiektu typu AccountHolder, ktoremu przekazywany jest klient w parametrze
        AccountHolder accountHolder = new AccountHolder(account);
        AccountHolder accountHolder2 = new AccountHolder(account2);

        //Dodaje do watku t1 pierwsze i drugie konto
        Thread t1 = new Thread(accountHolder);
        Thread t2 = new Thread(accountHolder2);

        t1.setName(client1.userName);
        t2.setName(client2.userName);

        //Uruchomienie watkow poprzez metode start() -
        //Powoduje ona rozpoczecie wykonywania kodu z metody run();
        t1.start();
        t2.start();


    }
}
