package edu.stanford.hivdb.hbv;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.stanford.hivdb.mutations.AAMutation;

public class HBVTest {

	public static HBV hbv = HBV.getInstance();
	
	@Test
	public void testUsualMutations() {
		AAMutation<HBV> I278V = new AAMutation<>(
			hbv.getGene("HBVRT"),
			278,
			'V'
		);
		assertFalse(I278V.isUnusual());
	}
	
	@Test
	public void testAminoAcidPercentsLoader() {
		assertEquals(hbv.getMainAminoAcidPercents(hbv.getMainStrain()).get().size(), 2051);
	}
}
