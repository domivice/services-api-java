package org.domivice.services.infrastructure.test.persistence.mongodb;

import lombok.NonNull;
import org.testcontainers.containers.MongoDBContainer;

public class DomiviceMongoDBContainer extends MongoDBContainer {
    public DomiviceMongoDBContainer(@NonNull String dockerImageName) {
        super(dockerImageName);
    }

    @Override
    public String getReplicaSetUrl(String databaseName) {
        return super.getReplicaSetUrl(databaseName) + "?authSource=admin&uuidRepresentation=standard";
    }
}
