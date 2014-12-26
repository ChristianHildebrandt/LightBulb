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
import com.amazon.sample.lightbulb.service.impl.BusinessService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Christian Hildebrandt
 */
public class BusinessServiceTest {
    
     @Before
    public void setUp() {
       }
    
    @After
    public void tearDown() {
    }

     @Test
     public void testToggleLight() throws DatabaseException{
         BusinessService.getInstance().toggleLight(LightState.OFF);
     }
    
}
