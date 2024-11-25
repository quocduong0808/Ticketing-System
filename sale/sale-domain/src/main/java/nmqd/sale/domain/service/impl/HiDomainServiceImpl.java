package nmqd.sale.domain.service.impl;

import lombok.extern.slf4j.Slf4j;
import nmqd.sale.domain.repository.HiDomainRepository;
import nmqd.sale.domain.service.HiDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HiDomainServiceImpl implements HiDomainService {

    @Autowired
    private HiDomainRepository hiDomainRepository;

    @Override
    public String sayHi() {
        log.info("Go to domain");
        return hiDomainRepository.sayHi();
    }
}
