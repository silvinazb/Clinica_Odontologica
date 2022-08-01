package finalBorrador.dh.borradorB.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @SequenceGenerator(name = "turno_sequence",sequenceName = "turno_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "turno_sequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "odontologo_id",nullable = false)
    private Odontologo odontologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id",nullable = false)
    private Paciente paciente;

    @Column
    private LocalDate fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
