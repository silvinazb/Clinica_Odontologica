package finalBorrador.dh.borradorB.service;

import finalBorrador.dh.borradorB.entities.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteServiceInterface {
    List<Paciente> listarPacientes();
    Paciente darDeAltaPaciente(Paciente paciente);
    Optional<Paciente> buscarPacienteXId(Long id);
    void eliminarPaciente(Long id);
    Paciente actualizarPaciente(Paciente paciente);
}
