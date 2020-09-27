package yaksha.rest_ws.mod_trainer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrainerController {
 @Autowired
 TrainerService service;
 
 @GetMapping(path="/show-trainersJson", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Trainer> showAllTrainersInJson()
	{
		return service.findAll();
	}
	
	@GetMapping(path="/show-trainersXml", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Trainer>  showAllTrainersInXML()
	{
		return service.findAll();
	}
	
	@GetMapping(path="/show-subject-trainers/{subject}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Trainer> showSubjectTrainers(@PathVariable String subject)
	{
		List<Trainer> trainerList=service.findBySubject(subject);
		if(trainerList.size()==0)
			throw new SubjectNotFoundException("Trainer in this subject not found");
		return trainerList;
	}
	
	@DeleteMapping(path="/remove-trainer/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public String removeTrainer(@PathVariable int id)
	{
		Trainer trainer=service.removeTrainer(id);
		if(trainer==null)
			throw new TrainerNotFoundException("Wrong Trainer "+id);
		return "The Trainer id:"+trainer.getId()+" has removed";
	}
	@GetMapping(path="/trainer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Trainer retrieveOneTrainer(@PathVariable int id)
	{
		Trainer trainer=service.findById(id);
		if(trainer==null)
			throw new TrainerNotFoundException ("Trainer id "+id+" not found");
		return trainer;
		
	}
	@PostMapping(path="/add-trainer",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public String addNewTrainer(@RequestBody Trainer trainer)
	{
		service.save(trainer);
		return "New Trainer Added Successfully";
	}
}