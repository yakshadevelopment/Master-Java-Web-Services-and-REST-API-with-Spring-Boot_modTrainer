package yaksha.rest_ws.mod_trainer;

import static org.junit.Assert.*;

import org.junit.Test;


import static yaksha.rest_ws.mod_trainer.TestUtils.*
;public class ModTrainerApplicationTest {

	@Test
	public void testMain() throws Exception {
		yakshaAssert(currentTest(),(true?"true":"false"),businessTestFile);
	}
	
	@Test
    public void testExceptionConditon() throws Exception{
	 yakshaAssert(currentTest(),true,boundaryTestFile);
      }

	@Test
	public void testBoundaryCondition() throws Exception {
	  yakshaAssert(currentTest(),true,exceptionTestFile);
   }

}
