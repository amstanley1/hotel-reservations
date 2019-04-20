package com.amstanley.hotelreservations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class ReservationDate {
	
	@Id
	@GeneratedValue
	private long id;
	private LocalDate date;
	
	@ManyToMany
	private Collection<Room> reservedRooms;
	
	@ManyToMany
	private Collection<Room> unreservedRooms;

	
	public ReservationDate() {
		
	}
	
	public ReservationDate(int month, int dayOfMonth,
			int year, Room...unreservedRooms) {
		date = LocalDate.of(year, month, dayOfMonth);
		this.unreservedRooms = new HashSet<>(Arrays.asList(unreservedRooms));
	}
	
	public void reserveRoom(Room room) {
		this.unreservedRooms.remove(room);
		this.reservedRooms.add(room);
	}
	
	public long getId() {
		return this.id;
	}
	
	public String getStringDate() {
		if (date.getDayOfMonth() < 10) {
			return this.date.format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
		} else {
			return this.date.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
		}
	}
	
	

	public Collection<Room> getReservedRooms() {
		return reservedRooms;
	}

	public Collection<Room> getUnreservedRooms() {
		return unreservedRooms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationDate other = (ReservationDate) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
