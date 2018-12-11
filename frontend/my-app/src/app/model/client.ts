import {Account} from './account';

export class Client {
  id: number;
  name: string;
  surname: string;
  address: string;
  account: Account;
  static cloneBaseClient(client:Client):Client{
    let clonedClient:Client=new Client();
    clonedClient.account=Account.cloneBaseAccount(client.account);
    clonedClient.id=client.id;
    clonedClient.name=client.name;
    clonedClient.surname=client.surname;
    clonedClient.address=client.address;
    return clonedClient;
  }

}
