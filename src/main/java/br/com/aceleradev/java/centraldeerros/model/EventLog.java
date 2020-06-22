package br.com.aceleradev.java.centraldeerros.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class EventLog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Level level;

    @NotNull
    @NotBlank(message = "A origin não pode ser vazia")
    private String origin;

    @NotNull
    @NotBlank(message = "A descrição não pode ser vazia")
    private String description;

    @NotNull
    @NotBlank(message = "O log não de ser vazio")
    private String log;

    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createAt;

    @Positive
    private Long quantity;


}
