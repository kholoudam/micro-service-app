package org.kholoud.billingservice.repository;

import org.kholoud.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository  extends JpaRepository<Bill, Long>
{
}