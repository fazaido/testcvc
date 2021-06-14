package com.cvc.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cvc.crud.model.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
