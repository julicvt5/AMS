package com.perenco.repository.tblogin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tblogin")
@ToString
public class TbLoginEntity implements Serializable {

    @Id
    @Column(name = "id_tblogin")
    private String idTbLogin;

    private String email;

    private Date fecha;
}
