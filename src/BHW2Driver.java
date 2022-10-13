import java.util.ArrayList;

public class BHW2Driver {

	public static void main(String[] args) 
	{
		int years = 0;
		long initDisciples = 13L;
		long disciples = initDisciples;
		long pop = 7700000000L;
		//assuming the entirety of the population is at least 18
		//it would be hard to calculate w/o hard numbers for all ages
		ArrayList<Generation> GenerationList = new ArrayList<Generation>();
		
		int ageCounterForAdult = 18;
		int ageCounterForKid = 18;
		int ageCounterForDeath = 18;
		int ageCounterForTraining = 0;
		
		int generationNumber = 1;
		long generationSizeNum = pop;
		int generationDeadNum = 0;
		//disciples can train 2 disciples every 3 years
		Generation initial = new Generation(0, generationSizeNum, true, true);
		GenerationList.add(initial);
		while(pop >= disciples)
		{
			//System.out.println(ageCounterForDeath);
			if(years % 3 == 0  /*&& ageCounterForDeath != 72 */)
			{
				disciples = disciples * 3;
			}
			/*else if(years % 3 == 0 && ageCounterForDeath == 72)
			{
				disciples = disciples * 2;
			} */ 
			
			if(ageCounterForAdult == 18)
			{
				for(int l = 0; l < GenerationList.size(); l++)
				{
					if(GenerationList.get(l).getName() == generationNumber)
					{
						System.out.println(generationNumber);
						GenerationList.get(l).setTrain();
					}
				}
				ageCounterForAdult = 0;
			}
			
			if(ageCounterForTraining == 21)
			{
				for(int a = 0; a < GenerationList.size(); a++)
				{
					if(GenerationList.get(a).getName() == generationNumber)
					{
						System.out.println(generationNumber);
						GenerationList.get(a).setTrainOthers();
					}
				}
				ageCounterForTraining = 0;
			}
			
			if(ageCounterForKid == 30)
			{
				System.out.println("Have Kids, Gen: " + generationNumber);
				Generation g = new Generation(generationNumber, generationSizeNum / 2 , false, false);
				generationSizeNum = generationSizeNum / 2;
				pop = pop + generationSizeNum;
				GenerationList.add(g);
				ageCounterForKid = 0;
				generationNumber++;
			}
			

			if(ageCounterForDeath == 72)
			{
				
				for(int m = 0; m < GenerationList.size(); m++)
				{
					if(GenerationList.get(m).getName() == generationDeadNum)
					{
						
						System.out.println("Gen Dead. Total Deaths: " + GenerationList.get(m).getSize());
						pop = pop - GenerationList.get(m).getSize();
						long maxDeadDisciples = 13L;
						for(int i = 0; i < 18; i++) 
						{
							maxDeadDisciples = maxDeadDisciples * 3;
						}
						disciples = disciples - maxDeadDisciples;
					}
				}
				ageCounterForDeath = 0;
			
			}
			
			
			
			ageCounterForAdult++;
			ageCounterForKid++;
			ageCounterForDeath++;
			ageCounterForTraining++;
			years++;
			System.out.println("Disciples: " + disciples + ", Population: " + pop + ", Year: " + years);

			
		}
		
		System.out.println("FINAL YEAR: Disciples: " + disciples + ", Population: " + pop + ", Year: " + years);
	}

}


