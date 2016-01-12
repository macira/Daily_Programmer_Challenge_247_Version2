import java.util.*; 

public class main {

	public static void main(String[] args)
	{
		Random rand = new Random();
		Scanner kb = new Scanner(System.in);
		System.out.println("How many santas are there?");
		int numberOfSantas = kb.nextInt();
		
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		
		for(int i = 0; i < numberOfSantas; i++)
		{
			int group = kb.nextInt();
			String name = kb.nextLine();
			Guest newGuest = new Guest(group, name);
			guestList.add(newGuest);
		}
		
		int counter = 0;
		boolean add = true;
		ArrayList<Guest> order = new ArrayList<Guest>();
		
		while(counter < numberOfSantas)
		{
			add = true;
			int guess = rand.nextInt(numberOfSantas);
			Guest trial = guestList.get(guess);
			if(counter == 0)
			{
				order.add(trial);
				counter++;
			}
			for(int i = 0; i < counter; i++)
			{
				if(trial.getMyName().equals(order.get(i).getMyName()))
				{
					add = false;
				}
			}
			
			if(trial.getMyNumber() == order.get(counter).getMyNumber())
			{
				add = false;
			}
			
			if(add == true)
			{
				order.add(trial);
				counter++;
			}
		}
		for(int i = 0; i < numberOfSantas - 1; i++)
		{
			System.out.println(order.get(i).getMyName()+ " --> " + order.get(i+1));
		}
		System.out.println(order.get(numberOfSantas).getMyName() + " --> " + order.get(0).getMyName());
		kb.close();
	}
	
}
