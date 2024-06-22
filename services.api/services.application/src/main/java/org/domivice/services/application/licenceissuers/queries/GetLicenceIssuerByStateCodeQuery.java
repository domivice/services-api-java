package org.domivice.services.application.licenceissuers.queries;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.queries.PageableQuery;

@Data
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class GetLicenceIssuerByStateCodeQuery extends PageableQuery {
    private String issuingStateCode;
}
