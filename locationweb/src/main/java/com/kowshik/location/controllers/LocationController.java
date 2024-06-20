package com.kowshik.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kowshik.location.entities.Location;
import com.kowshik.location.service.LocationService;

@Controller
public class LocationController {
	
	@Autowired
	LocationService service;
	
	@GetMapping("/showCreate")
	String showCreate() {
		return "createLocation";
	}
	@PostMapping("/saveLoc")
	String saveLocation(@ModelAttribute  Location location, ModelMap modelMap) {
		Location savedLocation = service.saveLocation(location);
		String msg = "Location saved with id : "+savedLocation.getId();
		modelMap.addAttribute("msg",msg);
		
		return "createLocation";
	}
	
	@GetMapping("/displayLocations")
	String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
;		return "displayLocations";
		
	}
	@GetMapping("/deleteLocation")
	String deleteLocation(@RequestParam int id, ModelMap modelMap) {
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
;		
		return "displayLocations";
		
	}
	
	
	@GetMapping("/showUpdate")
	String showUpdate(@RequestParam int id, ModelMap modelMap) {
		Location location = service.getLocationbyId(id);
		modelMap.addAttribute("location",location);
		return "updateLocation";
	}
	@PostMapping("/updateLoc")
	String updateLoc(@ModelAttribute  Location location, ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		
		return "displayLocations";
	}
}
