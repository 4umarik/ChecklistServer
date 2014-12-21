package com.app.checklist.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Markiyan on 21.12.14.
 */
@Entity
public class CheckList {
    private Long id;

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
