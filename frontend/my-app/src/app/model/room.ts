export class Room{
  id:number;
  number:number;
  price:number;
  numberOfClients:number;
  static cloneBaseRoom(room:Room):Room{
    let clonedRoom:Room = new Room();
    clonedRoom.id=room.id;
    clonedRoom.number=room.number;
    clonedRoom.price=room.price;
    clonedRoom.numberOfClients=room.numberOfClients;
    return clonedRoom;
  }
}
