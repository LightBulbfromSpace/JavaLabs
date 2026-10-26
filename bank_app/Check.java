    public static void main(String[] args) throws Exception { ;
        java.lang.reflect.Method printMenu = mainClass.getDeclaredMethod(printMenu, com.example.bank_app.BankAccount.class); ;
        printMenu.setAccessible(true); ;
        com.example.bank_app.BankAccount[] accounts = com.example.bank_app.TestData.getAccounts(); ;
        System.out.println(ACCOUNT_COUNT= + accounts.length); ;
        printMenu.invoke(null, (com.example.bank_app.BankAccount) null); ;
        printMenu.invoke(null, accounts[1]); ;
    } ;
