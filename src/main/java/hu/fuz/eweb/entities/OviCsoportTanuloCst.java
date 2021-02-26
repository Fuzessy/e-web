package hu.fuz.eweb.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OVI_CSOPORT_TANULO_CST", schema = "PUBLIC", catalog = "TEST")
public class OviCsoportTanuloCst {
    private long cstId;
    private long cstCsoportId;
    private long cstTanuoId;
    private OviCsoportOcs oviCsoportOcsByCstCsoportId;
    private TanuloTan tanuloTanByCstTanuoId;

    @Id
    @Column(name = "CST_ID")
    public long getCstId() {
        return cstId;
    }

    public void setCstId(long cstId) {
        this.cstId = cstId;
    }

    @Basic
    @Column(name = "CST_CSOPORT_ID")
    public long getCstCsoportId() {
        return cstCsoportId;
    }

    public void setCstCsoportId(long cstCsoportId) {
        this.cstCsoportId = cstCsoportId;
    }

    @Basic
    @Column(name = "CST_TANUO_ID")
    public long getCstTanuoId() {
        return cstTanuoId;
    }

    public void setCstTanuoId(long cstTanuoId) {
        this.cstTanuoId = cstTanuoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OviCsoportTanuloCst that = (OviCsoportTanuloCst) o;
        return cstId == that.cstId &&
                cstCsoportId == that.cstCsoportId &&
                cstTanuoId == that.cstTanuoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cstId, cstCsoportId, cstTanuoId);
    }

    @ManyToOne
    @JoinColumn(name = "CST_CSOPORT_ID", referencedColumnName = "OCS_ID", nullable = false, updatable = false, insertable = false)
    public OviCsoportOcs getOviCsoportOcsByCstCsoportId() {
        return oviCsoportOcsByCstCsoportId;
    }

    public void setOviCsoportOcsByCstCsoportId(OviCsoportOcs oviCsoportOcsByCstCsoportId) {
        this.oviCsoportOcsByCstCsoportId = oviCsoportOcsByCstCsoportId;
    }

    @ManyToOne
    @JoinColumn(name = "CST_TANUO_ID", referencedColumnName = "TAN_ID", nullable = false, updatable = false, insertable = false)
    public TanuloTan getTanuloTanByCstTanuoId() {
        return tanuloTanByCstTanuoId;
    }

    public void setTanuloTanByCstTanuoId(TanuloTan tanuloTanByCstTanuoId) {
        this.tanuloTanByCstTanuoId = tanuloTanByCstTanuoId;
    }
}
