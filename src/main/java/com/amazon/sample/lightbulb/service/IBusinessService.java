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
package com.amazon.sample.lightbulb.service;

import com.amazon.sample.lightbulb.exception.DatabaseException;
import com.amazon.sample.lightbulb.model.LightState;
import com.amazon.sample.lightbulb.model.LightSwitch;
import java.util.List;

/**
 * The BussinessService provides all business logic methods to turn on/off a
 * light bulb, save a switch to databse and get switches from the database.
 *
 * @author Christian Hildebrandt
 */
public interface IBusinessService {

    /**
     * Toggles the lightbulb from on to off and vice versa depending on the last
     * light state.
     *
     * @param currentState The current state of the light bulb.
     * @return Returns the toggled light state.
     * @throws DatabaseException Throws a DatabaseException if an error occurs
     * while reading/writing from/to database.
     */
    public LightState toggleLight(LightState currentState) throws DatabaseException;

    /**
     * Gets the last (newest) light state from the database.
     *
     * @return LightState ON/OFF
     * @throws DatabaseException if an error occurs while writing to the
     * database
     */
    public LightState getLastLightState() throws DatabaseException;

    /**
     * Gets all light switches from the database
     *
     * @return List of all Lightswitches found
     * @throws DatabaseException if an error occurs while writing to the
     * database
     */
    public List<LightSwitch> getAllSwitches() throws DatabaseException;

    /**
     * Gets all light switches from the databse sorted by timestamp descending
     *
     * @return Sorted list of all LightSwitches found
     * @throws DatabaseException if an error occurs while writing to the
     * database
     */
    public List<LightSwitch> getSwitchesSortedByNewest() throws DatabaseException;
;
}
