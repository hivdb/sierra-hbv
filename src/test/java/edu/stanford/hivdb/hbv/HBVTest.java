package edu.stanford.hivdb.hbv;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.stanford.hivdb.mutations.AAMutation;
import edu.stanford.hivdb.sequences.AlignedSequence;
import edu.stanford.hivdb.sequences.Aligner;
import edu.stanford.hivdb.sequences.Sequence;

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
		assertEquals(hbv.getMainAminoAcidPercents(hbv.getMainStrain()).get().size(), 2061);
	}

	@Test
	public void testGenotyping() {
		Aligner<HBV> hbvAligner = Aligner.getInstance(hbv);
		Sequence LQ512261 = Sequence.fromGenbank("LQ512261.1");
		AlignedSequence<HBV> alignedSeq = hbvAligner.align(LQ512261);
		assertEquals("D (1.94%)", alignedSeq.getGenotypeText());
		
		Sequence GU815634 = Sequence.fromGenbank("GU815634.1");
		alignedSeq = hbvAligner.align(GU815634);
		assertEquals("B (1.26%)", alignedSeq.getGenotypeText());
	}
	
	@Test
	public void testGetDefaultDrugResistAlgorithm() {
		assertEquals("StanfordHBV", hbv.getDefaultDrugResistAlgorithm().getFamily());
		assertEquals("0.2", hbv.getDefaultDrugResistAlgorithm().getVersion());
	}
}
