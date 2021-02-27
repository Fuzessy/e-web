package hu.fuz.eweb.process;

import hu.fuz.eweb.entities.FolyamatCsoportFcs;
import hu.fuz.eweb.entities.FolyamatFo;
import hu.fuz.eweb.entities.ProcessPr;
import hu.fuz.eweb.entities.TransitionTr;
import hu.fuz.eweb.process.dao.ActualProcessRepository;
import hu.fuz.eweb.process.dao.ProcessRepository;
import hu.fuz.eweb.process.model.ProcessDTO;
import hu.fuz.eweb.process.model.ProcessStatusDTO;
import hu.fuz.eweb.process.model.StateToItemDTO;
import hu.fuz.eweb.process.model.Submenu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessService {

    private ProcessRepository processRepository;
    private ActualProcessRepository actualProcessRepository;

    public ProcessService(ProcessRepository processRepository, ActualProcessRepository actualProcessRepository) {
        this.processRepository = processRepository;
        this.actualProcessRepository = actualProcessRepository;
    }

    public List<ProcessDTO> getProcesses() {
        List<FolyamatCsoportFcs> processes = processRepository.findAll();
        List<ProcessDTO> processDTOS = new ArrayList<>();
        for(FolyamatCsoportFcs folyamatCsoport : processes){
            ProcessDTO model = new ProcessDTO();
            model.id = folyamatCsoport.getFcsId();
            model.label = folyamatCsoport.getFcsName();
            model.submenu = new ArrayList<>();
            for(FolyamatFo folyamat : folyamatCsoport.getFolyamatFosByFcsId()){
                Submenu submenu = new Submenu();
                submenu.id = folyamat.getFoId();
                submenu.label = folyamat.getFoName();
                submenu.processCode = folyamat.getFoCode();
                model.submenu.add(submenu);
            }
            processDTOS.add(model);
        }
        return processDTOS;
    }

    public ProcessStatusDTO getProcessTatusByProcessId(long processId) {
        ProcessPr actualProcess = actualProcessRepository.getOne(processId);

        ProcessStatusDTO processStatusDTO = new ProcessStatusDTO();
        processStatusDTO.actualProcessId = actualProcess.getPrId();
        processStatusDTO.actualStateDecription = actualProcess.getStateStByPrActualStId().getStDescription();
        List<TransitionTr> transitionToItems = actualProcess.getStateStByPrActualStId().getTransitionTrsByStId();
        processStatusDTO.transitionToItems = getTransitionToItems(transitionToItems);
        return processStatusDTO;
    }

    private List<StateToItemDTO> getTransitionToItems(List<TransitionTr> transitionToItems) {
        List<StateToItemDTO> stateToItemDTOS = new ArrayList<>();
        for(TransitionTr transitions : transitionToItems){
            StateToItemDTO stateToItemDTO = new StateToItemDTO();
            stateToItemDTO.nextStateId = transitions.getStateStByStIdTo().getStId();
            stateToItemDTO.nextStateCode = transitions.getStateStByStIdTo().getStCode();
            stateToItemDTO.nextStateName = transitions.getStateStByStIdTo().getStDescription();
            stateToItemDTO.transitionName = transitions.getStName();
            stateToItemDTOS.add(stateToItemDTO);
        }
        return stateToItemDTOS;
    }
}
