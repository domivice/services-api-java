package org.domivice.services.application.licencetypes.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
