package io.aets.WaterTaxationBackend.repository;

import io.aets.WaterTaxationBackend.model.Bill;
import io.aets.WaterTaxationBackend.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Transactional
    void deleteBillById(Long id);

    Optional<Bill> findBillById(Long id);

    List<Bill> findBySubscriberId(Long subscriberId);
}
