package finalBorrador.dh.borradorB;

import finalBorrador.dh.borradorB.entities.Domicilio;
import finalBorrador.dh.borradorB.entities.Paciente;
import finalBorrador.dh.borradorB.service.IPacienteServiceInterface;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PacienteTest {

	@Autowired
	IPacienteServiceInterface pacienteService;

	@Test
	@Order(1)
	public void agregarPacienteTest(){
		Paciente pacienteUno= new Paciente("Ines", "Bartolomeo", 333, LocalDate.of(2022,6,20),
				new Domicilio("Avenida", 123, "Lanus", "Buenos Aires"));
		pacienteService.darDeAltaPaciente(pacienteUno);
		Optional<Paciente> pacienteRecuperado=pacienteService.buscarPacienteXId(1l);
		assertTrue(pacienteRecuperado.isPresent());
	}
    @Test
	@Order(2)
	public void buscarPacienteTest(){
		Long idBuscado=1l;
		Optional<Paciente>pacienteRecuperado=pacienteService.buscarPacienteXId(idBuscado);
		assertTrue(pacienteRecuperado.isPresent());
	}
	@Test
	@Order(3)
	public void listarPacientesTest(){
		List<Paciente> listaDePrueba=pacienteService.listarPacientes();
		assertTrue(listaDePrueba.size()>0);
	}
	@Test
	@Order(4)
	public void actualizarPacienteTest(){
		Long idBuscado=2l;
		Paciente pacienteConNuevosDatos=
				new Paciente("Ines", "Zara", 333, LocalDate.of(2022,6,20),
						new Domicilio("Avenida", 123, "Lanus", "Buenos Aires"));
		pacienteService.actualizarPaciente(pacienteConNuevosDatos);
		Optional<Paciente> pacienteRecuperado=pacienteService.buscarPacienteXId(idBuscado);
		assertEquals("Zara",pacienteRecuperado.get().getApellido());
	}
}
