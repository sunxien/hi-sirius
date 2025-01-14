package org.apache.sirius.database.rule.mysql.ddl;

import org.apache.sirius.common.consts.RuleType;
import org.apache.sirius.common.enums.RuleLevel;
import org.apache.sirius.database.rule.mysql.AbstractMySQLRule;

/**
 * @author sunxien
 * @date 2025/1/14
 * @since 1.0.0-SNAPSHOT
 */
public class PrimaryKeyIsRequired extends AbstractMySQLRule {

    @Override
    public boolean eval() {
        return false;
    }

    @Override
    public RuleLevel getRuleLevel() {
        return RuleLevel.CRITIC;
    }

    @Override
    public RuleType getRuleType() {
        return null;
    }
}
