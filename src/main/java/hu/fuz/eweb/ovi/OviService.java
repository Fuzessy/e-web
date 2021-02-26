package hu.fuz.eweb.ovi;

import hu.fuz.eweb.entities.DolgozoDol;
import hu.fuz.eweb.entities.TanuloTan;
import hu.fuz.eweb.ovi.dao.CsoportRepository;
import hu.fuz.eweb.ovi.dao.CsoportTanuloRepositry;
import hu.fuz.eweb.ovi.dao.DolgozoRepository;
import hu.fuz.eweb.ovi.model.TanuloDTO;
import hu.fuz.eweb.ovi.dao.TanuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OviService {

    @Autowired
    private TanuloRepository tanuloRepository;

    public List<TanuloDTO> getTanulok(){
        List<TanuloDTO> tanulok = new ArrayList<>();
        for(TanuloTan tanulo: tanuloRepository.findAll()){
            TanuloDTO tanuloDTO = new TanuloDTO();
            tanuloDTO.tanuloId = tanulo.getTanId();
            tanuloDTO.tanuloNev = getTanuloNev(tanulo);
            tanuloDTO.csoportVezetoNev = getCsoportVezetoBev(tanulo);
            tanuloDTO.csoportNev = tanulo.getOviCsoportTanuloCstsByTanId().get(0).getOviCsoportOcsByCstCsoportId().getOcsCsoportNev();
            tanulok.add(tanuloDTO);
        }
        return tanulok;
    }

    private String getCsoportVezetoBev(TanuloTan tanulo) {
        DolgozoDol dolgozo = tanulo.getOviCsoportTanuloCstsByTanId().get(0).getOviCsoportOcsByCstCsoportId().getDolgozoDolByOcsVezetoDolId();
        return dolgozo.getDolCsaladiNev() + " " + dolgozo.getDolKeresztnev();
    }

    private String getTanuloNev(TanuloTan tanulo) {
        return tanulo.getTanCsaladiNev() + " " + tanulo.getTanKeresztnev();
    }
}
