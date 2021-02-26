package hu.fuz;

import hu.fuz.eweb.EWebStarter;
import hu.fuz.eweb.process.dao.ProcessRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("local")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EWebStarter.class)
public class SpringTest {

    @Autowired
    private ProcessRepository processRepository;

    @Test
    @Transactional
    public void test(){
//        System.out.println(processRepository.getProcesses());
        System.out.println(processRepository.getOne(1L));
        System.out.println(processRepository.getOne(2L));
        System.out.println(processRepository.getOne(2L).getFolyamatFosByFcsId());
        //System.out.println(processRepository.getProcesses().get(0).getProcesses());
    }
}
