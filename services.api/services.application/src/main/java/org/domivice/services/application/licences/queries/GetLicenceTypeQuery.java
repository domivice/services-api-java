package org.domivice.services.application.licences.queries;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.queries.BaseQuery;

import java.util.UUID;

@Data
@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetLicenceTypeQuery extends BaseQuery {
    private UUID licenceTypeId;
}
