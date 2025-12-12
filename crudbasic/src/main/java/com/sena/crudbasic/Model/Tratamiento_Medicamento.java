package com.sena.crudbasic.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "tratamiento_medicamento")
@IdClass(TratamientoMedicamentoId.class)
public class Tratamiento_Medicamento {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_tratamiento")
    private Tratamiento tratamiento;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_medicamento")
    private Medicamento medicamento;

    public Tratamiento_Medicamento() {
    }

    public Tratamiento_Medicamento(Tratamiento tratamiento, Medicamento medicamento) {
        this.tratamiento = tratamiento;
        this.medicamento = medicamento;
    }

    // Getters y Setters
    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
}
