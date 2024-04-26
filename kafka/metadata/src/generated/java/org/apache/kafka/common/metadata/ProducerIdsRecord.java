/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// THIS CODE IS AUTOMATICALLY GENERATED.  DO NOT EDIT.

package org.apache.kafka.common.metadata;

import java.util.ArrayList;
import java.util.List;
import org.apache.kafka.common.protocol.ApiMessage;
import org.apache.kafka.common.protocol.MessageSizeAccumulator;
import org.apache.kafka.common.protocol.MessageUtil;
import org.apache.kafka.common.protocol.ObjectSerializationCache;
import org.apache.kafka.common.protocol.Readable;
import org.apache.kafka.common.protocol.Writable;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.protocol.types.RawTaggedField;
import org.apache.kafka.common.protocol.types.RawTaggedFieldWriter;
import org.apache.kafka.common.protocol.types.Schema;
import org.apache.kafka.common.protocol.types.Type;
import org.apache.kafka.common.utils.ByteUtils;

import static org.apache.kafka.common.protocol.types.Field.TaggedFieldsSection;


public class ProducerIdsRecord implements ApiMessage {
    int brokerId;
    long brokerEpoch;
    long nextProducerId;
    private List<RawTaggedField> _unknownTaggedFields;
    
    public static final Schema SCHEMA_0 =
        new Schema(
            new Field("broker_id", Type.INT32, "The ID of the requesting broker"),
            new Field("broker_epoch", Type.INT64, "The epoch of the requesting broker"),
            new Field("next_producer_id", Type.INT64, "The next producerId that will be assigned (i.e. the first producerId in the next assigned block)"),
            TaggedFieldsSection.of(
            )
        );
    
    public static final Schema[] SCHEMAS = new Schema[] {
        SCHEMA_0
    };
    
    public static final short LOWEST_SUPPORTED_VERSION = 0;
    public static final short HIGHEST_SUPPORTED_VERSION = 0;
    
    public ProducerIdsRecord(Readable _readable, short _version) {
        read(_readable, _version);
    }
    
    public ProducerIdsRecord() {
        this.brokerId = 0;
        this.brokerEpoch = -1L;
        this.nextProducerId = 0L;
    }
    
    @Override
    public short apiKey() {
        return 15;
    }
    
    @Override
    public short lowestSupportedVersion() {
        return 0;
    }
    
    @Override
    public short highestSupportedVersion() {
        return 0;
    }
    
    @Override
    public final void read(Readable _readable, short _version) {
        this.brokerId = _readable.readInt();
        this.brokerEpoch = _readable.readLong();
        this.nextProducerId = _readable.readLong();
        this._unknownTaggedFields = null;
        int _numTaggedFields = _readable.readUnsignedVarint();
        for (int _i = 0; _i < _numTaggedFields; _i++) {
            int _tag = _readable.readUnsignedVarint();
            int _size = _readable.readUnsignedVarint();
            switch (_tag) {
                default:
                    this._unknownTaggedFields = _readable.readUnknownTaggedField(this._unknownTaggedFields, _tag, _size);
                    break;
            }
        }
    }
    
    @Override
    public void write(Writable _writable, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        _writable.writeInt(brokerId);
        _writable.writeLong(brokerEpoch);
        _writable.writeLong(nextProducerId);
        RawTaggedFieldWriter _rawWriter = RawTaggedFieldWriter.forFields(_unknownTaggedFields);
        _numTaggedFields += _rawWriter.numFields();
        _writable.writeUnsignedVarint(_numTaggedFields);
        _rawWriter.writeRawTags(_writable, Integer.MAX_VALUE);
    }
    
    @Override
    public void addSize(MessageSizeAccumulator _size, ObjectSerializationCache _cache, short _version) {
        int _numTaggedFields = 0;
        _size.addBytes(4);
        _size.addBytes(8);
        _size.addBytes(8);
        if (_unknownTaggedFields != null) {
            _numTaggedFields += _unknownTaggedFields.size();
            for (RawTaggedField _field : _unknownTaggedFields) {
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.tag()));
                _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_field.size()));
                _size.addBytes(_field.size());
            }
        }
        _size.addBytes(ByteUtils.sizeOfUnsignedVarint(_numTaggedFields));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ProducerIdsRecord)) return false;
        ProducerIdsRecord other = (ProducerIdsRecord) obj;
        if (brokerId != other.brokerId) return false;
        if (brokerEpoch != other.brokerEpoch) return false;
        if (nextProducerId != other.nextProducerId) return false;
        return MessageUtil.compareRawTaggedFields(_unknownTaggedFields, other._unknownTaggedFields);
    }
    
    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode = 31 * hashCode + brokerId;
        hashCode = 31 * hashCode + ((int) (brokerEpoch >> 32) ^ (int) brokerEpoch);
        hashCode = 31 * hashCode + ((int) (nextProducerId >> 32) ^ (int) nextProducerId);
        return hashCode;
    }
    
    @Override
    public ProducerIdsRecord duplicate() {
        ProducerIdsRecord _duplicate = new ProducerIdsRecord();
        _duplicate.brokerId = brokerId;
        _duplicate.brokerEpoch = brokerEpoch;
        _duplicate.nextProducerId = nextProducerId;
        return _duplicate;
    }
    
    @Override
    public String toString() {
        return "ProducerIdsRecord("
            + "brokerId=" + brokerId
            + ", brokerEpoch=" + brokerEpoch
            + ", nextProducerId=" + nextProducerId
            + ")";
    }
    
    public int brokerId() {
        return this.brokerId;
    }
    
    public long brokerEpoch() {
        return this.brokerEpoch;
    }
    
    public long nextProducerId() {
        return this.nextProducerId;
    }
    
    @Override
    public List<RawTaggedField> unknownTaggedFields() {
        if (_unknownTaggedFields == null) {
            _unknownTaggedFields = new ArrayList<>(0);
        }
        return _unknownTaggedFields;
    }
    
    public ProducerIdsRecord setBrokerId(int v) {
        this.brokerId = v;
        return this;
    }
    
    public ProducerIdsRecord setBrokerEpoch(long v) {
        this.brokerEpoch = v;
        return this;
    }
    
    public ProducerIdsRecord setNextProducerId(long v) {
        this.nextProducerId = v;
        return this;
    }
}
