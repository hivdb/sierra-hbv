package edu.stanford.hivdb.ebv;

import edu.stanford.hivdb.drugresistance.algorithm.DrugResistanceAlgorithm;
import edu.stanford.hivdb.mutations.AminoAcidPercents;
import edu.stanford.hivdb.mutations.CodonPercents;
import edu.stanford.hivdb.viruses.Strain;
import edu.stanford.hivdb.viruses.Virus;
import edu.stanford.hivdb.viruses.DefaultVirus;
import edu.stanford.hivdb.viruses.VirusDataLoader;

public class SEV extends DefaultVirus<SEV> {

	private static final class SEVDataLoader extends VirusDataLoader<SEV> {

		public SEVDataLoader(SEV virus) {
			super(virus);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected String getGenePattern() {
			return "NP|VP(?:35|40|30|24)|GP|L";
		}

		@Override
		protected String getVirusName() {
			return "Sudan-EBV";
		}

		@Override
		protected String getMainStrainText() {
			return "SEV";
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
		Virus.registerInstance(new SEV());
	}
	
	public static SEV getInstance() {
		return Virus.getInstance(SEV.class);
	}

	
	protected VirusDataLoader<SEV> getVirusDataLoader() {
		return new SEVDataLoader(this);
	}


	@Override
	public AminoAcidPercents<SEV> getMainAminoAcidPercents(Strain<SEV> strain) {
		return AminoAcidPercents.newEmptyInstance();
	}


	@Override
	public CodonPercents<SEV> getMainCodonPercents(Strain<SEV> strain) {
		return CodonPercents.newEmptyInstance();
	}


	@Override
	public DrugResistanceAlgorithm<SEV> getDefaultDrugResistAlgorithm() {
		return null;
	}

}
