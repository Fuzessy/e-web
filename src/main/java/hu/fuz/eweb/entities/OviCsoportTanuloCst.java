package hu.fuz.eweb.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OVI_CSOPORT_TANULO_CST", schema = "PUBLIC", catalog = "TEST")
public class OviCsoportTanuloCst {
    private long cstId;
    private long cstCsoportId;
    private long cstTanuoId;

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
}
