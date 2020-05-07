package cn.hzby.lhj.po;

import java.util.ArrayList;
import java.util.List;

public class MachineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MachineExample() {
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

        public Criteria andMachineNameEnIsNull() {
            addCriterion("machine_name_en is null");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnIsNotNull() {
            addCriterion("machine_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnEqualTo(String value) {
            addCriterion("machine_name_en =", value, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnNotEqualTo(String value) {
            addCriterion("machine_name_en <>", value, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnGreaterThan(String value) {
            addCriterion("machine_name_en >", value, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("machine_name_en >=", value, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnLessThan(String value) {
            addCriterion("machine_name_en <", value, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnLessThanOrEqualTo(String value) {
            addCriterion("machine_name_en <=", value, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnLike(String value) {
            addCriterion("machine_name_en like", value, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnNotLike(String value) {
            addCriterion("machine_name_en not like", value, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnIn(List<String> values) {
            addCriterion("machine_name_en in", values, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnNotIn(List<String> values) {
            addCriterion("machine_name_en not in", values, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnBetween(String value1, String value2) {
            addCriterion("machine_name_en between", value1, value2, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andMachineNameEnNotBetween(String value1, String value2) {
            addCriterion("machine_name_en not between", value1, value2, "machineNameEn");
            return (Criteria) this;
        }

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(String value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(String value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(String value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(String value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(String value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(String value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLike(String value) {
            addCriterion("product like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotLike(String value) {
            addCriterion("product not like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<String> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<String> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(String value1, String value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(String value1, String value2) {
            addCriterion("product not between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnIsNull() {
            addCriterion("machine_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnIsNotNull() {
            addCriterion("machine_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnEqualTo(String value) {
            addCriterion("machine_name_cn =", value, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnNotEqualTo(String value) {
            addCriterion("machine_name_cn <>", value, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnGreaterThan(String value) {
            addCriterion("machine_name_cn >", value, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("machine_name_cn >=", value, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnLessThan(String value) {
            addCriterion("machine_name_cn <", value, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnLessThanOrEqualTo(String value) {
            addCriterion("machine_name_cn <=", value, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnLike(String value) {
            addCriterion("machine_name_cn like", value, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnNotLike(String value) {
            addCriterion("machine_name_cn not like", value, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnIn(List<String> values) {
            addCriterion("machine_name_cn in", values, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnNotIn(List<String> values) {
            addCriterion("machine_name_cn not in", values, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnBetween(String value1, String value2) {
            addCriterion("machine_name_cn between", value1, value2, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineNameCnNotBetween(String value1, String value2) {
            addCriterion("machine_name_cn not between", value1, value2, "machineNameCn");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIsNull() {
            addCriterion("machine_type is null");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIsNotNull() {
            addCriterion("machine_type is not null");
            return (Criteria) this;
        }

        public Criteria andMachineTypeEqualTo(Integer value) {
            addCriterion("machine_type =", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotEqualTo(Integer value) {
            addCriterion("machine_type <>", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeGreaterThan(Integer value) {
            addCriterion("machine_type >", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("machine_type >=", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeLessThan(Integer value) {
            addCriterion("machine_type <", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeLessThanOrEqualTo(Integer value) {
            addCriterion("machine_type <=", value, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeIn(List<Integer> values) {
            addCriterion("machine_type in", values, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotIn(List<Integer> values) {
            addCriterion("machine_type not in", values, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeBetween(Integer value1, Integer value2) {
            addCriterion("machine_type between", value1, value2, "machineType");
            return (Criteria) this;
        }

        public Criteria andMachineTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("machine_type not between", value1, value2, "machineType");
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