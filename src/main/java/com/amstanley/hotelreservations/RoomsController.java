package com.amstanley.hotelreservations;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class RoomsController {
	
	@Resource
	RoomRepository roomRepo;
	
	@Resource
	ReservationDateRepository dateRepo;
	
	@RequestMapping("/rooms")
	public String findAllRooms(Model model) {
		model.addAttribute("rooms", roomRepo.findAll());
		return "rooms";
	}
	
	@RequestMapping("/dates")
	public String findAllDates(Model model) {
		model.addAttribute("dates", dateRepo.findAll());
		return "dates";
	}
	
	@RequestMapping("/dates/{dateId}")
	public String findAllDates(Model model, @PathVariable("dateId") long dateId) {
		ReservationDate date = dateRepo.findById(dateId).get();
		int doubleBeds = 0;
		int queenBeds = 0;
		model.addAttribute("date", date);
		for (Room unreservedRoom : date.getUnreservedRooms()) {
			if (unreservedRoom.getBedsType() == 1) {
				doubleBeds++;
			}
			else if (unreservedRoom.getBedsType() == 2) {
				queenBeds++;
			}
		}
		model.addAttribute("doubleBeds", doubleBeds);
		model.addAttribute("queenBeds", queenBeds);
		return "roomsForDate";
	}
	
	
	
	
	
	

}
