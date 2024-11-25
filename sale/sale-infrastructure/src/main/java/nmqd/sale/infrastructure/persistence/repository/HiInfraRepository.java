package nmqd.sale.infrastructure.persistence.repository;

import lombok.extern.slf4j.Slf4j;
import nmqd.sale.domain.repository.HiDomainRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class HiInfraRepository implements HiDomainRepository {

    @Override
    public String sayHi() {
        log.info("Go to infrastructure");
        return "Hi InfraStructure using Docker !!!";
    }
}
