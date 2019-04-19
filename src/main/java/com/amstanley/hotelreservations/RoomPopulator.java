package com.amstanley.hotelreservations;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoomPopulator implements CommandLineRunner {
	
	@Resource
	RoomRepository roomRepo;
	
	@Resource
	ReservationDateRepository dateRepo;

	@Override
	public void run(String... args) throws Exception {
		
		
		Room one = new Room("101", 4, 2, 1, true, true);
		Room two = new Room("102", 4, 2, 1, true, true);
		Room three = new Room("103", 4, 2, 1, false, true);
		Room four = new Room("104", 4, 2, 1, true, true);
		Room five = new Room("105", 4, 2, 1, true, true);
		one = roomRepo.save(one);
		two = roomRepo.save(two);
		three = roomRepo.save(three);
		four = roomRepo.save(four);
		five = roomRepo.save(five);
		
		ReservationDate first = new ReservationDate(1, 1, 2020, one, two, three, four, five);
		ReservationDate second = new ReservationDate(1, 2, 2020, one, two, three, four, five);
		ReservationDate third = new ReservationDate(1, 3, 2020, one, two, three, four, five);
		ReservationDate fourth = new ReservationDate(1, 4, 2020, one, two, three, four, five);
		ReservationDate fifth = new ReservationDate(1, 5, 2020, one, two, three, four, five);
		
		first = dateRepo.save(first);
		second = dateRepo.save(second);
		third = dateRepo.save(third);
		fourth = dateRepo.save(fourth);
		fifth = dateRepo.save(fifth);

	}

}
