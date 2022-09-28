package com.nt.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "MS_IPLPLAYER")
@Data
public class IPLPlayer implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "pid_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer playerId;
	@Column(length = 15)
	private String playerName;
	private Integer jersyNo;
	@Column(length = 15)
	private String category;
	@ManyToOne(targetEntity = IPLTeam.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "team_uid", referencedColumnName = "teamid")
	private IPLTeam teamInfo;
}
