package org.apache.sirius.database.rule.mysql.ddl;

import org.apache.sirius.common.consts.RuleType;
import org.apache.sirius.common.enums.RuleLevel;
import org.apache.sirius.database.rule.mysql.AbstractMySQLRule;

/**
 * @author sunxien
 * @date 2025/1/15
 * @since 1.0.0-SNAPSHOT
 */
public class PartitionIsNotAllowed extends AbstractMySQLRule {

    @Override
    public boolean eval() {
        return false;
    }

    @Override
    public RuleLevel getRuleLevel() {
        return null;
    }

    @Override
    public RuleType getRuleType() {
        return null;
    }
}
