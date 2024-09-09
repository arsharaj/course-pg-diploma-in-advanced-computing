package com.cdac.dao;

import com.cdac.dto.AppointmentDto;
import com.cdac.pojos.Appointment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentDao extends JpaRepository<Appointment, Long> {
	List<Appointment> findByUserIdAndDateTimeAfter(Long userId, LocalDateTime now);

	Appointment save(AppointmentDto appointment);
}
