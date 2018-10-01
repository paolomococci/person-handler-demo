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

package local.example.demo.conf

import local.example.demo.model.Person
import local.example.demo.repository.PersonRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PersonExampleItemsInitializer {
    @Bean internal fun init(personRepository: PersonRepository) = CommandLineRunner {
        personRepository.save(Person(name = "Jenny", surname = "Johnson", age = 23))
        personRepository.save(Person(name = "Jeremy", surname = "Johnson", age = 21))
        personRepository.save(Person(name = "Nike", surname = "Jameson", age = 26))
        personRepository.save(Person(name = "Zoe", surname = "Red", age = 29))
        personRepository.save(Person(name = "Chloe", surname = "Green", age = 25))
        personRepository.save(Person(name = "Johnny", surname = "Bender"))
        personRepository.save(Person(name = "Sissy"))
    }
}
