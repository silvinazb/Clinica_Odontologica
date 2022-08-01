package finalBorrador.dh.borradorB.service;

import finalBorrador.dh.borradorB.entities.Odontologo;
import finalBorrador.dh.borradorB.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements IOdontologoServiceInterface{

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Override
    public List<Odontologo> listarOdontologos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Odontologo darDeAltaOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> buscarOdontologoXId(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }
}
