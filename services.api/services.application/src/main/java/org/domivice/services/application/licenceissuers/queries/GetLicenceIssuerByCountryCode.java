package org.domivice.services.application.licenceissuers.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.queries.PageableQuery;

@Data
@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetLicenceIssuerByCountryCode extends PageableQuery {
    private String issuingCountryCode;
}
