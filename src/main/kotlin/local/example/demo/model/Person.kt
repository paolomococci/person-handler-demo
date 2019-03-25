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

package local.example.demo.model

import javax.persistence.*

@Entity
@Table(name = "persons")
class Person() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    var name: String? = null
    var surname: String? = null
    var age: Int? = null

    constructor(
            name: String
    ) : this() {
        this.name = name
    }

    constructor(
            name: String,
            surname: String
    ) : this() {
        this.name = name
        this.surname = surname
    }

    constructor(
            name: String,
            surname: String,
            age: Int
    ) : this() {
        this.name = name
        this.surname = surname
        this.age = age
    }
}
