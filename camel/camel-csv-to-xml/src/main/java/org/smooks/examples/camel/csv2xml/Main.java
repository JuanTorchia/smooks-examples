/*-
 * ========================LICENSE_START=================================
 * Smooks Example :: Smooks Camel CSV to XML
 * %%
 * Copyright (C) 2020 Smooks
 * %%
 * Licensed under the terms of the Apache License Version 2.0, or
 * the GNU Lesser General Public License version 3.0 or later.
 * 
 * SPDX-License-Identifier: Apache-2.0 OR LGPL-3.0-or-later
 * 
 * ======================================================================
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * ======================================================================
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * =========================LICENSE_END==================================
 */
package org.smooks.examples.camel.csv2xml;

import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Simple example main class.
 * 
 * @author Daniel Bevenius
 */
public class Main
{
    private static final String camelConfig = "META-INF/spring/camel-context.xml";

    public static void main(String... args) throws Exception
    {
        CamelContext camelContext = configureAndStartCamel(camelConfig);
        // Give Camel time to process the file.
        Thread.sleep(3000);
        camelContext.stop();
        printEndMessage();
    }

    private static void pause(String message)
    {
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("> " + message);
            in.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("\n");
    }

    private static CamelContext configureAndStartCamel(String camelConfig) throws Exception
    {
        ApplicationContext springContext = new ClassPathXmlApplicationContext(camelConfig);
        return (CamelContext) springContext.getBean("camelContext");
    }

    private static void printEndMessage()
    {
        System.out.println("\n\n");
        pause("And that's it!  Press 'enter' to finish...");
    }

}
