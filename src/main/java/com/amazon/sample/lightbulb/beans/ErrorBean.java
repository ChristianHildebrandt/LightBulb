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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;

/**
 *
 * @author Christian Hildebrandt
 */
@ManagedBean(name = "Error")
@RequestScoped
public class ErrorBean {

    /**
     * Standard constructor
     */
    public ErrorBean() {
    }

    /**
     * Build the stack trace of an uncaught exception
     * 
     * @return String with stack trace
     */
    public String getStackTrace() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestMap = context.getExternalContext().getRequestMap();

        Throwable ex = (Throwable) requestMap.get("javax.servlet.error.exception");

        StringWriter writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer);

        fillStackTrace(ex, pw);

        return writer.toString();
    }

    /**
     * Write the stack trace from an exception into a writer.
     *
     * @param ex Exception for which to get the stack trace
     * @param pw PrintWriter to write the stack trace
     */
    private void fillStackTrace(Throwable ex, PrintWriter pw) {
        if (null == ex) {
            return;
        }

        ex.printStackTrace(pw);

        if (ex instanceof ServletException) {
            Throwable cause = ((ServletException) ex).getRootCause();
            if (null != cause) {
                pw.println("Root Cause:");
                fillStackTrace(cause, pw);
            }
        } else {
             Throwable cause = ex.getCause();

            if (null != cause) {
                pw.println("Cause:");
                fillStackTrace(cause, pw);
            }
        }
    }
}
