package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

	public Plan findByCodigo(String codigo) throws SQLException;

}
