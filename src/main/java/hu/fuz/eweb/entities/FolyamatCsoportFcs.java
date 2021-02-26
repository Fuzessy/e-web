package hu.fuz.eweb.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "FOLYAMAT_CSOPORT_FCS", schema = "PUBLIC", catalog = "TEST")
public class FolyamatCsoportFcs {
    private long fcsId;
    private String fcsName;
    private Collection<FolyamatFo> folyamatFosByFcsId;

    @Id
    @Column(name = "FCS_ID")
    public long getFcsId() {
        return fcsId;
    }

    public void setFcsId(long fcsId) {
        this.fcsId = fcsId;
    }

    @Basic
    @Column(name = "FCS_NAME")
    public String getFcsName() {
        return fcsName;
    }

    public void setFcsName(String fcsName) {
        this.fcsName = fcsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FolyamatCsoportFcs that = (FolyamatCsoportFcs) o;
        return fcsId == that.fcsId &&
                Objects.equals(fcsName, that.fcsName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fcsId, fcsName);
    }

    @OneToMany(mappedBy = "folyamatCsoportFcsByFcsId")
    public Collection<FolyamatFo> getFolyamatFosByFcsId() {
        return folyamatFosByFcsId;
    }

    public void setFolyamatFosByFcsId(Collection<FolyamatFo> folyamatFosByFcsId) {
        this.folyamatFosByFcsId = folyamatFosByFcsId;
    }
}
