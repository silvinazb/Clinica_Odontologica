package finalBorrador.dh.borradorB.controller;

import finalBorrador.dh.borradorB.entities.Odontologo;
import finalBorrador.dh.borradorB.entities.Paciente;
import finalBorrador.dh.borradorB.entities.Turno;
import finalBorrador.dh.borradorB.exceptions.BadRequestException;
import finalBorrador.dh.borradorB.exceptions.ResourceNotFoundException;
import finalBorrador.dh.borradorB.service.IOdontologoServiceInterface;
import finalBorrador.dh.borradorB.service.IPacienteServiceInterface;
import finalBorrador.dh.borradorB.service.ITurnoServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoServiceInterface turnoService;

    @Autowired
    private IPacienteServiceInterface pacienteService;

    @Autowired
    private IOdontologoServiceInterface odontologoService;

    private static final Logger logger=Logger.getLogger(Odontologo.class);


    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

    @PostMapping
    public ResponseEntity<Turno> asignarTurno(@RequestBody Turno turno) throws BadRequestException {
        //return ResponseEntity.ok(turnoService.asignarTurno(turno));
        // ResponseEntity<Turno> respuesta;
        Optional<Paciente> paciente = pacienteService.buscarPacienteXId(turno.getPaciente().getId());
        Optional <Odontologo> odontologo = odontologoService.buscarOdontologoXId(turno.getOdontologo().getId());

        if(paciente.isPresent() && odontologo.isPresent()){
            return ResponseEntity.ok(turnoService.asignarTurno(turno));
        } else{
            throw new BadRequestException("No se pudo asignar el turno, porque el odontologo " +
                    "o el paciente no existen en la base de datos ");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Long id){

        logger.info("EL turno con id: " +id+ "ha sido encontrado");

        Optional<Turno> turnoBuscado=turnoService.buscarTurnoXId(id);
        if (turnoBuscado.isPresent()){
            return ResponseEntity.ok(turnoBuscado.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Turno> turnoBuscado=turnoService.buscarTurnoXId(id);
        if (turnoBuscado.isPresent()){
            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Se eliminó el turno con id="+id+", de la base de datos");
        }else{
            throw new ResourceNotFoundException("No se pudo eliminar el turno con id: "+
                    id+". El mismo no existe en la base de datos.");
        }
    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno){
        Optional<Turno> turnoParaActualizar= turnoService.buscarTurnoXId(turno.getId());
        if (turnoParaActualizar.isPresent()){
            return ResponseEntity.ok(turnoService.actualizarTurno(turno));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> manejoBadRequestException(BadRequestException bre, WebRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Atención -> "+ bre.getMessage());
    }
}
