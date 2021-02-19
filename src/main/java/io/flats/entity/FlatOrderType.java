package io.flats.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "flat-order-type")
@Data
public class FlatOrderType extends BaseEntity {
    @Column
    private String name;
}
