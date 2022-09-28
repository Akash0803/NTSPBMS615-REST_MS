package com.nt.service;

import org.springframework.stereotype.Service;
import com.nt.model.IPLPlayer;

public interface IIPLPlayerMgmtService {
	public String registerPlayer(IPLPlayer player);
	public Iterable<IPLPlayer> showAllPlayer();
}
