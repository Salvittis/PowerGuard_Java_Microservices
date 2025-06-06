package br.com.powerguard.ms_admin.repository;

import br.com.powerguard.ms_admin.model.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLogRepository extends JpaRepository<AdminLog, Long> {
}