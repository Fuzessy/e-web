package hu.fuz.eweb.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TRANSITION_TR", schema = "PUBLIC", catalog = "TEST")
public class TransitionTr {
    private long trId;
    private String stName;
    private StateSt stateStByStIdFrom;
    private StateSt stateStByStIdTo;
    private long stIdFrom;
    private long stIdTo;

    @Id
    @Column(name = "TR_ID")
    public long getTrId() {
        return trId;
    }

    public void setTrId(long trId) {
        this.trId = trId;
    }

    @Basic
    @Column(name = "ST_NAME")
    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransitionTr that = (TransitionTr) o;
        return trId == that.trId &&
                stIdFrom == that.stIdFrom &&
                stIdTo == that.stIdTo &&
                Objects.equals(stName, that.stName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trId, stIdFrom, stIdTo, stName);
    }

    @ManyToOne
    @JoinColumn(name = "ST_ID_FROM", referencedColumnName = "ST_ID", nullable = false, insertable = false, updatable = false)
    public StateSt getStateStByStIdFrom() {
        return stateStByStIdFrom;
    }

    public void setStateStByStIdFrom(StateSt stateStByStIdFrom) {
        this.stateStByStIdFrom = stateStByStIdFrom;
    }

    @ManyToOne
    @JoinColumn(name = "ST_ID_TO", referencedColumnName = "ST_ID", nullable = false, insertable = false, updatable = false)
    public StateSt getStateStByStIdTo() {
        return stateStByStIdTo;
    }

    public void setStateStByStIdTo(StateSt stateStByStIdTo) {
        this.stateStByStIdTo = stateStByStIdTo;
    }

    @Basic
    @Column(name = "ST_ID_FROM")
    public long getStIdFrom() {
        return stIdFrom;
    }

    public void setStIdFrom(long stIdFrom) {
        this.stIdFrom = stIdFrom;
    }

    @Basic
    @Column(name = "ST_ID_TO")
    public long getStIdTo() {
        return stIdTo;
    }

    public void setStIdTo(long stIdTo) {
        this.stIdTo = stIdTo;
    }
}
