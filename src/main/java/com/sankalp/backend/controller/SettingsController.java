package com.sankalp.backend.controller;

import com.sankalp.backend.entity.Settings;
import com.sankalp.backend.service.SettingsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
@CrossOrigin(origins = "http://localhost:5173")
public class SettingsController {

    private final SettingsService service;

    public SettingsController(SettingsService service) {
        this.service = service;
    }

    @GetMapping
    public Settings getSettings() {
        return service.getSettings();
    }

    @PutMapping
    public Settings updateSettings(@RequestBody Settings settings) {
        return service.saveSettings(settings);
    }
}