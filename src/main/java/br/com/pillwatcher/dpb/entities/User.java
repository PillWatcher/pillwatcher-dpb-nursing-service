package br.com.pillwatcher.dpb.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;

import static br.com.pillwatcher.dpb.constants.ValidationConstraints.*;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity(name = "USER")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @Column(name = "ID_USER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER")
    @SequenceGenerator(sequenceName = "SEQ_USER", allocationSize = 1, name = "SEQ_USER")
    private Long id;

    @CPF
    @Column(name = "DOCUMENT", nullable = false, unique = true)
    private String document;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Size(min = NAME_MIN_SIZE, max = NAME_MAX_SIZE, message = NAME_SIZE_MUST_BE_BETWEEN)
    @Column(name = "NAME", nullable = false)
    private String name;

}
