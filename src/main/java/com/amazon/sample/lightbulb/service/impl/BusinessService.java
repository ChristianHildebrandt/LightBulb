/*
 * Copyright 2014 Christian Hildebrandt.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amazon.sample.lightbulb.service.impl;

import com.amazon.sample.lightbulb.exception.DatabaseException;
import com.amazon.sample.lightbulb.jpa.dao.ILightSwitchDao;
import com.amazon.sample.lightbulb.jpa.dao.impl.LightSwitchDao;
import com.amazon.sample.lightbulb.model.LightState;
import com.amazon.sample.lightbulb.model.LightSwitch;
import com.amazon.sample.lightbulb.service.IBusinessService;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import org.jboss.logging.Logger;

/**
 *
 * @author Christian Hildebrandt
 */
public class BusinessService implements IBusinessService {

    private final Logger LOG = Logger.getLogger(this.getClass());
    private final ILightSwitchDao lightSwitchDao;

    private static BusinessService instance;

    private BusinessService() {
        lightSwitchDao = new LightSwitchDao();
    }

    public static synchronized BusinessService getInstance() {
        if (instance == null) {
            instance = new BusinessService();
        }
        return instance;
    }

    @Override
    public LightState toggleLight(LightState currentState) throws DatabaseException {
        LightState newState = currentState.equals(LightState.OFF) ? LightState.ON : LightState.OFF;
        writeNewLightSwitch(newState);
        return newState;
    }

    @Override
    public LightState getLastLightState() throws DatabaseException {
        LightState newState = LightState.OFF;
        List<LightSwitch> allSwitches = getAllSwitches();
        if (!allSwitches.isEmpty()) {
            newState = getLastSwitch(allSwitches).getLightState();
        }
        return newState;
    }

    @Override
    public List<LightSwitch> getAllSwitches() throws DatabaseException {
        return lightSwitchDao.getAllLightSwitches();
    }

    private void writeNewLightSwitch(LightState newState) throws DatabaseException {
        LightSwitch newSwitch = new LightSwitch();
        newSwitch.setLightState(newState);
        Calendar cal = Calendar.getInstance();
        newSwitch.setToggleDate(cal.getTime());
        lightSwitchDao.addSwitch(newSwitch);
    }

    private LightSwitch getLastSwitch(List<LightSwitch> allSwitches) {
        LightSwitch newestSwitch = null;
        for (LightSwitch lightSwitch : allSwitches) {
            if (newestSwitch == null || newestSwitch.getToggleDate().compareTo(lightSwitch.getToggleDate()) > 0) {
                newestSwitch = lightSwitch;
            }
        }
        return newestSwitch;
    }
}
