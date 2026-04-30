package com.micro.user.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")

public class Users {
    @Id

    @Column(name = "ID")
    private String userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "about")
    private String about;

    @Transient   //Doesnot save in db
    private List<Rating> ratings = new ArrayList<>();


}
