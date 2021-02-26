package hu.fuz.eweb.process;

import hu.fuz.eweb.entities.FolyamatCsoportFcs;
import hu.fuz.eweb.entities.FolyamatFo;
import hu.fuz.eweb.process.dao.ProcessRepository;
import hu.fuz.eweb.process.model.ProcessDTO;
import hu.fuz.eweb.process.model.Submenu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessService {

    private ProcessRepository processRepository;

    public ProcessService(ProcessRepository processRepository){
        this.processRepository = processRepository;
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
}
