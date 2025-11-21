package co.com.franchise.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("stores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreEntity {

    @Id
    @Column("id")
    private Long storeId;

    @Column("name")
    private String name;

    @Column("franchise_id")
    private Long franchiseId;
}
