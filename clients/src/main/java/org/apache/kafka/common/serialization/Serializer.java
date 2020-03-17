/**
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE
 * file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file
 * to You under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.apache.kafka.common.serialization;

import java.io.Closeable;
import java.util.Map;

/**
 * Kafka 提供了基本的Serializer & Deserializer实现，也可以自定义实现
 *
 * @param <T> Type to be serialized from.
 *
 * A class that implements this interface is expected to have a constructor with no parameter.
 */
public interface Serializer<T> extends Closeable {

    /**
     * Configure this class.
     *
     * 在执行程序序列化之前的配置，例如StringSerializer configure就选择合适的编码类型encoding UTF-8
     *
     * @param configs configs in key/value pairs
     * @param isKey whether is for key or value
     */
    public void configure(Map<String, ?> configs, boolean isKey);

    /**
     * 真正进行序列化的地方
     *
     * @param topic topic associated with data
     * @param data typed data
     * @return serialized bytes
     */
    public byte[] serialize(String topic, T data);


    /**
     *
     * 一般为空实现
     *
     * Close this serializer.
     * This method has to be idempotent if the serializer is used in KafkaProducer because it might be called
     * multiple times.
     */
    @Override
    public void close();
}
