package org.apache.sirius.database.rule;

import org.apache.sirius.common.consts.RuleType;
import org.apache.sirius.common.enums.RuleLevel;

/**
 * @author sunxien
 * @date 2025/1/14
 * @since 1.0.0-SNAPSHOT
 */
public interface Rule {

    /**
     * @return boolean
     */
    public abstract boolean eval();

    /**
     * @return RuleLevel
     */
    public abstract RuleLevel getRuleLevel();


    /**
     * @return RuleType
     */
    public abstract RuleType getRuleType();
}
