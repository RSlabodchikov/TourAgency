import {Role} from './role';

export class Account {
  id: number;
  mail: string;
  password: string;
  role: Role;

  static cloneBaseAccount(account: Account): Account {
    let clonedAccount: Account = new Account();
    clonedAccount.role = Role.cloneBaseRole(account.role);
    clonedAccount.id = account.id;
    clonedAccount.mail = account.mail;
    clonedAccount.password = account.password;
    return clonedAccount;
  }
}
