package com.projectexecution;

import org.testng.annotations.Test;
import com.bussinesslibraries.VerifyPrimusBankFunctionality_TS01;

public class VerifyPrimusBankFunctionality_Test {
	
	@Test
	public void verifyBankerLogin_WithOutvalues_TC01() throws Exception {

		VerifyPrimusBankFunctionality_TS01.verifyLogin_WithoutValue_TC01();

	}
}
