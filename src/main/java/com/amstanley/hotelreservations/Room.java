package com.amstanley.hotelreservations;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Room {
	
	@Id
	@GeneratedValue
	private long id;
	private String roomNumber;
	private int guestCount;
	private int bedsCount;
	private int bedsType;
	private boolean canAddCot;
	private boolean isADA;
	
	@ManyToMany
	private Collection<ReservationDate> reservedDates;
	
	@ManyToMany(mappedBy = "unreservedRooms")
	private Collection<ReservationDate> unreservedDates;
	
	public Room() {
		
	}
	
	public Room(String roomNumber, int guestCount, int bedsCount, int bedsType, boolean canAddCot, boolean isADA) {
		this.roomNumber = roomNumber;
		this.guestCount = guestCount;
		this.bedsCount = bedsCount;
		this.bedsType = bedsType;
		this.canAddCot = canAddCot;
		this.isADA = isADA;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getGuestCount() {
		return guestCount;
	}

	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}

	public int getBedsCount() {
		return bedsCount;
	}

	public void setBedsCount(int bedsCount) {
		this.bedsCount = bedsCount;
	}

	public int getBedsType() {
		return bedsType;
	}

	public void setBedsType(int bedsType) {
		this.bedsType = bedsType;
	}

	public boolean isCanAddCot() {
		return canAddCot;
	}

	public void setCanAddCot(boolean canAddCot) {
		this.canAddCot = canAddCot;
	}

	public boolean isADA() {
		return isADA;
	}

	public void setADA(boolean isADA) {
		this.isADA = isADA;
	}
	
	
	

}
