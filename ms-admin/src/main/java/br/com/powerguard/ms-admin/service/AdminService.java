package br.com.powerguard.ms_admin.service;

import br.com.powerguard.ms_admin.model.AdminLog;
import br.com.powerguard.ms_admin.model.AdminRule;
import br.com.powerguard.ms_admin.repository.AdminLogRepository;
import br.com.powerguard.ms_admin.repository.AdminRuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRuleRepository ruleRepository;
    private final AdminLogRepository logRepository;

    public List<AdminRule> getRules() {
        return ruleRepository.findAll();
    }

    public void updateRule(Long id, String value) {
        AdminRule rule = ruleRepository.findById(id).orElseThrow(() -> new RuntimeException("Regra não encontrada"));
        rule.setValue(value);
        ruleRepository.save(rule);
        logRepository.save(AdminLog.builder()
                .message("Regra atualizada: " + rule.getRuleName())
                .timestamp(LocalDateTime.now())
                .build());
    }

    public List<AdminLog> getLogs() {
        return logRepository.findAll();
    }
}