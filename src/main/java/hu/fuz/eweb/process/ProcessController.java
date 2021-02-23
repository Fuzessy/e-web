package hu.fuz.eweb.process;

import hu.fuz.eweb.process.model.ProcessDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProcessController {

    private final ProcessService processService;

    public ProcessController(ProcessService processService){
        this.processService = processService;
    }

    @GetMapping
    public List<ProcessDTO> getProcess(){
        return processService.getProcesses();
    }
}
