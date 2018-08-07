package com.solicitacoes.seap.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "materialstatus")
public class MaterialStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmaterialstatus;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialStatus that = (MaterialStatus) o;
        return Objects.equals(idmaterialstatus, that.idmaterialstatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idmaterialstatus);
    }

    public Long getIdmaterialstatus() {

        return idmaterialstatus;
    }

    public void setIdmaterialstatus(Long idmaterialstatus) {
        this.idmaterialstatus = idmaterialstatus;
    }


}
