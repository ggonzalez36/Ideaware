/*
 * Copyright 2016 the original author or authors.
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
package SpringCycle;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import SpringCycle.SortingController;
import SpringCycle.SortingService;

@RunWith(SpringRunner.class)
@WebMvcTest(SortingController.class)
public class SortingControllerTests {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private SortingService service;
    
    
    @Test
    public void test1() throws Exception {

        this.mockMvc.perform(post("/Sorting").param("number", "e1,e2,e3,e4,e5,e6"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("[e6,e5,e4,e3,e2]"));
        
        
    }
    
    @Test
    public void test2() throws Exception {

        this.mockMvc.perform(post("/Sorting").param("number", "e1,e2,e3"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("[e3,e2,e1]"));
        
        
    }
    
    @Test
    public void test3() throws Exception {

        this.mockMvc.perform(post("/Sorting").param("number", "e3, e1, e6, e0, e9, e8 "))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("[e8,e9,e0,e6,e1]"));
        
        
    }
    
    
    
 
    
    




}
