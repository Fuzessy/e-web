package hu.fuz.eweb.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "STATE_ST", schema = "PUBLIC", catalog = "TEST")
public class StateSt {
    private long stId;
    private long foId;
    private String stCode;
    private String stDescription;
    private FolyamatFo folyamatFoByFoId;
    private List<TransitionTr> transitionTrsByStId;
    private List<TransitionTr> transitionTrsByStId_0;

    @Id
    @Column(name = "ST_ID")
    public long getStId() {
        return stId;
    }

    public void setStId(long stId) {
        this.stId = stId;
    }

    @Basic
    @Column(name = "FO_ID")
    public long getFoId() {
        return foId;
    }

    public void setFoId(long foId) {
        this.foId = foId;
    }

    @Basic
    @Column(name = "ST_CODE")
    public String getStCode() {
        return stCode;
    }

    public void setStCode(String stCode) {
        this.stCode = stCode;
    }

    @Basic
    @Column(name = "ST_DESCRIPTION")
    public String getStDescription() {
        return stDescription;
    }

    public void setStDescription(String stDescription) {
        this.stDescription = stDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateSt stateSt = (StateSt) o;
        return stId == stateSt.stId &&
                foId == stateSt.foId &&
                Objects.equals(stCode, stateSt.stCode) &&
                Objects.equals(stDescription, stateSt.stDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stId, foId, stCode, stDescription);
    }

    @ManyToOne
    @JoinColumn(name = "FO_ID", referencedColumnName = "FO_ID", nullable = false, updatable = false, insertable = false)
    public FolyamatFo getFolyamatFoByFoId() {
        return folyamatFoByFoId;
    }

    public void setFolyamatFoByFoId(FolyamatFo folyamatFoByFoId) {
        this.folyamatFoByFoId = folyamatFoByFoId;
    }

    @OneToMany(mappedBy = "stateStByStIdFrom")
    public List<TransitionTr> getTransitionTrsByStId() {
        return transitionTrsByStId;
    }

    public void setTransitionTrsByStId(List<TransitionTr> transitionTrsByStId) {
        this.transitionTrsByStId = transitionTrsByStId;
    }

    @OneToMany(mappedBy = "stateStByStIdTo")
    public List<TransitionTr> getTransitionTrsByStId_0() {
        return transitionTrsByStId_0;
    }

    public void setTransitionTrsByStId_0(List<TransitionTr> transitionTrsByStId_0) {
        this.transitionTrsByStId_0 = transitionTrsByStId_0;
    }
}
