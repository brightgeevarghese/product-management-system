package com.bright.pms.repository;

import com.bright.pms.model.Battery;
import com.bright.pms.model.SSD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryRepository extends JpaRepository<Battery,Long> {
}
