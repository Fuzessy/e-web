package hu.fuz.eweb.process.model;

import java.util.List;

public class ProcessStatusDTO {
    public long actualProcessId;
    public String actualStateDecription;
    public List<StateToItemDTO> transitionToItems;
}
