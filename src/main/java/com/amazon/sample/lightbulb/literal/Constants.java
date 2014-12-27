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
package com.amazon.sample.lightbulb.literal;

/**
 * Application based constants for use in any class of the application
 *
 * @author Christian Hildebrandt
 */
public class Constants {

    /**
     * Databse based constants
     */
    public static class Database {

        public static String PERSISTENCE_UNIT = "AmazonSampleDB";

        /**
         * Named queries
         */
        public static class NamedQueries {

            public static String GET_ALL_SWITCHES = "SELECT s FROM LightSwitch s";

            public static String GET_ALL_SWITCHES_SORT_BY_DATE_DESC = "SELECT s FROM LightSwitch s ORDER BY s.toggleDate DESC";

            public static String GET_LAST_SWITCH = "SELECT s FROM LightSwitch s WHERE s.toggleDate = (SELECT MAX(ls.toggleDate) FROM LightSwitch ls)";

        }

    }
}
