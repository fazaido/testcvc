package com.cvc.crud.utils;

import java.time.temporal.ChronoUnit;

import com.cvc.crud.model.Transfer;

public class Engine {

	public Double calculateRate(final Transfer transfer) throws Exception {
		final Integer daysBetween = ((Long) ChronoUnit.DAYS.between(transfer.getTransferDate(),
				transfer.getSchedulingDate())).intValue();

		if (daysBetween == Constants._DAY_ZERO) {
			return Constants._FIX_A + (transfer.getValue() * Rates._PORCENTAGE_A);
		}

		if (daysBetween <= Constants._DAY_TEN) {
			return Constants._FIX_B * daysBetween.doubleValue();
		}

		if (daysBetween <= Constants._DAY_TWENTY) {
			return transfer.getValue() * Rates._PORCENTAGE_C_1;
		}

		if (daysBetween <= Constants._DAY_THIRTY) {
			return transfer.getValue() * Rates._PORCENTAGE_C_2;
		}

		if (daysBetween <= Constants._DAY_FORTY) {
			return transfer.getValue() * Rates._PORCENTAGE_C_3;
		}

		if (daysBetween > Constants._DAY_FORTY && transfer.getValue() > Constants._VALUE_C) {
			return transfer.getValue() * Rates._PORCENTAGE_C_4;
		}

		throw new Exception(Constants._EXCEPTION_RATE);
	}
}
