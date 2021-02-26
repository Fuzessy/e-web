package hu.fuz.eweb.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DOLGOZO_DOL", schema = "PUBLIC", catalog = "TEST")
public class DolgozoDol {
    private long dolId;
    private String dolCsaladiNev;
    private String dolKeresztnev;
    private String dolBeosztas;
    private List<OviCsoportOcs> oviCsoportOcsByDolId;

    @Id
    @Column(name = "DOL_ID")
    public long getDolId() {
        return dolId;
    }

    public void setDolId(long dolId) {
        this.dolId = dolId;
    }

    @Basic
    @Column(name = "DOL_CSALADI_NEV")
    public String getDolCsaladiNev() {
        return dolCsaladiNev;
    }

    public void setDolCsaladiNev(String dolCsaladiNev) {
        this.dolCsaladiNev = dolCsaladiNev;
    }

    @Basic
    @Column(name = "DOL_KERESZTNEV")
    public String getDolKeresztnev() {
        return dolKeresztnev;
    }

    public void setDolKeresztnev(String dolKeresztnev) {
        this.dolKeresztnev = dolKeresztnev;
    }

    @Basic
    @Column(name = "DOL_BEOSZTAS")
    public String getDolBeosztas() {
        return dolBeosztas;
    }

    public void setDolBeosztas(String dolBeosztas) {
        this.dolBeosztas = dolBeosztas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DolgozoDol that = (DolgozoDol) o;
        return dolId == that.dolId &&
                Objects.equals(dolCsaladiNev, that.dolCsaladiNev) &&
                Objects.equals(dolKeresztnev, that.dolKeresztnev) &&
                Objects.equals(dolBeosztas, that.dolBeosztas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dolId, dolCsaladiNev, dolKeresztnev, dolBeosztas);
    }

    @OneToMany(mappedBy = "dolgozoDolByOcsVezetoDolId")
    public Collection<OviCsoportOcs> getOviCsoportOcsByDolId() {
        return oviCsoportOcsByDolId;
    }

    public void setOviCsoportOcsByDolId(List<OviCsoportOcs> oviCsoportOcsByDolId) {
        this.oviCsoportOcsByDolId = oviCsoportOcsByDolId;
    }
}
