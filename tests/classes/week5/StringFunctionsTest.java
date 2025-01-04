package classes.week5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringFunctionsTest {

	@Test
	void testIsSimetric() {
		String[] sim = {"", "2", "121", "2332"};
		String[] not_sim = {"12", "2212", "1121", "112332"};
		for(int i=0;i<sim.length;i=i+1) {
			boolean b = StringFunctions.isSymmetric(sim[i]);
			if(b==false) {
				fail("ERR: "+sim[i]+" should be simetric");
			}
		}
		for(int i=0;i<not_sim.length;i=i+1) {
			boolean b = StringFunctions.isSymmetric(not_sim[i]);
			if(b==true) {
				fail("ERR: "+not_sim[i]+" should be simetric");
			}
		}
	
	}

	@Test
	void testReverse() {
		String[] str = {"12", "2212", "1121", "112332"};
		for(int i=0;i<str.length;i=i+1) {
			String r = StringFunctions.reverse(str[i]);
			String t = StringFunctions.reverse(r);
			if(!t.equals(str[i])) {
				fail("ERR: "+t+" should be equals to "+str[i]);
			}
		}
	}

}
