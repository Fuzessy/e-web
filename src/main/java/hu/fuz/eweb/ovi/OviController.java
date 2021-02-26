package hu.fuz.eweb.ovi;

import hu.fuz.eweb.ovi.model.TanuloDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ovi")
public class OviController {

    private final OviService oviService;

    public OviController(OviService oviService){
        this.oviService = oviService;
    }

    @GetMapping("/tanulok")
    public List<TanuloDTO> getTanulok(){
        return oviService.getTanulok();
    }
}
