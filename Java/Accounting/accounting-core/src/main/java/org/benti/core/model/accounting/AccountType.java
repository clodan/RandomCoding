package org.benti.core.model.accounting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.benti.core.model.Audit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "account_types")
public class AccountType extends Audit {

    @Id
    @Column(name = "account_type_pk", nullable = false, unique = true)
    @GeneratedValue
    private long accountTypePk;

    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false, unique = true)
    private String name;
    private String description;

    @OneToMany(mappedBy = "accountType")
    private Set<Account> accounts = new HashSet<>(0);

}
