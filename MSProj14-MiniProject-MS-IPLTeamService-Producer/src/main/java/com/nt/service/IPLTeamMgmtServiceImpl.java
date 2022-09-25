package com.nt.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.model.IPLTeam;
import com.nt.repository.IIPLTeamRepository;

import lombok.extern.slf4j.Slf4j;

@Service("teamService")
@Slf4j
public class IPLTeamMgmtServiceImpl implements IIPLTeamMgmtService {
	
	@Autowired
	private IIPLTeamRepository teamRepo;
	@Override
	public String saveTeam(IPLTeam team) {
		log.info("IPLTeamMgmtServiceImpl :: Request Came For Team Saveing");
		return "Team is Saved with :: "+teamRepo.save(team);
	}

	@Override
	public IPLTeam findTeamById(int id) {
	/*	Optional<IPLTeam> opt=teamRepo.findById(id);
		if(opt.isPresent())
			return opt.get();
		else 
			throw new IllegalArgumentException("InValid Id...?");  */
			//in Single line using Java 8
		log.info("IPLTeamMgmtServiceImpl :: Request Came For Finfing Team by ID");
			return teamRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id...?"));
		}

	@Override
	public Iterable<IPLTeam> findAllTeams() {
		log.info("IPLTeamMgmtServiceImpl :: Request Came For Showing All Teams ");
		return teamRepo.findAll();
	}

}
