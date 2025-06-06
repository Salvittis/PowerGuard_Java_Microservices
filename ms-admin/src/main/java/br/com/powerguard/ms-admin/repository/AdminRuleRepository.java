package br.com.powerguard.ms_admin.repository;

import br.com.powerguard.ms_admin.model.AdminRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRuleRepository extends JpaRepository<AdminRule, Long> {
}