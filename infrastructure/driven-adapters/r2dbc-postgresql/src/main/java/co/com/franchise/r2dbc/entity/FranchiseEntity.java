package co.com.franchise.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("franchises")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FranchiseEntity {

    @Id
    @Column("id")
    private Long franchiseId;

    @Column("name")
    private String name;
}
