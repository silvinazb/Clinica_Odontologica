package finalBorrador.dh.borradorB.service;

import finalBorrador.dh.borradorB.entities.Turno;
import finalBorrador.dh.borradorB.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements ITurnoServiceInterface{

    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public List<Turno> listarTurnos() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno asignarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Optional<Turno> buscarTurnoXId(Long id) {
        return turnoRepository.findById(id);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }
}
