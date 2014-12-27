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

import com.amazon.sample.lightbulb.model.LightState;
import com.amazon.sample.lightbulb.model.LightSwitch;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Hildebrandt
 */
public class BusinessServiceTest {
    
    LightSwitch lightSwitch;
    Date toggleDate = new Date();
    LightState currentState = LightState.ON;
    
    public BusinessServiceTest() {
    }
    
    @Before
    public void setUp() {
         lightSwitch = new LightSwitch();
         lightSwitch.setLightState(currentState);
         lightSwitch.setToggleDate(toggleDate);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class BusinessService.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        BusinessService result = BusinessService.getInstance();
        assertTrue(null != result);
    }

    /**
     * Test of toggleLight method, of class BusinessService.
     * @throws java.lang.Exception
     */
    @Test
    public void testToggleLight() throws Exception {
        System.out.println("toggleLight");
        BusinessService instance = BusinessService.getInstance();
        LightState result = instance.toggleLight(currentState);
        assertEquals(result, LightState.OFF);
        currentState = LightState.OFF;
        result = instance.toggleLight(currentState);
        assertEquals(result, LightState.ON);
    }

    /**
     * Test of getLastLightState method, of class BusinessService.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetLastLightState() throws Exception {
        System.out.println("getLastLightState");
        BusinessService instance = BusinessService.getInstance();
        instance.toggleLight(currentState);
        LightState result = instance.getLastLightState();
        assertEquals(LightState.OFF, result);
    }

    /**
     * Test of getAllSwitches method, of class BusinessService.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllSwitches() throws Exception {
        System.out.println("getAllSwitches");
        BusinessService instance = BusinessService.getInstance();
        List<LightSwitch> result = instance.getAllSwitches();
        assertTrue(!result.isEmpty());
    }

    /**
     * Test of getSwitchesSortedByNewest method, of class BusinessService.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetSwitchesSortedByNewest() throws Exception {
        System.out.println("getSwitchesSortedByNewest");
        BusinessService instance = BusinessService.getInstance();
        List<LightSwitch> result = instance.getSwitchesSortedByNewest();
        Date now = new Date();
        for(LightSwitch ls : result){
            assertTrue(now.getTime() > ls.getToggleDate().getTime());
            now = ls.getToggleDate();
        }
    }
    
}
