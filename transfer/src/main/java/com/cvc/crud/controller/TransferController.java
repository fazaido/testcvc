package com.cvc.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cvc.crud.exception.ResourceNotFoundException;
import com.cvc.crud.model.Transfer;
import com.cvc.crud.repository.TransferRepository;
import com.cvc.crud.utils.Engine;

@RestController
@RequestMapping("/api")
public class TransferController {

    private static final Logger logger = LogManager.getLogger(TransferController.class);

	@Autowired
	TransferRepository transferRepository;

	@GetMapping("/transfer")
	public List<Transfer> getAllTransfers() {
		return transferRepository.findAll();
	}

	@PostMapping("/transfer")
	public Transfer createTransfer(@Valid @RequestBody Transfer transf) {
		try {
			final Double calcRate = (new Engine()).calculateRate(transf);
			logger.info("calcRate: {}", calcRate);
			transf.setRate(calcRate);
		} catch (final Exception e) {
			logger.error(e);
			final ResourceNotFoundException re = new ResourceNotFoundException("Rate not exist", transf.getId());
			throw re;
		}
		
		return transferRepository.save(transf);
	}

	@GetMapping("/transfer/{id}")
	public Transfer getTransferById(@PathVariable(value = "id") Long transferId) {
		final String msgE = String.format("%s not found with %s : '%s'", "Transfer", "id", transferId);
		
		return transferRepository.findById(transferId)
				.orElseThrow(() -> new ResourceNotFoundException(msgE, transferId));
	}

	@DeleteMapping("/transfer/{id}")
	public ResponseEntity<?> deleteTransfer(@PathVariable(value = "id") Long transferId) {
		final String msgE = String.format("%s not found with %s : '%s'", "Transfer", "id", transferId);
		
		final Transfer transfer = transferRepository.findById(transferId)
				.orElseThrow(() -> new ResourceNotFoundException(msgE, transferId));
		
		transferRepository.delete(transfer);

		return ResponseEntity.ok().build();
	}
}
