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
package com.amazon.sample.lightbulb.jpa.dao.impl;

import com.amazon.sample.lightbulb.exception.DatabaseException;
import com.amazon.sample.lightbulb.model.LightState;
import com.amazon.sample.lightbulb.model.LightSwitch;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Hildebrandt
 */
public class LightSwitchDaoTest {

    public LightSwitchDaoTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addSwitch method, of class LightSwitchDao.
     */
    @Test
    public void testAddSwitch() {
        System.out.println("addSwitch");
        LightSwitch lightswitch = new LightSwitch();
        lightswitch.setLightState(LightState.ON);
        Date now = new Date();
        lightswitch.setToggleDate(now);
        LightSwitchDao instance = new LightSwitchDao();
        instance.addSwitch(lightswitch);
        List<LightSwitch> lastSwitch = new LinkedList<>();
        try {

            lastSwitch = instance.getLastLightSwitch();
        } catch (DatabaseException dbe) {
            System.err.println("Dabase Exception occured");
        }
        assertTrue(lastSwitch.contains(lightswitch));
        assertEquals(lightswitch, lastSwitch.get(0));
    }

    /**
     * Test of getAllLightSwitches method, of class LightSwitchDao.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllLightSwitches() throws Exception {
        System.out.println("getAllLightSwitches");
        LightSwitchDao instance = new LightSwitchDao();
        List<LightSwitch> result = instance.getAllLightSwitches();
        assertTrue(!result.isEmpty());
    }

    /**
     * Test of getLastLightSwitch method, of class LightSwitchDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetLastLightSwitch() throws Exception {
        System.out.println("getLastLightSwitch");
        LightSwitch lightswitch = new LightSwitch();
        lightswitch.setLightState(LightState.ON);
        Date now = new Date();
        lightswitch.setToggleDate(now);
        LightSwitchDao instance = new LightSwitchDao();
        instance.addSwitch(lightswitch);
        List<LightSwitch> lastSwitch = new LinkedList<>();
        try {

            lastSwitch = instance.getLastLightSwitch();
        } catch (DatabaseException dbe) {
            System.err.println("Dabase Exception occured");
        }
        assertEquals(lightswitch, lastSwitch.get(0));
    }

    /**
     * Test of getSwitchesSortedByNewest method, of class LightSwitchDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetSwitchesSortedByNewest() throws Exception {
        System.out.println("getSwitchesSortedByNewest");
        LightSwitchDao instance = new LightSwitchDao();
        List<LightSwitch> result = instance.getSwitchesSortedByNewest();
        Date now = new Date();
        for(LightSwitch lightSwitch : result){
            assertTrue(now.getTime() > lightSwitch.getToggleDate().getTime());
            now = lightSwitch.getToggleDate();
        }
    }

}
