import {Room} from './room';
import {Client} from './client';

export class Booking{
  id:number;
  settlementDate:string;
  evictionDate:string;
  totalPrice:number;
  room:Room;
  client:Client;
  static cloneBaseBooking(booking:Booking):Booking{
    let clonedBooking=new Booking();
    clonedBooking.room=Room.cloneBaseRoom(booking.room);
    clonedBooking.client=Client.cloneBaseClient(booking.client);
    clonedBooking.id=booking.id;
    clonedBooking.settlementDate=booking.settlementDate;
    clonedBooking.evictionDate=booking.evictionDate;
    clonedBooking.totalPrice=booking.totalPrice;
    return clonedBooking;
  }
}
