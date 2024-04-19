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

package com.newnoa.wheel.resource;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.semconv.SemanticAttributes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wheel")
@Slf4j
public class WheelEndpoint {
    @Autowired
    private Tracer otelTracer;

    @GetMapping("/hello")
    public String hello() {
        Span incomingSpan = Span.current();
        incomingSpan.setAttribute(SemanticAttributes.CODE_NAMESPACE, "WheelEndpoint");
        Span innerSpan = otelTracer.spanBuilder("Count response chars").startSpan();
        log.info("hello world");
        try {
            innerSpan.setAttribute("response-chars-count", "hello world".length());
            return "hello world";
        } finally {
            innerSpan.end();
        }
    }
}
