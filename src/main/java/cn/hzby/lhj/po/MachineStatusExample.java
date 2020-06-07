package cn.hzby.lhj.po;

import java.util.ArrayList;
import java.util.List;

public class MachineStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MachineStatusExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMachineNameIsNull() {
            addCriterion("machine_name is null");
            return (Criteria) this;
        }

        public Criteria andMachineNameIsNotNull() {
            addCriterion("machine_name is not null");
            return (Criteria) this;
        }

        public Criteria andMachineNameEqualTo(String value) {
            addCriterion("machine_name =", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotEqualTo(String value) {
            addCriterion("machine_name <>", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameGreaterThan(String value) {
            addCriterion("machine_name >", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameGreaterThanOrEqualTo(String value) {
            addCriterion("machine_name >=", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameLessThan(String value) {
            addCriterion("machine_name <", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameLessThanOrEqualTo(String value) {
            addCriterion("machine_name <=", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameLike(String value) {
            addCriterion("machine_name like", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotLike(String value) {
            addCriterion("machine_name not like", value, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameIn(List<String> values) {
            addCriterion("machine_name in", values, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotIn(List<String> values) {
            addCriterion("machine_name not in", values, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameBetween(String value1, String value2) {
            addCriterion("machine_name between", value1, value2, "machineName");
            return (Criteria) this;
        }

        public Criteria andMachineNameNotBetween(String value1, String value2) {
            addCriterion("machine_name not between", value1, value2, "machineName");
            return (Criteria) this;
        }

        public Criteria andAttrributeIsNull() {
            addCriterion("attrribute is null");
            return (Criteria) this;
        }

        public Criteria andAttrributeIsNotNull() {
            addCriterion("attrribute is not null");
            return (Criteria) this;
        }

        public Criteria andAttrributeEqualTo(String value) {
            addCriterion("attrribute =", value, "attrribute");
            return (Criteria) this;
        }

        public Criteria andAttrributeNotEqualTo(String value) {
            addCriterion("attrribute <>", value, "attrribute");
            return (Criteria) this;
        }

        public Criteria andAttrributeGreaterThan(String value) {
            addCriterion("attrribute >", value, "attrribute");
            return (Criteria) this;
        }

        public Criteria andAttrributeGreaterThanOrEqualTo(String value) {
            addCriterion("attrribute >=", value, "attrribute");
            return (Criteria) this;
        }

        public Criteria andAttrributeLessThan(String value) {
            addCriterion("attrribute <", value, "attrribute");
            return (Criteria) this;
        }

        public Criteria andAttrributeLessThanOrEqualTo(String value) {
            addCriterion("attrribute <=", value, "attrribute");
            return (Criteria) this;
        }

        public Criteria andAttrributeLike(String value) {
            addCriterion("attrribute like", value, "attrribute");
            return (Criteria) this;
        }

        public Criteria andAttrributeNotLike(String value) {
            addCriterion("attrribute not like", value, "attrribute");
            return (Criteria) this;
        }

        public Criteria andAttrributeIn(List<String> values) {
            addCriterion("attrribute in", values, "attrribute");
            return (Criteria) this;
        }

        public Criteria andAttrributeNotIn(List<String> values) {
            addCriterion("attrribute not in", values, "attrribute");
            return (Criteria) this;
        }

        public Criteria andAttrributeBetween(String value1, String value2) {
            addCriterion("attrribute between", value1, value2, "attrribute");
            return (Criteria) this;
        }

        public Criteria andAttrributeNotBetween(String value1, String value2) {
            addCriterion("attrribute not between", value1, value2, "attrribute");
            return (Criteria) this;
        }

        public Criteria andMinIsNull() {
            addCriterion("min is null");
            return (Criteria) this;
        }

        public Criteria andMinIsNotNull() {
            addCriterion("min is not null");
            return (Criteria) this;
        }

        public Criteria andMinEqualTo(Double value) {
            addCriterion("min =", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotEqualTo(Double value) {
            addCriterion("min <>", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThan(Double value) {
            addCriterion("min >", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinGreaterThanOrEqualTo(Double value) {
            addCriterion("min >=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThan(Double value) {
            addCriterion("min <", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinLessThanOrEqualTo(Double value) {
            addCriterion("min <=", value, "min");
            return (Criteria) this;
        }

        public Criteria andMinIn(List<Double> values) {
            addCriterion("min in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotIn(List<Double> values) {
            addCriterion("min not in", values, "min");
            return (Criteria) this;
        }

        public Criteria andMinBetween(Double value1, Double value2) {
            addCriterion("min between", value1, value2, "min");
            return (Criteria) this;
        }

        public Criteria andMinNotBetween(Double value1, Double value2) {
            addCriterion("min not between", value1, value2, "min");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}