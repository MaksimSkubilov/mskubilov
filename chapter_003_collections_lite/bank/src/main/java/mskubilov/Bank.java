package mskubilov;

import java.util.*;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 08.04.17
 */
public class Bank {
    /**
     * accountMap. User accounts opened in the Bank.
     */
    private Map<User, List<Account>> accountMap = new TreeMap<User, List<Account>>();
    /**
     * Random requisites.
     */
    private Random rn = new Random();
     /**
     * addUser - adding User in accountMap.
     * @param user - new User.
     * @throws Exception - exception of same user.
     */
    public void addUser(User user) throws Exception {
        if (!this.accountMap.containsKey(user)) {
            ArrayList<Account> accountsList = new ArrayList<Account>();
            accountsList.add(new Account(Math.abs((this.rn.nextLong()))));
            this.accountMap.put(user, accountsList);
        } else {
            throw new Exception("User is a client of the Bank already!");
        }
    }

    /**
     * deleteUser - deleting User from accountMap.
     * @param user - User to delete.
     * @throws Exception - exception of missing user.
     */
    public void deleteUser(User user) throws Exception {
        if (this.accountMap.containsKey(user)) {
            this.accountMap.remove(user);
        } else {
            throw new Exception("User is not found amongst Bank's clients!");
        }
    }

    /**
     * addAccountToUser. Adding a new account to User's accountList.
     * @param user - User.
     * @param account - new Account.
     * @throws Exception - exceptions of missing user and same account.
     */
    public void addAccountToUser(User user, Account account) throws Exception {
        if (this.accountMap.containsKey(user)) {
            if (!this.accountMap.get(user).contains(account)) {
                this.accountMap.get(user).add(account);
            } else {
                throw new Exception("This User already have same account!");
            }
        } else {
            throw new Exception("User is not found amongst Bank's clients!");
        }
    }

    /**
     * deleteAccountFromUser. Deleting one of Users Accounts.
     * @param user - User.
     * @param account - Account to delete.
     * @throws Exception - exception of missing user and missing account.
     */
    public void deleteAccountFromUser(User user, Account account) throws Exception {
        if (this.accountMap.containsKey(user)) {
            if (this.accountMap.get(user).contains(account)) {
                this.accountMap.get(user).remove(account);
            } else {
                throw new Exception("This User does not have such account!");
            }
        } else {
            throw new Exception("User is not found amongst Bank's clients!");
        }
    }

    /**
     * getUserAccounts.
     * @param user - User.
     * @return Users accounts.
     * @throws Exception - exception of missing user.
     */
    public List<Account> getUserAccounts(User user) throws Exception {
        if (this.accountMap.containsKey(user)) {
            return this.accountMap.get(user);
        } else {
            throw new Exception("User is not found amongst Bank's clients!");
        }
    }

    /**
     * transferMoney.
     * @param srcUser - from User.
     * @param srcAccount - from Users account.
     * @param dstUser - to User.
     * @param dstAccount - to Users account.
     * @param amount - money to transfer.
     * @throws Exception - exception of missing user or missing account.
     * @return boolean.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) throws Exception {
        boolean result = false;
        if (this.accountMap.containsKey(srcUser) && this.accountMap.containsKey(dstUser)) {
            if (this.accountMap.get(srcUser).contains(srcAccount) && this.accountMap.get(dstUser).contains(dstAccount)) {
                if (amount < 0) {
                    throw new Exception("Amount to transfer must be positive!");
                }
                double moneyAtSourceAccount = this.accountMap.get(srcUser).get(this.accountMap.get(srcUser).indexOf(srcAccount)).getValue();
                double moneyAtDstAccount =  this.accountMap.get(dstUser).get(this.accountMap.get(dstUser).indexOf(dstAccount)).getValue();
                if (!(moneyAtSourceAccount < amount)) {
                    this.accountMap.get(srcUser).get(this.accountMap.get(srcUser).indexOf(srcAccount)).setValue(moneyAtSourceAccount - amount);
                    this.accountMap.get(dstUser).get(this.accountMap.get(dstUser).indexOf(dstAccount)).setValue(moneyAtDstAccount + amount);
                    result = true;
                } else {
                    throw new Exception("Not enough money at source account!");
                }
            } else {
                throw new Exception("At least one User does not have such account!");
            }
        } else {
            throw new Exception("At least one User is not found amongst Bank's clients!");
        }
        return result;
    }

    // methods for testing this.
    /**
     * @return actual map of the bank.
     */
    public Map<User, List<Account>> getMap() {
        return this.accountMap;
    }


}
