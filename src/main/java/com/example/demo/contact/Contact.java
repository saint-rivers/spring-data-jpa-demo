package com.example.demo.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    private String telephone;
    private String address;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
