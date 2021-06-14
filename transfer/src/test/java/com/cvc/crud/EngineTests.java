package com.cvc.crud;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cvc.crud.model.Transfer;
import com.cvc.crud.utils.Engine;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EngineTests {

	private Engine engA;
	private Transfer transf;

	@Before
	public void setup() {
		engA = new Engine();
		transf = new Transfer();
	}

	@Test
	public void calculateRateA() throws Exception {
		transf.setValue(100.0);
		transf.setSchedulingDate(LocalDate.now());
		transf.setTransferDate(LocalDate.now());

		// 3 + 3
		assertEquals(6, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateA_2() throws Exception {
		transf.setValue(200.0);
		transf.setSchedulingDate(LocalDate.now());
		transf.setTransferDate(LocalDate.now());

		// 3 + 6
		assertEquals(9, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateB() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-09");
		final LocalDate sched = LocalDate.parse("2021-05-10");

		transf.setValue(100.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 12 * 1
		assertEquals(12, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateB_2() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-09");
		final LocalDate sched = LocalDate.parse("2021-05-10");

		transf.setValue(110.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 12 * 1
		assertEquals(12, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateB_3() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-09");
		final LocalDate sched = LocalDate.parse("2021-05-19");

		transf.setValue(120.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 12 * 10
		assertEquals(120, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_1_1() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-01");
		final LocalDate sched = LocalDate.parse("2021-05-12");

		transf.setValue(120.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 8% de 120
		assertEquals(9.6, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_1_2() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-01");
		final LocalDate sched = LocalDate.parse("2021-05-15");

		transf.setValue(120.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 8% de 120
		assertEquals(9.6, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_1_3() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-01");
		final LocalDate sched = LocalDate.parse("2021-05-21");

		transf.setValue(120.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 8% de 120
		assertEquals(9.6, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_2_1() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-04-20");
		final LocalDate sched = LocalDate.parse("2021-05-11");

		transf.setValue(100.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 6% de 100
		assertEquals(6.0, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_2_2() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-04-20");
		final LocalDate sched = LocalDate.parse("2021-05-15");

		transf.setValue(100.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 6% de 100
		assertEquals(6.0, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_2_3() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-04-20");
		final LocalDate sched = LocalDate.parse("2021-05-20");

		transf.setValue(100.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 6% de 100
		assertEquals(6.0, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_3_1() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-04-20");
		final LocalDate sched = LocalDate.parse("2021-05-21");

		transf.setValue(100.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 4% de 100
		assertEquals(4.0, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_3_2() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-20");
		final LocalDate sched = LocalDate.parse("2021-06-20");

		transf.setValue(100.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 4% de 100
		assertEquals(4.0, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_3_3() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-20");
		final LocalDate sched = LocalDate.parse("2021-06-25");

		transf.setValue(100.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 4% de 100
		assertEquals(4.0, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_3_4() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-20");
		final LocalDate sched = LocalDate.parse("2021-06-29");

		transf.setValue(100.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 4% de 100
		assertEquals(4.0, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_4() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-20");
		final LocalDate sched = LocalDate.parse("2021-06-30");

		transf.setValue(100001.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 2% de 100001
		assertEquals(2000.02, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_4_1() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-20");
		final LocalDate sched = LocalDate.parse("2021-07-01");

		transf.setValue(100001.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 2% de 100001
		assertEquals(2000.02, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateC_4_2() throws Exception {
		final LocalDate trans = LocalDate.parse("2021-05-20");
		final LocalDate sched = LocalDate.parse("2021-07-23");

		transf.setValue(200000.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		// 2% de 100001
		assertEquals(4000.0, engA.calculateRate(transf));
	}

	@Test
	public void calculateRateException() {
		final LocalDate trans = LocalDate.parse("2021-05-20");
		final LocalDate sched = LocalDate.parse("2021-06-30");

		transf.setValue(100000.0);
		transf.setSchedulingDate(sched);
		transf.setTransferDate(trans);

		try {
			engA.calculateRate(transf);
			assertFalse(Boolean.TRUE);
		} catch (final Exception e) {
			assertFalse(Boolean.FALSE);
		}
	}

}
