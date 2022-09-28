package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.client.IIPLTeamServiceConsumer;
import com.nt.model.IPLPlayer;
import com.nt.model.IPLTeam;
import com.nt.repository.IIPLPlayerRepository;

import lombok.extern.slf4j.Slf4j;
@Service("playerService")
@Slf4j
public class IPLPlayerMgmtServiceImpl implements IIPLPlayerMgmtService {
	@Autowired
	private IIPLTeamServiceConsumer consumer;
	@Autowired
	private IIPLPlayerRepository playerRepo;
	 
	@Override
	public String registerPlayer(IPLPlayer player) {
		//Use Feign client MS Communication to get IPLTeam Info being Player Service
		IPLTeam team=consumer.searchTeamById(player.getTeamInfo().getTeamId()).getBody();
		log.info("Consumer Player Service has Consume Team Service Using Feign Client");
		//Assign team Object to Player Object
		player.setTeamInfo(team);
		log.info("Player Object is Saved");
		//Save layer Object
		return "Player with Team Details are Saved with Id value :: "+playerRepo.save(player).getPlayerId();
	}

	@Override
	public Iterable<IPLPlayer> showAllPlayer() {
		// Get All Players
		log.info("All Player Detais are Retrived");
		return playerRepo.findAll();
	}

}
