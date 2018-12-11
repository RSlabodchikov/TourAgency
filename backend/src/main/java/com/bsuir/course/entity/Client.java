package com.bsuir.course.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@Table(name = "clients", schema = "hostel")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "address")
    private String address;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "account_id")
    private Account account;


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(address, client.address) &&
                Objects.equals(account, client.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, address, account);
    }
}
