package com.bsuir.course.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "bookings", schema = "hostel")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "settlement_date")
    private Date settlementDate;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id &&
                Objects.equals(settlementDate, booking.settlementDate) &&
                Objects.equals(room, booking.room) &&
                Objects.equals(client, booking.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, settlementDate, room, client);
    }
}
