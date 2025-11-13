package org.kholoud.billingservice.repository;

import org.kholoud.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long>
{
}