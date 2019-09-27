package com.example.videos.model.appUser;

import com.example.videos.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "role", indexes = {
        @Index(columnList = "id", name = "role_id_index")
})
@SequenceGenerator(name = "SEQ_STORE", sequenceName = "role_id_seq", allocationSize = 1)
@Data
@NoArgsConstructor
public class Role extends BaseModel {

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private RoleEnum name;

    public Role(RoleEnum name) {
        this.name = name;
    }
}
