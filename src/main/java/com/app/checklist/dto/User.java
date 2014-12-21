package com.app.checklist.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Markiyan on 21.12.14.
 */
@Entity
public class User {

    @Id
    private Long id;

    private String notificationName;

    private String notificationKey;

    @OneToMany(mappedBy = "owner")
    private List<Registration> registrationIds;

    @OneToMany
    private List<CheckList> checkLists;

    public User(String notificationName, String notificationKey, List<Registration> registrationIds) {
        this.notificationName = notificationName;
        this.notificationKey = notificationKey;
        this.registrationIds = registrationIds;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
