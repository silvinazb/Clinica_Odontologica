package finalBorrador.dh.borradorB.controller;

import finalBorrador.dh.borradorB.entities.Odontologo;
import finalBorrador.dh.borradorB.exceptions.ResourceNotFoundException;
import finalBorrador.dh.borradorB.service.IOdontologoServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private IOdontologoServiceInterface odontologoService;

    private static final Logger logger=Logger.getLogger(Odontologo.class);


    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos(){
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }

    @PostMapping
    public ResponseEntity<Odontologo> darDeAltaOdontologo(@RequestBody Odontologo odontologo){

        return ResponseEntity.ok(odontologoService.darDeAltaOdontologo(odontologo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdongologoXId(@PathVariable Long id){
        Optional<Odontologo> odontologoBuscado=odontologoService.buscarOdontologoXId(id);
        if (odontologoBuscado.isPresent()){
            logger.info("El odontologo con id: " +id+ "ha sido encontrado");

            return ResponseEntity.ok(odontologoBuscado.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologoBuscado=odontologoService.buscarOdontologoXId(id);
        if (odontologoBuscado.isPresent()){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok("Se eliminó al odontólogo con id="+id+", de la base de datos");
        }else{
            throw new ResourceNotFoundException("No se pudo eliminar al odontólogo con id: "+
                    id+". El mismo no existe en la base de datos.");
        }
    }

    @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
        Optional<Odontologo> odontologoParaActualizar= odontologoService.buscarOdontologoXId(odontologo.getId());
        if (odontologoParaActualizar.isPresent()){
            return ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
