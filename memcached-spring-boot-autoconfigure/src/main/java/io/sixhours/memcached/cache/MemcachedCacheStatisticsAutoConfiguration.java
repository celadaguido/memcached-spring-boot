/*
 * Copyright 2017 Sixhours.
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
 */

package io.sixhours.memcached.cache;

import org.springframework.boot.actuate.cache.CacheStatisticsProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link EnableAutoConfiguration Auto-configuration} for the Memcached {@link CacheStatisticsProvider} bean.
 *
 * @author Igor Bolic
 */
@Configuration
@AutoConfigureAfter(CacheAutoConfiguration.class)
@ConditionalOnBean(MemcachedCacheManager.class)
@ConditionalOnClass(CacheStatisticsProvider.class)
public class MemcachedCacheStatisticsAutoConfiguration {

    @Bean
    public MemcachedCacheStatisticsProvider memcachedCacheStatisticsProvider() {
        return new MemcachedCacheStatisticsProvider();
    }
}
