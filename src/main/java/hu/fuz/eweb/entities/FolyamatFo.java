package hu.fuz.eweb.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "FOLYAMAT_FO", schema = "PUBLIC", catalog = "TEST")
public class FolyamatFo {
    private long foId;
    private String foCode;
    private String foName;
    private FolyamatCsoportFcs folyamatCsoportFcsByFcsId;
    private Collection<StateSt> stateStsByFoId;
    private String fcsId;

    @Id
    @Column(name = "FO_ID")
    public long getFoId() {
        return foId;
    }

    public void setFoId(long foId) {
        this.foId = foId;
    }

    @Basic
    @Column(name = "FO_CODE")
    public String getFoCode() {
        return foCode;
    }

    public void setFoCode(String foCode) {
        this.foCode = foCode;
    }

    @Basic
    @Column(name = "FO_NAME")
    public String getFoName() {
        return foName;
    }

    public void setFoName(String foName) {
        this.foName = foName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FolyamatFo that = (FolyamatFo) o;
        return foId == that.foId &&
                Objects.equals(foCode, that.foCode) &&
                Objects.equals(foName, that.foName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foId, foCode, foName);
    }

    @ManyToOne
    @JoinColumn(name = "FCS_ID", referencedColumnName = "FCS_ID", nullable = false, insertable = false, updatable = false)
    public FolyamatCsoportFcs getFolyamatCsoportFcsByFcsId() {
        return folyamatCsoportFcsByFcsId;
    }

    public void setFolyamatCsoportFcsByFcsId(FolyamatCsoportFcs folyamatCsoportFcsByFcsId) {
        this.folyamatCsoportFcsByFcsId = folyamatCsoportFcsByFcsId;
    }

    @OneToMany(mappedBy = "folyamatFoByFoId")
    public Collection<StateSt> getStateStsByFoId() {
        return stateStsByFoId;
    }

    public void setStateStsByFoId(Collection<StateSt> stateStsByFoId) {
        this.stateStsByFoId = stateStsByFoId;
    }

    @Basic
    @Column(name = "FCS_ID")
    public String getFcsId() {
        return fcsId;
    }

    public void setFcsId(String fcsId) {
        this.fcsId = fcsId;
    }
}
