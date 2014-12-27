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
package com.amazon.sample.lightbulb.beans;

import com.amazon.sample.lightbulb.exception.DatabaseException;
import com.amazon.sample.lightbulb.model.LightState;
import com.amazon.sample.lightbulb.model.LightSwitch;
import com.amazon.sample.lightbulb.service.IBusinessService;
import com.amazon.sample.lightbulb.service.impl.BusinessService;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Christian Hildebrandt
 */
@ManagedBean
@SessionScoped
public class ViewBulbBean {

    IBusinessService businessService = BusinessService.getInstance();

    private LightState currentState;

    /**
     * Standard constructor
     */
    public ViewBulbBean() {
    }

    /**
     * Get the current bulb light state from a service
     *
     * @return LightState on or off 
     * @throws DatabaseException propagated Exception from service call
     */
    public LightState getCurrentState() throws DatabaseException {

        if (currentState == null) {
            currentState = businessService.getLastLightState();
        }
        return currentState;
    }

    /**
     * Toggle light state when bulb is clicked
     * 
     * @return null to stay on page and perform a reload
     * @throws DatabaseException propagated Exception from service call
     */
    public String toggleLight() throws DatabaseException {
        currentState = businessService.toggleLight(currentState);
        return null;
    }

    /**
     * Choose a bulb image depending on current light state
     *
     * @return String name of the image
     * @throws DatabaseException propagated Exception from service call
     */
    public String getBulbImage() throws DatabaseException {
        return getCurrentState().equals(LightState.OFF) ? "lightbulb_off.png" : "lightbulb_on.png";
    }

    /**
     * Get all bulb switches from a service
     * 
     * @return List with all performed light switches
     * @throws DatabaseException propagated Exception from service call
     */
    public List<LightSwitch> getSwitchesSortedByNewest() throws DatabaseException {
        return businessService.getSwitchesSortedByNewest();
    }
}
