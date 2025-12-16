package com.sena.crudbasic.model;

import java.io.Serializable;
import java.util.Objects;

public class TratamientoMedicamentoId implements Serializable {

    private int tratamiento;
    private int medicamento;

    public TratamientoMedicamentoId() {
    }

    public TratamientoMedicamentoId(int tratamiento, int medicamento) {
        this.tratamiento = tratamiento;
        this.medicamento = medicamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TratamientoMedicamentoId)) return false;
        TratamientoMedicamentoId that = (TratamientoMedicamentoId) o;
        return tratamiento == that.tratamiento && medicamento == that.medicamento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tratamiento, medicamento);
    }
}
