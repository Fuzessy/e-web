package hu.fuz.eweb.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PROCESS_PR", schema = "PUBLIC", catalog = "TEST")
public class ProcessPr {
    private long prId;
    private StateSt stateStByPrActualStId;

    @Id
    @Column(name = "PR_ID")
    public long getPrId() {
        return prId;
    }

    public void setPrId(long prId) {
        this.prId = prId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessPr processPr = (ProcessPr) o;
        return prId == processPr.prId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prId);
    }

    @ManyToOne
    @JoinColumn(name = "PR_ACTUAL_ST_ID", referencedColumnName = "ST_ID", nullable = false)
    public StateSt getStateStByPrActualStId() {
        return stateStByPrActualStId;
    }

    public void setStateStByPrActualStId(StateSt stateStByPrActualStId) {
        this.stateStByPrActualStId = stateStByPrActualStId;
    }
}
