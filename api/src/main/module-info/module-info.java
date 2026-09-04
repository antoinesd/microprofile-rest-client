/*
 * Copyright (c) 2026 Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * MicroProfile Rest Client API.
 *
 * <p>
 * The API exposes Jakarta REST types ({@code Response}, {@code MultivaluedMap}, {@code Configurable}),
 * {@code @RestClient} is a {@code jakarta.inject.Qualifier} with an {@code AnnotationLiteral},
 * {@code @RegisterRestClient} is a CDI {@code @Stereotype} and providers are ordered with
 * {@code jakarta.annotation.Priority}, so those modules are required transitively.
 *
 * <p>
 * {@code DefaultClientHeadersFactoryImpl} reads MicroProfile Config when it is available; the Config
 * API is an optional ({@code provided}) dependency, hence {@code requires static}.
 */
module org.eclipse.microprofile.rest.client {
    requires java.logging;
    requires static org.eclipse.microprofile.config;
    requires transitive jakarta.annotation;
    requires transitive jakarta.cdi;
    requires transitive jakarta.inject;
    requires transitive jakarta.ws.rs;

    exports org.eclipse.microprofile.rest.client;
    exports org.eclipse.microprofile.rest.client.annotation;
    exports org.eclipse.microprofile.rest.client.ext;
    exports org.eclipse.microprofile.rest.client.inject;
    exports org.eclipse.microprofile.rest.client.spi;

    uses org.eclipse.microprofile.rest.client.spi.RestClientBuilderListener;
    uses org.eclipse.microprofile.rest.client.spi.RestClientBuilderResolver;
}
