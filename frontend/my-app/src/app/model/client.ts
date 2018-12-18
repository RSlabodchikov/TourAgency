import {Account} from './account';

export class Client {
  id: number;
  name: string;
  surname: string;
  phoneNumber: string;
  account:Account;
  static cloneBaseClient(client:Client):Client{
    let clonedClient:Client=new Client();
    clonedClient.id=client.id;
    clonedClient.name=client.name;
    clonedClient.surname=client.surname;
    clonedClient.phoneNumber=client.phoneNumber;
    clonedClient.account=Account.cloneBaseAccount(client.account);
    return clonedClient;
  }

}
