package Menus;

import Account_package.Account;
import Model.Collection;

public class Buffer {
    private static Account bufferAccount;
    private static Collection bufferCollection;

    public static Account getBufferAccount() {
        return bufferAccount;
    }

    public static void setBufferAccount(Account bufferAccount) {
        Buffer.bufferAccount = bufferAccount;
    }

    public static Collection getBufferCollection() {
        return bufferCollection;
    }

    public static void setBufferCollection(Collection bufferCollection) {
        Buffer.bufferCollection = bufferCollection;
    }
}
