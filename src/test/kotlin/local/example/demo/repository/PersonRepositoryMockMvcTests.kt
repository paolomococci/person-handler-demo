/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.demo.repository

import org.hamcrest.Matchers.containsString
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class PersonRepositoryMockMvcTests {

    @Autowired
    private val mockMvc: MockMvc? = null

    @Autowired
    private val personRepository: PersonRepository? = null

    private val paul: String = "{\"name\":\"Paul\",\"surname\":\"Smith\",\"age\":\"35\"}"

    @Test
    @Throws(Exception::class)
    fun `verify existence`() {
        mockMvc!!.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(jsonPath("$._links.persons").exists())
    }

    @Test
    @Throws(Exception::class)
    fun `create test`() {
        mockMvc!!.perform(post("/persons").content(paul))
                .andExpect(status().isCreated)
                .andExpect(header().string("Location", containsString("persons/")))
    }

    @Test
    @Throws(Exception::class)
    fun `retrieve test`() {
        val mvcResult = mockMvc!!.perform(post("/persons").content(paul))
                .andExpect(status().isCreated)
                .andReturn()
        val result = mvcResult.response.getHeader("Location")
        mockMvc.perform(get(result!!))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.name").value("Paul"))
                .andExpect(jsonPath("$.surname").value("Smith"))
                .andExpect(jsonPath("$.age").value(35))
    }

    @Test
    @Throws(Exception::class)
    fun `update test`() {
        val mvcResult = mockMvc!!.perform(post("/persons").content(paul))
                .andExpect(status().isCreated)
                .andReturn()
        val result = mvcResult.response.getHeader("Location")
        mockMvc.perform(put(result!!).content("{\"name\":\"Peter\",\"surname\":\"Smith\",\"age\":\"35\"}"))
                .andExpect(status().isNoContent)
        mockMvc.perform(get(result))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.name").value("Peter"))
                .andExpect(jsonPath("$.surname").value("Smith"))
                .andExpect(jsonPath("$.age").value(35))
    }

    @Test
    @Throws(Exception::class)
    fun `partial update test`() {
        val mvcResult = mockMvc!!.perform(post("/persons").content(paul))
                .andExpect(status().isCreated)
                .andReturn()
        val result = mvcResult.response.getHeader("Location")
        mockMvc.perform(patch(result!!).content("{\"age\":\"36\"}"))
                .andExpect(status().isNoContent)
        mockMvc.perform(get(result))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.age").value(36))
    }

    @Test
    @Throws(Exception::class)
    fun `delete test`() {
        val mvcResult = mockMvc!!.perform(post("/persons").content(paul))
                .andExpect(status().isCreated)
                .andReturn()
        val result = mvcResult.response.getHeader("Location")
        mockMvc.perform(delete(result!!)).andExpect(status().isNoContent)
        mockMvc.perform(get(result)).andExpect(status().isNotFound)
    }

    @Test
    @Throws(Exception::class)
    fun `verify find by path id`() {
        mockMvc!!.perform(post("/persons").content(paul))
                .andExpect(status().isCreated)
        val id = personRepository!!.findByName("Paul")[0].id
        mockMvc.perform(get("/persons/{id}", id))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.name").value("Paul"))
    }

    @Test
    @Throws(Exception::class)
    fun `verify find by name`() {
        mockMvc!!.perform(post("/persons").content(paul))
                .andExpect(status().isCreated)
        mockMvc.perform(get("/persons/search/findByName?name={name}", "Paul"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$._embedded.persons[0].age").value(35))
    }

    @Test
    @Throws(Exception::class)
    fun `verify find by surname`() {
        mockMvc!!.perform(post("/persons").content(paul))
                .andExpect(status().isCreated)
        mockMvc.perform(get("/persons/search/findBySurname?surname={surname}", "Smith"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$._embedded.persons[0].name").value("Paul"))
    }

    @Test
    @Throws(Exception::class)
    fun `verify find by age`() {
        mockMvc!!.perform(post("/persons").content(paul))
                .andExpect(status().isCreated)
        mockMvc.perform(get("/persons/search/findByAge?age={age}", 35))
                .andExpect(status().isOk)
                .andExpect(jsonPath("$._embedded.persons[0].name").value("Paul"))
    }
}
