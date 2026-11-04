package com.barbershop.api.domain.entity;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "disponibilidades")
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barbeiro_id", nullable = false)
    private Usuario barbeiro;

    @Column(name = "dia_semana", nullable = false)
    private Integer diaSemana; // 1 = Segunda, 7 = Domingo

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fim", nullable = false)
    private LocalTime horaFim;

    @Column(name = "hora_inicio_almoco")
    private LocalTime horaInicioAlmoco;

    @Column(name = "hora_fim_almoco")
    private LocalTime horaFimAlmoco;

    public Disponibilidade() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getBarbeiro() { return barbeiro; }
    public void setBarbeiro(Usuario barbeiro) { this.barbeiro = barbeiro; }

    public Integer getDiaSemana() { return diaSemana; }
    public void setDiaSemana(Integer diaSemana) { this.diaSemana = diaSemana; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFim() { return horaFim; }
    public void setHoraFim(LocalTime horaFim) { this.horaFim = horaFim; }

    public LocalTime getHoraInicioAlmoco() { return horaInicioAlmoco; }
    public void setHoraInicioAlmoco(LocalTime horaInicioAlmoco) { this.horaInicioAlmoco = horaInicioAlmoco; }

    public LocalTime getHoraFimAlmoco() { return horaFimAlmoco; }
    public void setHoraFimAlmoco(LocalTime horaFimAlmoco) { this.horaFimAlmoco = horaFimAlmoco; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disponibilidade that = (Disponibilidade) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
