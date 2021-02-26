package hu.fuz.eweb.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "OVI_CSOPORT_OCS", schema = "PUBLIC", catalog = "TEST")
public class OviCsoportOcs {
    private long ocsId;
    private String ocsCsoportNev;
    private long ocsVezetoDolId;
    private DolgozoDol dolgozoDolByOcsVezetoDolId;
    private Collection<OviCsoportTanuloCst> oviCsoportTanuloCstsByOcsId;

    @Id
    @Column(name = "OCS_ID")
    public long getOcsId() {
        return ocsId;
    }

    public void setOcsId(long ocsId) {
        this.ocsId = ocsId;
    }

    @Basic
    @Column(name = "OCS_CSOPORT_NEV")
    public String getOcsCsoportNev() {
        return ocsCsoportNev;
    }

    public void setOcsCsoportNev(String ocsCsoportNev) {
        this.ocsCsoportNev = ocsCsoportNev;
    }

    @Basic
    @Column(name = "OCS_VEZETO_DOL_ID")
    public long getOcsVezetoDolId() {
        return ocsVezetoDolId;
    }

    public void setOcsVezetoDolId(long ocsVezetoDolId) {
        this.ocsVezetoDolId = ocsVezetoDolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OviCsoportOcs that = (OviCsoportOcs) o;
        return ocsId == that.ocsId &&
                ocsVezetoDolId == that.ocsVezetoDolId &&
                Objects.equals(ocsCsoportNev, that.ocsCsoportNev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ocsId, ocsCsoportNev, ocsVezetoDolId);
    }

    @ManyToOne
    @JoinColumn(name = "OCS_VEZETO_DOL_ID", referencedColumnName = "DOL_ID", nullable = false, updatable = false, insertable = false)
    public DolgozoDol getDolgozoDolByOcsVezetoDolId() {
        return dolgozoDolByOcsVezetoDolId;
    }

    public void setDolgozoDolByOcsVezetoDolId(DolgozoDol dolgozoDolByOcsVezetoDolId) {
        this.dolgozoDolByOcsVezetoDolId = dolgozoDolByOcsVezetoDolId;
    }

    @OneToMany(mappedBy = "oviCsoportOcsByCstCsoportId")
    public Collection<OviCsoportTanuloCst> getOviCsoportTanuloCstsByOcsId() {
        return oviCsoportTanuloCstsByOcsId;
    }

    public void setOviCsoportTanuloCstsByOcsId(Collection<OviCsoportTanuloCst> oviCsoportTanuloCstsByOcsId) {
        this.oviCsoportTanuloCstsByOcsId = oviCsoportTanuloCstsByOcsId;
    }
}
