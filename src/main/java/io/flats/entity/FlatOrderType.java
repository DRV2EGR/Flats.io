package io.flats.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "flat_order_type")
@Data
public class FlatOrderType extends BaseEntity {
    @Column
    protected String name;
}
