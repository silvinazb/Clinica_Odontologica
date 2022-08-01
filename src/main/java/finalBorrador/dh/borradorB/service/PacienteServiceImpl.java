package finalBorrador.dh.borradorB.service;

import finalBorrador.dh.borradorB.entities.Paciente;
import finalBorrador.dh.borradorB.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteServiceInterface{

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente darDeAltaPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> buscarPacienteXId(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}
