package com.sankalp.backend.service;

import com.sankalp.backend.entity.Settings;

public interface SettingsService {

    Settings getSettings();

    Settings saveSettings(Settings settings);

}