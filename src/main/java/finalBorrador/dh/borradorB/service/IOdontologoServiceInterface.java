package finalBorrador.dh.borradorB.service;

import finalBorrador.dh.borradorB.entities.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoServiceInterface {
    List<Odontologo> listarOdontologos();
    Odontologo darDeAltaOdontologo(Odontologo odontologo);
    Optional<Odontologo> buscarOdontologoXId(Long id);
    void eliminarOdontologo(Long id);
    Odontologo actualizarOdontologo(Odontologo odontologo);
}
