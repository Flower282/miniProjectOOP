package org.example.bluemoon.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "information", schema = "schema_duong")
public class Information {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;

    @Column(name="Họ và tên")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "Vai trò")
    private Role role = Role.RESIDENT;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.id = user.getId();
    }

    public Information() {
    }

    public Information(Long id, User user, String name, Role role) {
        this.id = user.getId();
        this.user = user;
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
