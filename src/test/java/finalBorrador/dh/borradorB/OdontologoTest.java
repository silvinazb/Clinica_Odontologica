package finalBorrador.dh.borradorB;

import finalBorrador.dh.borradorB.entities.Odontologo;
import finalBorrador.dh.borradorB.service.IOdontologoServiceInterface;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class OdontologoTest {

	@Autowired
	IOdontologoServiceInterface odontologoService;

	@Test
	@Order(1)
	public void agregarOdontologoTest(){
		Odontologo odontoUno= new Odontologo("Luz","Rodriguez",888);
		odontologoService.darDeAltaOdontologo(odontoUno);
		Optional<Odontologo> odontologoRecuperado=odontologoService.buscarOdontologoXId(1l);
		assertTrue(odontologoRecuperado.isPresent());
	}
	@Test
	@Order(2)
	public void buscarOdontologoTest(){
		Long idBuscado=1l;
		Optional<Odontologo> odontologoRecuperado=odontologoService.buscarOdontologoXId(idBuscado);
		assertTrue(odontologoRecuperado.isPresent());
	}
	@Test
	@Order(3)
	public void listarOdontologosTest(){
		List<Odontologo> listaDePrueba=odontologoService.listarOdontologos();
		assertTrue(listaDePrueba.size()>0);
	}
	@Test
	@Order(4)
	public void actualizarOdontologoTest(){
		Long idBuscado=1l;
		Odontologo odontoConNuevosDatos=
				new Odontologo(idBuscado,"Hernan","Videla",1010);
		odontologoService.actualizarOdontologo(odontoConNuevosDatos);
		Optional<Odontologo> odontoRecuperado=odontologoService.buscarOdontologoXId(idBuscado);
		assertEquals("Videla",odontoRecuperado.get().getApellido());
	}
}
