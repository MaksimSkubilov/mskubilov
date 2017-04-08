package mskubilov;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 08.04.17
 */
public class TestBank {
    /**
     * Test of adding new User.
     */
    @Test
    public void whenAddNewUserThenThereIsAUserInTheMap() {
        Bank bank = new Bank();
        User user1 = new User("John Doe", 213231212);
        User user2 = new User("John Doe", 462833672);
        User user3 = new User("John Doe", 213231212);
        try {
            bank.addUser(user1);
            bank.addUser(user2);
            //bank.addUser(user3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertThat(bank.getMap().containsKey(user1), is(true));
        assertThat(bank.getMap().size(), is(2));
    }
    /**
     * Test of deleting User.
     */
    @Test
    public void whenDeleteUserThenItDelete() {
        Bank bank = new Bank();
        User user1 = new User("John Doe", 462833672);
        User user2 = new User("John Doe", 213231212);
        User user3 = new User("John Doe", 231231231);
        try {
            bank.addUser(user1);
            bank.addUser(user2);
            bank.deleteUser(user1);
            //bank.deleteUser(user3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertThat(bank.getMap().size(), is(1));
        assertThat(bank.getMap().containsKey(user1), is(false));
    }
    /**
     * Test of adding new Users Account.
     */
    @Test
    public void whenAddNewAccountToUserThenItAdds() {
        Bank bank = new Bank();
        User user1 = new User("John Doe", 462833672);
        User user2 = new User("John Doe", 213231212);
        try {
            bank.addUser(user1);
            bank.addUser(user2);
            Account account1 = new Account(213231212L);
            bank.addAccountToUser(user1, account1);
            Account account2 = new Account(bank.getMap().get(user2).get(0).getRequisites());
            //bank.addAccountToUser(user2, account2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertThat(bank.getMap().get(user1).get(1).getRequisites(), is(213231212L));
        assertThat(bank.getMap().get(user2).size(), is(1));
    }
    /**
     * Test of deleteing one of Users Account.
     */
    @Test
    public void whenDeleteUsersAccountThenItDelete() {
        Bank bank = new Bank();
        User user1 = new User("John Doe", 462833672);
        User user2 = new User("John Doe", 213231212);
        try {
            bank.addUser(user1);
            bank.addUser(user2);
            Account account1 = new Account(213231212L);
            bank.addAccountToUser(user1, account1);
            Account account2 = new Account(bank.getMap().get(user2).get(0).getRequisites());
            bank.deleteAccountFromUser(user2, account2);
            //bank.deleteAccountFromUser(user1, new Account(24312341412323L));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertThat(bank.getMap().get(user2).size(), is(0));
    }
    /**
     * Test of getting all Users Accounts.
     */
    @Test
    public void whenGetUsersAccountsThenItGets() {
        Bank bank = new Bank();
        User user1 = new User("John Doe", 462833672);
        User user2 = new User("John Doe", 213231212);
        List<Account> accountsList = new ArrayList<Account>();
        try {
            bank.addUser(user1);
            bank.addUser(user2);
            Account account = new Account(213231212L);
            bank.addAccountToUser(user2, account);
            accountsList = bank.getUserAccounts(user2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertThat(bank.getMap().get(user2), is(accountsList));
    }
    /**
     * Test of transfer money between Users Accounts.
     */
    @Test
    public void whenTransferMoneyThenItTransfer() {
        Bank bank = new Bank();
        User user1 = new User("John Doe", 462833672);
        User user2 = new User("John Doe", 213231212);
        List<Account> accountsList = new ArrayList<Account>();
        try {
            bank.addUser(user1);
            bank.addUser(user2);
            Account account1 = new Account(213231212L, 2356.60);
            bank.addAccountToUser(user1, account1);
            Account account2 = new Account(545542324L, 555.40);
            bank.addAccountToUser(user2, account2);
            bank.transferMoney(user1, bank.getUserAccounts(user1).get(1), user2, bank.getUserAccounts(user2).get(1), 1000);
            bank.transferMoney(user2, bank.getUserAccounts(user2).get(1), user1, bank.getUserAccounts(user1).get(1), 500);
            //bank.transferMoney(user1, bank.getUserAccounts(user1).get(1), user2, bank.getUserAccounts(user2).get(1), 3000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertThat(bank.getMap().get(user2).get(1).getValue(), is(1055.40));
        assertThat(bank.getMap().get(user1).get(1).getValue(), is(1856.60));
    }
}
