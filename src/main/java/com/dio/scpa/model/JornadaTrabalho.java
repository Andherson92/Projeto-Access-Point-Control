package com.dio.scpa.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter //anotação para get
@Setter //anotação para set
@AllArgsConstructor //anotação para contrutores com argumentos
@NoArgsConstructor //anotação para construtores sem argumentos
@EqualsAndHashCode //anotação para Equals e hashCode
@Builder // anotação facilita na chama de outras classes
@Entity
@Audited
public class JornadaTrabalho {
    @Id
    @GeneratedValue
    private long id;
    private String descricao;
}
