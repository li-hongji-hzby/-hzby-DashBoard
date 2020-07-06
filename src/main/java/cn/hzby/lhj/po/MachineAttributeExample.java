package cn.hzby.lhj.po;

import java.util.ArrayList;
import java.util.List;

public class MachineAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MachineAttributeExample() {
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

        public Criteria andAttributeNameEnIsNull() {
            addCriterion("attribute_name_en is null");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnIsNotNull() {
            addCriterion("attribute_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnEqualTo(String value) {
            addCriterion("attribute_name_en =", value, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnNotEqualTo(String value) {
            addCriterion("attribute_name_en <>", value, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnGreaterThan(String value) {
            addCriterion("attribute_name_en >", value, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("attribute_name_en >=", value, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnLessThan(String value) {
            addCriterion("attribute_name_en <", value, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnLessThanOrEqualTo(String value) {
            addCriterion("attribute_name_en <=", value, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnLike(String value) {
            addCriterion("attribute_name_en like", value, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnNotLike(String value) {
            addCriterion("attribute_name_en not like", value, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnIn(List<String> values) {
            addCriterion("attribute_name_en in", values, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnNotIn(List<String> values) {
            addCriterion("attribute_name_en not in", values, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnBetween(String value1, String value2) {
            addCriterion("attribute_name_en between", value1, value2, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameEnNotBetween(String value1, String value2) {
            addCriterion("attribute_name_en not between", value1, value2, "attributeNameEn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnIsNull() {
            addCriterion("attribute_name_cn is null");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnIsNotNull() {
            addCriterion("attribute_name_cn is not null");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnEqualTo(String value) {
            addCriterion("attribute_name_cn =", value, "attributeNameCn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnNotEqualTo(String value) {
            addCriterion("attribute_name_cn <>", value, "attributeNameCn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnGreaterThan(String value) {
            addCriterion("attribute_name_cn >", value, "attributeNameCn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnGreaterThanOrEqualTo(String value) {
            addCriterion("attribute_name_cn >=", value, "attributeNameCn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnLessThan(String value) {
            addCriterion("attribute_name_cn <", value, "attributeNameCn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnLessThanOrEqualTo(String value) {
            addCriterion("attribute_name_cn <=", value, "attributeNameCn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnLike(String value) {
            addCriterion("attribute_name_cn like", value, "attributeNameCn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnNotLike(String value) {
            addCriterion("attribute_name_cn not like", value, "attributeNameCn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnIn(List<String> values) {
            addCriterion("attribute_name_cn in", values, "attributeNameCn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnNotIn(List<String> values) {
            addCriterion("attribute_name_cn not in", values, "attributeNameCn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnBetween(String value1, String value2) {
            addCriterion("attribute_name_cn between", value1, value2, "attributeNameCn");
            return (Criteria) this;
        }

        public Criteria andAttributeNameCnNotBetween(String value1, String value2) {
            addCriterion("attribute_name_cn not between", value1, value2, "attributeNameCn");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private final String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private final String typeHandler;

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