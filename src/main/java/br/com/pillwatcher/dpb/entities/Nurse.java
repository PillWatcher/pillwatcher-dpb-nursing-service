package br.com.pillwatcher.dpb.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity(name = "NURSE")
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
public class Nurse extends Auditable{

    @Id
    @Column(name = "ID_NURSE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NURSE")
    @SequenceGenerator(sequenceName = "SEQ_USER", allocationSize = 1, name = "SEQ_NURSE")
    private Long id;

    @JoinColumn(name = "ID_USER")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private User user;

    @Email
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "COREN", nullable = false)
    private String coren;

    @Column(name = "FEDERATIVE_UNIT", nullable = false)
    private String federativeUnit;

    @Column(name = "BIOMETRY", nullable = false)
    private Boolean biometry;

    @Column(name = "PHONE", nullable = false)
    private String phone;

    @PrePersist
    public void prePersist() {
        this.biometry = Boolean.FALSE;
    }

}
