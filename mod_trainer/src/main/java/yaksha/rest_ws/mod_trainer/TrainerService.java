package yaksha.rest_ws.mod_trainer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TrainerService {
	private static List<Trainer> trainerList=new ArrayList<Trainer>();
	private static int idgen=6;
	static
	{
	 trainerList.add(new Trainer(1,"Mike","Java"))	;	
	 trainerList.add(new Trainer(2,"Eric","C++"))	;
	 trainerList.add(new Trainer(3,"Sarah","DotNet"));
	 trainerList.add(new Trainer(4,"Anna","Java"))	;	
	 trainerList.add(new Trainer(5,"Steve","C++"))	;
	 trainerList.add(new Trainer(6,"Harry","DotNet"))	;
	 }
	public void save(Trainer trainer)
	{
		if(trainer.getId()==null)
			trainer.setId(++idgen);
		trainerList.add(trainer);
	}
	public List<Trainer> findAll()
	{
		return trainerList;
	}
	public Trainer findById(int id)
	{
		for(Trainer trainer:trainerList)
		{
			if(id==trainer.getId())
				return trainer;
		}
		return null;
	}
	public List<Trainer> findBySubject(String subject)
	{
		List<Trainer> subTrainerList=new ArrayList<Trainer>();
		for(Trainer trainer:trainerList)
		{
			if(subject.equalsIgnoreCase(trainer.getSubject()))
				subTrainerList.add(trainer);
		}
		return subTrainerList;
	}
	public Trainer removeTrainer(int id)
	{
		Iterator<Trainer> iterator=trainerList.iterator();
		while(iterator.hasNext())
		{
			Trainer trainer=iterator.next();
			if(id==trainer.getId())
			{
				iterator.remove();
				return trainer;
			}
			
		}
		return null;
	}
	

}
