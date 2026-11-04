package com.barbershop.api.repository;

import com.barbershop.api.domain.entity.Agendamento;
import com.barbershop.api.domain.enums.StatusAgendamento;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    @Query("""
        SELECT a FROM Agendamento a
        WHERE a.barbeiro.id = :barbeiroId
        AND a.status NOT IN (:statusCancelado)
        AND a.dataHoraInicio < :fim
        AND a.dataHoraFim > :inicio
    """)
    List<Agendamento> findConflitosHorario(
        @Param("barbeiroId") Long barbeiroId,
        @Param("inicio") OffsetDateTime inicio,
        @Param("fim") OffsetDateTime fim,
        @Param("statusCancelado") StatusAgendamento statusCancelado
    );

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        SELECT a FROM Agendamento a
        WHERE a.barbeiro.id = :barbeiroId
        AND a.status NOT IN (:statusCancelado)
        AND a.dataHoraInicio < :fim
        AND a.dataHoraFim > :inicio
    """)
    List<Agendamento> findConflitosHorarioComLock(
        @Param("barbeiroId") Long barbeiroId,
        @Param("inicio") OffsetDateTime inicio,
        @Param("fim") OffsetDateTime fim,
        @Param("statusCancelado") StatusAgendamento statusCancelado
    );

    List<Agendamento> findByBarbeiroIdAndDataHoraInicioBetween(
        Long barbeiroId,
        OffsetDateTime inicio,
        OffsetDateTime fim
    );
}
