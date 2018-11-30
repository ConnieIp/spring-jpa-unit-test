package com.oocl.web.sampleWebApp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SingleEntity {
    @Id
    public Long id;
    public String name;

}
