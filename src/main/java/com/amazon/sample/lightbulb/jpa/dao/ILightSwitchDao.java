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
package com.amazon.sample.lightbulb.jpa.dao;

import com.amazon.sample.lightbulb.exception.DatabaseException;
import com.amazon.sample.lightbulb.model.LightSwitch;
import java.util.List;

/**
 *
 * @author Christian Hildebrandt
 */
public interface ILightSwitchDao {

    /**
     * Adds a LightSwitch to the backend system
     *
     * @param lightswitch LightSwitch that has to be added
     * @throws DatabaseException if an error occurs while writing to the
     * database
     */
    public void addSwitch(LightSwitch lightswitch) throws DatabaseException;

    /**
     * Gets all dataset of LightSwitch from the database
     *
     * @return List of all LightSwitches found in the databse
     * @throws DatabaseException if an error occurs while writing to the
     * database
     */
    public List<LightSwitch> getAllLightSwitches() throws DatabaseException;

    /**
     * Gets the last saved LightSwitch from the database
     *
     * @return List which holds the last LightSwitch
     * @throws DatabaseException if an error occurs while reading from the
     * database
     */
    public List<LightSwitch> getLastLightSwitch() throws DatabaseException;

    /**
     * Gets a by timestamp sorted List of all LightSwitches
     *
     * @return @throws DatabaseException if an error occurs while reading from the
     * database
     */
    public List<LightSwitch> getSwitchesSortedByNewest() throws DatabaseException;

}
