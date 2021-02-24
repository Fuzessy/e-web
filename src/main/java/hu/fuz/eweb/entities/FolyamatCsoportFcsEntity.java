package hu.fuz.eweb.entities;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "FOLYAMAT_CSOPORT_FCS", schema = "PUBLIC", catalog = "TEST")
public class FolyamatCsoportFcsEntity {
    private long fcsId;
    private String fcsName;
    private List<FolyamatFoEntity> processes;

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

    @OneToMany
    @JoinColumn(name = "FCS_ID")
    public List<FolyamatFoEntity> getProcesses(){
        return processes;
    }

    public void setProcesses(List<FolyamatFoEntity> processes){
        this.processes = processes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FolyamatCsoportFcsEntity that = (FolyamatCsoportFcsEntity) o;
        return fcsId == that.fcsId &&
                Objects.equals(fcsName, that.fcsName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fcsId, fcsName);
    }

    @Override
    public String toString() {
        return "FolyamatCsoportFcsEntity{" +
                "fcsId=" + fcsId +
                ", fcsName='" + fcsName + '\'' +
                ", processes=" + processes +
                '}';
    }
}
