export class Account {
  mail: string;
  password: string;

  static cloneBaseAccount(account: Account): Account {
    let clonedAccount: Account = new Account();
    clonedAccount.mail = account.mail;
    clonedAccount.password = account.password;
    return clonedAccount;
  }
}
