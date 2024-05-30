package org.domivice.services.application.common.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PageableQuery extends BaseQuery{
    private int page;
    private int pageSize;
    private String sort;
    public Sort getSortQuery(){
        if (sort == null || sort.isEmpty()) {
            return Sort.unsorted();
        }
        List<Sort.Order> orders = new ArrayList<>();
        String[] sortFields = sort.split(",");

        for (String field : sortFields) {
            String[] fieldAndDirection = field.split(":");
            String fieldName = fieldAndDirection[0];
            Sort.Direction direction = fieldAndDirection.length > 1
                    ? Sort.Direction.fromString(fieldAndDirection[1])
                    : Sort.Direction.ASC;
            orders.add(new Sort.Order(direction, fieldName));
        }

        return Sort.by(orders);
    }
}
