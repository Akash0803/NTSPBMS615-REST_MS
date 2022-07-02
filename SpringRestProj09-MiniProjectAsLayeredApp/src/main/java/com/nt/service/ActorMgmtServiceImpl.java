package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.ActorNotFoundException;
import com.nt.model.Actor;
import com.nt.repository.IActorRepo;
@Service("actorMgmtService")
public class ActorMgmtServiceImpl implements IActorMgmtService {
	@Autowired
	private IActorRepo actorRepo;
	@Override
	public String registorActor(Actor actor) {
		Actor act=actorRepo.save(actor);
		return "Actor is Register with ID value:: "+act.getActorId();
	}
	
//	@Override
//	public Iterable<Actor> getAllActors() {
//		Iterable<Actor> it=actorRepo.findAll();
//		List<Actor> list=(List<Actor>) it;
//		list.sort((t1,t2)->t1.getActorname().compareTo(t2.getActorname()));
//		
//		return list;
//	}
	
	@Override
	public Iterable<Actor> getAllActors() {
		Iterable<Actor> it=actorRepo.findAll();
		List<Actor> list=StreamSupport.stream(it.spliterator(), false)
				.sorted((t1,t2)->t1.getActorname().compareTo(t2.getActorname()))
				.collect(Collectors.toList());
		return list;
	}
	@Override
	public Actor getActorById(int id) {
//		Actor actor=actorRepo.findById(id).get();
//		return actor;
//		OR
		return actorRepo.findById(id).orElseThrow(()->new IllegalArgumentException());
		
	}
	
	@Override
	public List<Actor> fetchActorByCategory(String category1, String category2) {
		List<Actor> list=actorRepo.getActorsByCategories(category1, category2);
		return list;
	}
	
	@Override
	public String updateActor(Actor actor) {
		Optional<Actor> opt=actorRepo.findById(actor.getActorId());
		if(opt.isPresent()) {
			actorRepo.save(actor);
			return "Actor Info is Updated";
		}else {
			throw new ActorNotFoundException("Actor Not Found...!");
		}
		
	}
@Override
	public String deleteActorById(int id) {
		Optional<Actor> opt=actorRepo.findById(id);
		if(opt.isPresent()) {
			actorRepo.deleteById(id);
			return "Actor Info is Deleted";
		}else {
			throw new ActorNotFoundException("Actor Not Found");
		}
	}
	@Override
	public String updateActorMobileNo(int id, long newMobile) {
		
			Optional<Actor> opt=actorRepo.findById(id);
			if(opt.isPresent()) {
				Actor actor=opt.get();
				actor.setMobileNo(newMobile);
				actorRepo.save(actor);
				return "Actor Mobile Number Is Updated";
			}else {
			
			throw new ActorNotFoundException("Actor Not Found");
		}
		
	}
}
