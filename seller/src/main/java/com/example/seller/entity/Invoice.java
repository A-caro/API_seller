package com.example.seller.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numberClient")
    private String numerClient;
    @Column(name = "fecha")
    private String fecha;

    /*
     Relacion bidireccional
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_client")
    private Client client;*/

}
