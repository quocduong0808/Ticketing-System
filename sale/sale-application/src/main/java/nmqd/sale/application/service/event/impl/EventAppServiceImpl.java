package nmqd.sale.application.service.event.impl;

import lombok.extern.slf4j.Slf4j;
import nmqd.sale.application.service.event.EventAppService;
import nmqd.sale.domain.service.HiDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventAppServiceImpl implements EventAppService {

    @Autowired
    private HiDomainService hiDomainService;

    @Override
    public String sayHi() {
        log.info("Go to application");
        return hiDomainService.sayHi();
    }
}
