package hu.fuz.eweb.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FOLYAMAT_FO", schema = "PUBLIC", catalog = "TEST2")
public class FolyamatFoEntity {
    private long foId;
    private String foKod;
    private long fcsId;
    private String foName;


    @Id
    @Column(name = "FO_ID")
    public long getFoId() {
        return foId;
    }

    public void setFoId(long foId) {
        this.foId = foId;
    }

    @Basic
    @Column(name = "FO_KOD")
    public String getFoKod() {
        return foKod;
    }

    public void setFoKod(String foKod) {
        this.foKod = foKod;
    }

    @Basic
    @Column(name = "FCS_ID")
    public long getFcsId() {
        return fcsId;
    }

    public void setFcsId(long fcsId) {
        this.fcsId = fcsId;
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
        FolyamatFoEntity that = (FolyamatFoEntity) o;
        return foId == that.foId &&
                fcsId == that.fcsId &&
                Objects.equals(foKod, that.foKod) &&
                Objects.equals(foName, that.foName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foId, foKod, fcsId, foName);
    }
}
