export class Client {
  id: number;
  name: string;
  surname: string;
  mail: string;
  phoneNumber: string;
  static cloneBaseClient(client:Client):Client{
    let clonedClient:Client=new Client();
    clonedClient.id=client.id;
    clonedClient.name=client.name;
    clonedClient.surname=client.surname;
    clonedClient.mail=client.mail;
    clonedClient.phoneNumber=client.phoneNumber;
    return clonedClient;
  }

}
