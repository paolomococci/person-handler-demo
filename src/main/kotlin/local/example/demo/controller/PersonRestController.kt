/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.demo.controller

import local.example.demo.assembler.PersonResourceAssembler
import local.example.demo.exception.PersonNotFoundException
import local.example.demo.model.Person
import local.example.demo.repository.PersonRepository
import org.springframework.hateoas.Resource
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.net.URISyntaxException

@RestController
@RequestMapping("/api/persons")
class PersonRestController(
        private val personRepository: PersonRepository,
        private val personResourceAssembler: PersonResourceAssembler
) {

    @PostMapping
    @Throws(URISyntaxException::class)
    internal fun create(@RequestBody person: Person): ResponseEntity<Resource<Person>> {
        val resource = personResourceAssembler.toResource(personRepository.save(person))
        return ResponseEntity.created(URI(resource.id.expand().href)).body(resource)
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun read(@PathVariable id: Long?): Resource<Person> {
        val person = personRepository.findById(id!!)
                .orElseThrow { PersonNotFoundException(id) }
        return personResourceAssembler.toResource(person)
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    internal fun readAll(): Resources<Resource<Person>> {
        val persons = personRepository.findAll()
                .asSequence()
                .map(personResourceAssembler::toResource).toList()
        return Resources(persons,
                linkTo(methodOn(PersonRestController::class.java).readAll()).withSelfRel())
    }

    @PutMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun update(@RequestBody update: Person, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = personRepository.findById(id!!)
                .map { temp ->
                    temp.name = update.name
                    temp.surname = update.surname
                    if (update.age!! in 0..140) {
                        temp.age = update.age
                    }
                    personRepository.save(temp)
                }
                .orElseGet {
                    personRepository.save(update)
                }
        val resource = personResourceAssembler.toResource(updated)
        return ResponseEntity.created(URI(resource.id.expand().href)).body(resource)
    }

    @PatchMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun partialUpdate(@RequestBody update: Person, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = personRepository.findById(id!!)
                .map { temp ->
                    if (!update.name.isNullOrBlank()) temp.name = update.name
                    if (!update.surname.isNullOrBlank()) temp.surname = update.surname
                    if (update.age != null) {
                        if (update.age!! in 0..140) {
                            temp.age = update.age
                        }
                    }
                    personRepository.save(temp)
                }
                .orElseGet {
                    personRepository.save(update)
                }
        val resource = personResourceAssembler.toResource(updated)
        return ResponseEntity.created(URI(resource.id.expand().href)).body(resource)
    }

    @DeleteMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun delete(@PathVariable id: Long?): ResponseEntity<*> {
        if (id != null) personRepository.deleteById(id)
        return ResponseEntity.noContent().build<Any>()
    }

    @GetMapping("/age/{age}")
    @Throws(URISyntaxException::class)
    internal fun searchByAge(@PathVariable age: Int?): Resources<Resource<Person>> {
        val persons = personRepository.findByAge(age!!)
                .asSequence()
                .map(personResourceAssembler::toResource).toList()
        return Resources(persons,
                linkTo(methodOn(PersonRestController::class.java).searchByAge(age)).withSelfRel())
    }

    @GetMapping("/name/{name}")
    @Throws(URISyntaxException::class)
    internal fun searchByName(@PathVariable name: String?): Resources<Resource<Person>> {
        val persons = personRepository.findByName(name!!)
                .asSequence()
                .map(personResourceAssembler::toResource).toList()
        return Resources(persons,
                linkTo(methodOn(PersonRestController::class.java).searchByName(name)).withSelfRel())
    }

    @GetMapping("/surname/{surname}")
    @Throws(URISyntaxException::class)
    internal fun searchBySurname(@PathVariable surname: String?): Resources<Resource<Person>> {
        val persons = personRepository.findBySurname(surname!!)
                .asSequence()
                .map(personResourceAssembler::toResource).toList()
        return Resources(persons,
                linkTo(methodOn(PersonRestController::class.java).searchBySurname(surname)).withSelfRel())
    }
}
