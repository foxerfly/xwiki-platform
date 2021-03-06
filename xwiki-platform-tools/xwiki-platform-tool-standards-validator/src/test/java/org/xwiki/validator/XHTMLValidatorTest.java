/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class XHTMLValidatorTest
{   
    private XHTMLValidator validator;
    
    @Before
    public void setUp() throws Exception
    {
        validator = new XHTMLValidator();
    }

    @Test
    public void testValidXHTML() throws Exception 
    {        
        validator.setDocument(getClass().getResourceAsStream("/xhtml-valid.html"));
        validator.validate();
        assertTrue(validator.getErrors().toString(), validator.getErrors().isEmpty());
    }

    @Test
    public void testInvalidXHTML() throws Exception 
    {        
        validator.setDocument(getClass().getResourceAsStream("/xhtml-invalid.html"));
        validator.validate();
        assertFalse(validator.getErrors().toString(), validator.getErrors().isEmpty());
    }
}
