package finalBorrador.dh.borradorB.service;

import finalBorrador.dh.borradorB.entities.Turno;
import finalBorrador.dh.borradorB.exceptions.BadRequestException;

import java.util.List;
import java.util.Optional;

public interface ITurnoServiceInterface {
    List<Turno> listarTurnos();
    Turno asignarTurno(Turno turno) throws BadRequestException;
    Optional<Turno> buscarTurnoXId(Long id);
    void eliminarTurno(Long id);
    Turno actualizarTurno(Turno turno);
}
