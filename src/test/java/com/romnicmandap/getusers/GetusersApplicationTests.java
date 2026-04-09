package com.romnicmandap.getusers;

import com.romnicmandap.getusers.enricheduser.EnrichedUserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GetusersApplicationTests {

	@Autowired
	private EnrichedUserController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
