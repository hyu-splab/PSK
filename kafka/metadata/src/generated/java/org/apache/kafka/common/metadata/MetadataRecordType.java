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

import org.apache.kafka.common.errors.UnsupportedVersionException;
import org.apache.kafka.common.protocol.ApiMessage;

public enum MetadataRecordType {
    REGISTER_BROKER_RECORD("RegisterBrokerRecord", (short) 0, (short) 0, (short) 3),
    UNREGISTER_BROKER_RECORD("UnregisterBrokerRecord", (short) 1, (short) 0, (short) 0),
    TOPIC_RECORD("TopicRecord", (short) 2, (short) 0, (short) 0),
    PARTITION_RECORD("PartitionRecord", (short) 3, (short) 0, (short) 2),
    CONFIG_RECORD("ConfigRecord", (short) 4, (short) 0, (short) 0),
    PARTITION_CHANGE_RECORD("PartitionChangeRecord", (short) 5, (short) 0, (short) 2),
    FENCE_BROKER_RECORD("FenceBrokerRecord", (short) 7, (short) 0, (short) 0),
    UNFENCE_BROKER_RECORD("UnfenceBrokerRecord", (short) 8, (short) 0, (short) 0),
    REMOVE_TOPIC_RECORD("RemoveTopicRecord", (short) 9, (short) 0, (short) 0),
    DELEGATION_TOKEN_RECORD("DelegationTokenRecord", (short) 10, (short) 0, (short) 0),
    USER_SCRAM_CREDENTIAL_RECORD("UserScramCredentialRecord", (short) 11, (short) 0, (short) 0),
    FEATURE_LEVEL_RECORD("FeatureLevelRecord", (short) 12, (short) 0, (short) 0),
    CLIENT_QUOTA_RECORD("ClientQuotaRecord", (short) 14, (short) 0, (short) 0),
    PRODUCER_IDS_RECORD("ProducerIdsRecord", (short) 15, (short) 0, (short) 0),
    BROKER_REGISTRATION_CHANGE_RECORD("BrokerRegistrationChangeRecord", (short) 17, (short) 0, (short) 2),
    ACCESS_CONTROL_ENTRY_RECORD("AccessControlEntryRecord", (short) 18, (short) 0, (short) 0),
    REMOVE_ACCESS_CONTROL_ENTRY_RECORD("RemoveAccessControlEntryRecord", (short) 19, (short) 0, (short) 0),
    NO_OP_RECORD("NoOpRecord", (short) 20, (short) 0, (short) 0),
    ZK_MIGRATION_STATE_RECORD("ZkMigrationStateRecord", (short) 21, (short) 0, (short) 0),
    REMOVE_USER_SCRAM_CREDENTIAL_RECORD("RemoveUserScramCredentialRecord", (short) 22, (short) 0, (short) 0),
    BEGIN_TRANSACTION_RECORD("BeginTransactionRecord", (short) 23, (short) 0, (short) 0),
    END_TRANSACTION_RECORD("EndTransactionRecord", (short) 24, (short) 0, (short) 0),
    ABORT_TRANSACTION_RECORD("AbortTransactionRecord", (short) 25, (short) 0, (short) 0),
    REMOVE_DELEGATION_TOKEN_RECORD("RemoveDelegationTokenRecord", (short) 26, (short) 0, (short) 0),
    REGISTER_CONTROLLER_RECORD("RegisterControllerRecord", (short) 27, (short) 0, (short) 0);
    
    private final String name;
    private final short id;
    private final short lowestSupportedVersion;
    private final short highestSupportedVersion;
    
    MetadataRecordType(String name, short id, short lowestSupportedVersion, short highestSupportedVersion) {
        this.name = name;
        this.id = id;
        this.lowestSupportedVersion = lowestSupportedVersion;
        this.highestSupportedVersion = highestSupportedVersion;
    }
    
    public static MetadataRecordType fromId(short id) {
        switch (id) {
            case 0:
                return REGISTER_BROKER_RECORD;
            case 1:
                return UNREGISTER_BROKER_RECORD;
            case 2:
                return TOPIC_RECORD;
            case 3:
                return PARTITION_RECORD;
            case 4:
                return CONFIG_RECORD;
            case 5:
                return PARTITION_CHANGE_RECORD;
            case 7:
                return FENCE_BROKER_RECORD;
            case 8:
                return UNFENCE_BROKER_RECORD;
            case 9:
                return REMOVE_TOPIC_RECORD;
            case 10:
                return DELEGATION_TOKEN_RECORD;
            case 11:
                return USER_SCRAM_CREDENTIAL_RECORD;
            case 12:
                return FEATURE_LEVEL_RECORD;
            case 14:
                return CLIENT_QUOTA_RECORD;
            case 15:
                return PRODUCER_IDS_RECORD;
            case 17:
                return BROKER_REGISTRATION_CHANGE_RECORD;
            case 18:
                return ACCESS_CONTROL_ENTRY_RECORD;
            case 19:
                return REMOVE_ACCESS_CONTROL_ENTRY_RECORD;
            case 20:
                return NO_OP_RECORD;
            case 21:
                return ZK_MIGRATION_STATE_RECORD;
            case 22:
                return REMOVE_USER_SCRAM_CREDENTIAL_RECORD;
            case 23:
                return BEGIN_TRANSACTION_RECORD;
            case 24:
                return END_TRANSACTION_RECORD;
            case 25:
                return ABORT_TRANSACTION_RECORD;
            case 26:
                return REMOVE_DELEGATION_TOKEN_RECORD;
            case 27:
                return REGISTER_CONTROLLER_RECORD;
            default:
                throw new UnsupportedVersionException("Unknown metadata id " + id);
        }
    }
    
    public ApiMessage newMetadataRecord() {
        switch (id) {
            case 0:
                return new RegisterBrokerRecord();
            case 1:
                return new UnregisterBrokerRecord();
            case 2:
                return new TopicRecord();
            case 3:
                return new PartitionRecord();
            case 4:
                return new ConfigRecord();
            case 5:
                return new PartitionChangeRecord();
            case 7:
                return new FenceBrokerRecord();
            case 8:
                return new UnfenceBrokerRecord();
            case 9:
                return new RemoveTopicRecord();
            case 10:
                return new DelegationTokenRecord();
            case 11:
                return new UserScramCredentialRecord();
            case 12:
                return new FeatureLevelRecord();
            case 14:
                return new ClientQuotaRecord();
            case 15:
                return new ProducerIdsRecord();
            case 17:
                return new BrokerRegistrationChangeRecord();
            case 18:
                return new AccessControlEntryRecord();
            case 19:
                return new RemoveAccessControlEntryRecord();
            case 20:
                return new NoOpRecord();
            case 21:
                return new ZkMigrationStateRecord();
            case 22:
                return new RemoveUserScramCredentialRecord();
            case 23:
                return new BeginTransactionRecord();
            case 24:
                return new EndTransactionRecord();
            case 25:
                return new AbortTransactionRecord();
            case 26:
                return new RemoveDelegationTokenRecord();
            case 27:
                return new RegisterControllerRecord();
            default:
                throw new UnsupportedVersionException("Unknown metadata id " + id);
        }
    }
    
    public short id() {
        return this.id;
    }
    
    public short lowestSupportedVersion() {
        return this.lowestSupportedVersion;
    }
    
    public short highestSupportedVersion() {
        return this.highestSupportedVersion;
    }
    
    @Override
    public String toString() {
        return this.name();
    }
}
