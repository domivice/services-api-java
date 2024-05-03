package org.domivice.services.application.licences.queries;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.queries.BaseQuery;

@Data
@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetLicenceTypesByName extends BaseQuery {
    private String name;
}
