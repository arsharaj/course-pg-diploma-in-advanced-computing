package com.cdac.controller;

import com.cdac.pojos.Appointment;
import com.cdac.dao.AppointmentDao;
import com.cdac.dto.AppointmentDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentDao appointmentDao;

	@PostMapping
	public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDto appointment) {
		// Save the appointment to the database
		System.out.println(appointment);
		Appointment savedAppointment = appointmentDao.save(appointment);
		return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
	}

	@GetMapping("/{userId}/upcoming")
	public ResponseEntity<List<Appointment>> getUpcomingAppointments(@PathVariable("userId") Long userId) {
		// Retrieve upcoming appointments for the specified user from the database
		// You may need to modify the repository method based on your data model
		List<Appointment> appointments = appointmentDao.findByUserIdAndDateTimeAfter(userId, LocalDateTime.now());
		return new ResponseEntity<>(appointments, HttpStatus.OK);
	}

	@DeleteMapping("/{appointmentId}")
	public ResponseEntity<String> cancelAppointment(@PathVariable("appointmentId") Long appointmentId) {
		// Cancel the specified appointment by deleting it from the database
		appointmentDao.deleteById(appointmentId);
		return new ResponseEntity<>("Appointment canceled successfully", HttpStatus.OK);
	}
}
