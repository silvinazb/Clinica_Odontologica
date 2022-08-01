package finalBorrador.dh.borradorB.controller;

import finalBorrador.dh.borradorB.entities.Odontologo;
import finalBorrador.dh.borradorB.entities.Paciente;
import finalBorrador.dh.borradorB.exceptions.ResourceNotFoundException;
import finalBorrador.dh.borradorB.service.IPacienteServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private IPacienteServiceInterface pacienteService;

    private static final Logger logger=Logger.getLogger(Odontologo.class);


    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(){
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }

    @PostMapping
    public ResponseEntity<Paciente> darDeAltaPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.darDeAltaPaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id){
        logger.info("El paciente con id: " +id+ "ha sido encontrado");

        Optional<Paciente> pacienteBuscado=pacienteService.buscarPacienteXId(id);
        if (pacienteBuscado.isPresent()){
            return ResponseEntity.ok(pacienteBuscado.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteBuscado=pacienteService.buscarPacienteXId(id);
        if (pacienteBuscado.isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Se eliminó al paciente con id="+id+", de la base de datos");
        }else{
            throw new ResourceNotFoundException("No se pudo eliminar al paciente con id: "+
                    id+". El mismo no existe en la base de datos.");
        }
    }

    @PutMapping
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente){
        Optional<Paciente> pacienteParaActualizar= pacienteService.buscarPacienteXId(paciente.getId());
        if (pacienteParaActualizar.isPresent()){
            return ResponseEntity.ok(pacienteService.actualizarPaciente(paciente));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
