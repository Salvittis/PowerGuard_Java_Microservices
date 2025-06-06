package br.com.powerguard.ms_admin.controller;

import br.com.powerguard.ms_admin.model.AdminLog;
import br.com.powerguard.ms_admin.model.AdminRule;
import br.com.powerguard.ms_admin.service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@Tag(name = "Admin Controller", description = "Gerencia regras administrativas e logs")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/rules")
    public List<AdminRule> getRules() {
        return adminService.getRules();
    }

    @PutMapping("/rules")
    public void updateRule(@RequestParam Long id, @RequestParam String value) {
        adminService.updateRule(id, value);
    }

    @GetMapping("/logs")
    public List<AdminLog> getLogs() {
        return adminService.getLogs();
    }
}