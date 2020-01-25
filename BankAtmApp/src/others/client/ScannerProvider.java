package others.client;

import others.model.Account;

import java.util.Scanner;


public class ScannerProvider {
    Account account;
    int kwota;
    int liczbaRat;

    ScannerProvider(Account account ) {
        this.account=account;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj "+ account.userName+" podaj kwote do wypłaty, oraz liczbe rat: " + " [ obecny stan konta to: "+account.getBalance()+" ]");

        System.out.println("Kwota: ");
        this.kwota = scanner.nextInt();
        System.out.println("Libcza rat: ");
        this.liczbaRat= scanner.nextInt();

        //ustawienie kwoty do wypłaty
        account.setAmountToWithdraw(this.kwota, this.liczbaRat);

    }

}
