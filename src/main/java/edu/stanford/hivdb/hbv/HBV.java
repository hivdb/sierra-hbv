package edu.stanford.hivdb.hbv;

import edu.stanford.hivdb.drugresistance.algorithm.DrugResistanceAlgorithm;
import edu.stanford.hivdb.mutations.AminoAcidPercents;
import edu.stanford.hivdb.mutations.CodonPercents;
import edu.stanford.hivdb.viruses.Strain;
import edu.stanford.hivdb.viruses.Virus;
import edu.stanford.hivdb.viruses.DefaultVirus;
import edu.stanford.hivdb.viruses.VirusDataLoader;

public class HBV extends DefaultVirus<HBV> {

	private static final class HBVDataLoader extends VirusDataLoader<HBV> {

		public HBVDataLoader(HBV virus) {
			super(virus);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected String getGenePattern() {
			return "P|RT|S|X|C";
		}

		@Override
		protected String getVirusName() {
			return "Hepatitis B";
		}

		@Override
		protected String getMainStrainText() {
			return "HBV";
		}

		@Override
		protected String getStrainsResPath() {
			return "strains.json";
		}

		@Override
		protected String getGenesResPath() {
			return "genes.json";
		}

		@Override
		protected String getDrugClassesResPath() {
			return null;
		}

		@Override
		protected String getDrugsResPath() {
			return null;
		}

		@Override
		protected String getDRMsResPath() {
			return null;
		}

		@Override
		protected String getSDRMsResPath() {
			return null;
		}

		@Override
		protected String getTSMsResPath() {
			return null;
		}

		@Override
		protected String getApobecsResPath() {
			return null;
		}

		@Override
		protected String getApobecDRMsResPath() {
			return null;
		}

		@Override
		protected String getAAPcntsResPath() {
			return null;
		}

		@Override
		protected String getCodonPcntsResPath() {
			return null;
		}

		@Override
		protected String getMutTypesResPath() {
			return "mutation-types.json";
		}

		@Override
		protected String getMutTypePairsResPath() {
			return null;
		}

		@Override
		protected String getMainSubtypesResPath() {
			return null;
		}

		@Override
		protected String getGenotypeReferencesResPath() {
			return null;
		}

		@Override
		protected String getGenotypesRespath() {
			return null;
		}

		@Override
		protected String getAlgorithmsIndexPath() {
			return null;
		}

		@Override
		protected String getAlgorithmsResPath() {
			return null;
		}

		@Override
		protected String getCondCommentsResPath() {
			return null;
		}

		@Override
		protected String getAlignConfigResPath() {
			return "alignment-config.json";
		}

		@Override
		protected String getAssemblyConfigResPath() {
			return "assembly-config.json";
		}
		
	}
	
	static {
		Virus.registerInstance(new HBV());
	}
	
	public static HBV getInstance() {
		return Virus.getInstance(HBV.class);
	}

	
	protected VirusDataLoader<HBV> getVirusDataLoader() {
		return new HBVDataLoader(this);
	}


	@Override
	public AminoAcidPercents<HBV> getMainAminoAcidPercents(Strain<HBV> strain) {
		return AminoAcidPercents.newEmptyInstance();
	}


	@Override
	public CodonPercents<HBV> getMainCodonPercents(Strain<HBV> strain) {
		return CodonPercents.newEmptyInstance();
	}


	@Override
	public DrugResistanceAlgorithm<HBV> getDefaultDrugResistAlgorithm() {
		return null;
	}

}
