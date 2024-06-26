/*
 * Copyright (c) 2024-2030, newnoa (newnoa@aliyun.com & https://www.newnoa.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.newnoa.wheel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.newnoa.wheel.dao.mongo")
@EnableNeo4jRepositories(basePackages = "com.newnoa.wheel.dao.neo4j")
public class WheelBootstrap {
    public static void main(String... args) {
        SpringApplication.run(WheelBootstrap.class, args);
    }
}
