package hu.fuz.eweb.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TANULO_TAN", schema = "PUBLIC", catalog = "TEST")
public class TanuloTan {
    private long tanId;
    private String tanCsaladiNev;
    private String tanKeresztnev;

    @Id
    @Column(name = "TAN_ID")
    public long getTanId() {
        return tanId;
    }

    public void setTanId(long tanId) {
        this.tanId = tanId;
    }

    @Basic
    @Column(name = "TAN_CSALADI_NEV")
    public String getTanCsaladiNev() {
        return tanCsaladiNev;
    }

    public void setTanCsaladiNev(String tanCsaladiNev) {
        this.tanCsaladiNev = tanCsaladiNev;
    }

    @Basic
    @Column(name = "TAN_KERESZTNEV")
    public String getTanKeresztnev() {
        return tanKeresztnev;
    }

    public void setTanKeresztnev(String tanKeresztnev) {
        this.tanKeresztnev = tanKeresztnev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TanuloTan tanuloTan = (TanuloTan) o;
        return tanId == tanuloTan.tanId &&
                Objects.equals(tanCsaladiNev, tanuloTan.tanCsaladiNev) &&
                Objects.equals(tanKeresztnev, tanuloTan.tanKeresztnev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tanId, tanCsaladiNev, tanKeresztnev);
    }
}
