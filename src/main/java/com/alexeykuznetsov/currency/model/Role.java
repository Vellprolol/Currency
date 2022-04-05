package com.alexeykuznetsov.currency.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true)
    private UserRoleEnum name;
//    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
//    private List<User> userList;

    public Role() {
    }

    public Role(UserRoleEnum name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRoleEnum getName() {
        return name;
    }

    public void setName(UserRoleEnum roleName) {
        this.name = roleName;
    }
//
//    public List<User> getUserList() {
//        return userList;
//    }
//
//    public void setUserList(List<User> userList) {
//        this.userList = userList;
//    }
}
